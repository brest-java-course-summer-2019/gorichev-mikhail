package com.training.payments.dao;

import com.training.payments.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
public class CategoryDaoJdbcImplTest {

    private static final String SOCIAL = "Social";
    private static final String TAX = "Tax";
    private static final String CATEGORY = "Category";
    private static final String NEW_CATEGORY = "New Category";
    private static final String EMPTY = "EMPTY";


    @Autowired
    CategoryDao categoryDao;

    @Test
    public void findAll() {
        List<Category> categories = categoryDao.findAll();
        assertNotNull(categories);
        assertTrue(categories.size() > 0);
    }

    @Test
    public void findById() {
        Category category = categoryDao.findById(1).get();
        assertNotNull(category);
        assertEquals(category.getCategoryId().intValue(), 1);
        assertEquals(category.getCategoryName(), SOCIAL);
    }

    @Test
    public void findByName() {
        Category category = categoryDao.findByName(TAX).get();
        assertNotNull(category);
        assertEquals(category.getCategoryName(), TAX);
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setCategoryName(EMPTY);
        category.setCategoryDescription("ANY DESCRIPTION");
        Category newCategory = categoryDao.add(category);
        assertNotNull(newCategory.getCategoryId());
    }

    @Test
    public void updateCategory() {
        Category category = new Category(CATEGORY, "Temporary Description");
        category = categoryDao.add(category);
        category.setCategoryName(NEW_CATEGORY);
        categoryDao.update(category);
        Category updatedCategory = categoryDao.findById(category.getCategoryId()).get();
        assertEquals(category.getCategoryId(), updatedCategory.getCategoryId());
        assertEquals(category.getCategoryName(), updatedCategory.getCategoryName());
        assertEquals(category.getCategoryDescription(), updatedCategory.getCategoryDescription());
    }

    @Test
    public void removeCategory() {
        Category category = new Category(NEW_CATEGORY, "DESCRIPTION");
        category = categoryDao.add(category);
        categoryDao.delete(category.getCategoryId());
        assertEquals(categoryDao.findByName(NEW_CATEGORY), Optional.empty());
    }
}