package com.training.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category = new Category();

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
    public void testToString() {
        String expected = "Category{categoryId=null, categoryName=null}";
        Assert.assertEquals(category.toString(), expected);
    }

}