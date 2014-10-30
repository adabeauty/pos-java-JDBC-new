package com.thoughtworks.iamcoach.pos.Dao;


import com.thoughtworks.iamcoach.pos.module.Category;
import java.util.ArrayList;

public interface CategoryDao {
    ArrayList<Category> getCategories();

    Category getCategoryById(int id);
}
