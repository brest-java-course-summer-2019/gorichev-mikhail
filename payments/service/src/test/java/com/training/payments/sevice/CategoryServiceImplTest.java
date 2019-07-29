package com.training.payments.sevice;

import com.training.payments.model.Category;
import com.training.payments.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath:test-service.xml"})
public class CategoryServiceImplTest {

    private static final String MEDICINE = "Medicine";
    private static final String SOCIAL = "Social";
    private static final String TEST_NAME = "TEST_NAME";
    private static final String TEST_DESCRIPTION = "TEST_DESCRIPTION";
    private static final String UPDATE_NAME = "UPDATE_NAME";
    private static final String UPDATE_DESCRIPTION = "UPDATE DESCRIPTION";
    private static final String DELETE_NAME = "DELETE NAME";

    @Autowired
    private CategoryService categoryService;

    @Test
    void findAll() {
        List<Category> categories = categoryService.findAll();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    void findById() {
        Category category = categoryService.findById(2);

        assertNotNull(category);
        assertEquals(MEDICINE, category.getCategoryName());
    }

    @Test
    void findByName() {
        Category category = categoryService.findByName(SOCIAL);

        assertNotNull(category);
        assertEquals(category.getCategoryId().intValue(), 1);
    }

    @Test
    void add() {
        int sizeBeforeAdding = categoryService.findAll().size();
        Category category = new Category(TEST_NAME, TEST_DESCRIPTION);
        categoryService.add(category);

        assertTrue(categoryService.findAll().size() > sizeBeforeAdding);
        assertNotNull(categoryService.findByName(TEST_NAME));
    }

    @Test
    void update() {
        Category category = new Category(TEST_NAME, TEST_DESCRIPTION);
        categoryService.add(category);
        int id = category.getCategoryId();
        category.setCategoryName(UPDATE_NAME);
        category.setCategoryDescription(UPDATE_DESCRIPTION);
        categoryService.update(category);
        category = categoryService.findById(id);

        assertNotNull(category);
        assertEquals(category.getCategoryName(), UPDATE_NAME);
        assertEquals(category.getCategoryDescription(), UPDATE_DESCRIPTION);
    }

    @Test
    void remove() {
        Category category = new Category(DELETE_NAME, TEST_DESCRIPTION);
        categoryService.add(category);
        int sizeBeforeDeleting = categoryService.findAll().size();
        categoryService.delete(category.getCategoryId());

        Assertions.assertThrows(RuntimeException.class, () -> categoryService.findByName(DELETE_NAME));
        assertTrue(sizeBeforeDeleting > categoryService.findAll().size());
    }

}
