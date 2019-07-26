package com.training.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    private Category category = new Category();

    @Test
    public void getCategoryId() {
        category.setCategoryId(10);
        Assert.assertEquals(category.getCategoryId().intValue(),10);
    }

    @Test
    public void getCategoryName() {
        category.setCategoryName("Name");
        Assert.assertEquals(category.getCategoryName(), "Name");
    }

    @Test
    public void getCategoryDescription() {
        category.setCategoryDescription("Test description");
        Assert.assertEquals(category.getCategoryDescription(), "Test description");
    }

    @Test
    public void getPaymentsCount() {
        category.setPaymentsCount(10);
        Assert.assertEquals(category.getPaymentsCount().intValue(), 10);
    }


}