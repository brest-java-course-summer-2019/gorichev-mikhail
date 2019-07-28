package com.training.payments.dao;

import com.training.payments.model.Category;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class CategoryDaoJdbcImpl implements CategoryDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SELECT_ALL =
            "select c.category_id, c.category_name, c.category_description from categories c order by 2";

    private final static String FIND_BY_ID =
            "select category_id, category_name, category_description from categories where category_id = :categoryId";

    private final static String FIND_BY_NAME =
            "select category_id, category_name, category_description from categories where category_name = :categoryName";

    private final static String ADD_CATEGORY =
            "insert into categories (category_name, category_description) values (:categoryName, :categoryDescription)";

    private final static String UPDATE_CATEGORY =
            "update categories set category_name = :categoryName, "
                    + "category_description = :categoryDescription "
                    + "where category_id = :categoryId";

    private final static String DELETE_CATEGORY = "delete from categories where category_id = :categoryId";

    private final static String CATEGORY_ID = "categoryId";
    private final static String CATEGORY_NAME = "categoryName";

    public CategoryDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Category add(Category category) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("categoryName", category.getCategoryName());
        parameters.addValue("categoryDescription", category.getCategoryDescription());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(ADD_CATEGORY, parameters, generatedKeyHolder);
        category.setCategoryId(generatedKeyHolder.getKey().intValue());
        return category;
    }

    @Override
    public void update(Category category) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE_CATEGORY, new BeanPropertySqlParameterSource(category)))
                .filter(this::successfullyUpdated)
                .orElseThrow(()-> new RuntimeException("Failed to update category in DataBase"));

    }

    @Override
    public void delete(Integer categoryId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(CATEGORY_ID, categoryId);
        Optional.of(namedParameterJdbcTemplate.update(DELETE_CATEGORY, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to delete category in DataBase"));
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public List<Category> findAll() {
        return namedParameterJdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Category.class));
    }

    @Override
    public Optional<Category> findByName(String categoryName) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CATEGORY_NAME, categoryName);
        List<Category> results = namedParameterJdbcTemplate.query(FIND_BY_NAME, namedParameters,
                BeanPropertyRowMapper.newInstance(Category.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public Optional<Category> findById(Integer categoryId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(CATEGORY_ID, categoryId);
        List<Category> results = namedParameterJdbcTemplate.query(FIND_BY_ID, namedParameters,
                BeanPropertyRowMapper.newInstance(Category.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }


}
