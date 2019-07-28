package com.training.payments.dao;

import com.training.payments.model.Payment;
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

public class PaymentDaoJdbcImpl implements PaymentDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String FIND_ALL =
            "select p.payment_id, p.payment_name, p.payment_description, p.payment_cost, p.category_id "
                    + "from payments p order by 2";

    private final static String FIND_BY_ID =
            "select payment_id, payment_name, payment_description, payment_cost, category_id "
                    + "from payments where payments_id = :paymentsId";

    private final static String FIND_BY_NAME =
            "select payment_id, payment_name, payment_description, payment_cost, category_id "
                    + "from payments where payments_name = :paymentsName";

    private final static String FIND_BY_CATEGORY_ID =
            "select p.payment_id, p.payment_name, p.payment_description, p.payment_cost, p.category_id "
                    + "from payments p where category_id = :categoryId order by 2";

    private final static String ADD_PAYMENT =
            "insert into payments (payment_id, payment_name, payment_description, payment_cost, category_id) "
            + "values (:payment_id, :payment_name, :payment_description, :payment_cost, :category_id)";

    private final static String DELETE_PAYMENT =
            "delete from payments where payment_id = :paymentId";

    private final static String UPDATE_PAYMENT =
            "update payments set payment_name = :paymentName, "
            + "payment_description = :paymentDescription, "
            + "payment_cost = :paymentCost, "
            + "category_id = :categoryId, "
            + "where payment_id = :paymentId";

    private final static String PAYMENT_ID = "paymentId";
    private final static String PAYMENT_NAME = "paymentName";

    public PaymentDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Payment add(Payment payment) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("paymentId", payment.getPaymentId());
        parameters.addValue("paymentName", payment.getPaymentName());
        parameters.addValue("paymentDescription", payment.getPaymentDescription());
        parameters.addValue("paymentCost", payment.getPaymentCost());
        parameters.addValue("categoryId", payment.getCategoryId());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(ADD_PAYMENT, parameters, generatedKeyHolder);
        payment.setPaymentId(generatedKeyHolder.getKey().intValue());
        return payment;
    }

    @Override
    public void update(Payment payment) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE_PAYMENT, new BeanPropertySqlParameterSource(payment)))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to update category in DataBase"));
    }

    @Override
    public void delete(Integer paymentId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(PAYMENT_ID, paymentId);
        Optional.of(namedParameterJdbcTemplate.update(DELETE_PAYMENT, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to delete payment in DataBase"));
    }

    private boolean successfullyUpdated(int numRowsUpdated) {
        return numRowsUpdated > 0;
    }

    @Override
    public List<Payment> findAll() {
        return namedParameterJdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Payment.class));
    }

    @Override
    public Optional<Payment> findById(Integer paymentId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(PAYMENT_ID, paymentId);
        List<Payment> results = namedParameterJdbcTemplate.query(FIND_BY_ID, namedParameters,
                BeanPropertyRowMapper.newInstance(Payment.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public Optional<Payment> findByName(String paymentName) {
        SqlParameterSource namedParameters = new MapSqlParameterSource(PAYMENT_NAME, paymentName);
        List<Payment> results = namedParameterJdbcTemplate.query(FIND_BY_NAME, namedParameters,
                BeanPropertyRowMapper.newInstance(Payment.class));
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public List<Payment> findByCategoryId(Integer categoryId) {
        return namedParameterJdbcTemplate.query(FIND_BY_CATEGORY_ID, BeanPropertyRowMapper.newInstance(Payment.class));
    }
}
