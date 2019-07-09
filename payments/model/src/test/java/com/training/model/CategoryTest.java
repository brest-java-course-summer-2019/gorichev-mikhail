package com.training.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category = new Category();

    @Test
    public void getCategoryId() {
        category.setCategoryId(10);
        Assert.assertTrue(category.getCategoryId().equals(10));
    }

    @Test
    public void getCategoryName() {
        category.setCategoryName("Name");
        Assert.assertTrue(category.getCategoryName().equals("Name"));
    }


}