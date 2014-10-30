package com.thoughtworks.iamcoach.pos.Dao;

import com.thoughtworks.iamcoach.pos.Ulti.ConnctionUlti;
import com.thoughtworks.iamcoach.pos.module.Category;

import java.sql.*;

import java.util.ArrayList;

public class CategoryImple implements CategoryDao{
    private ConnctionUlti connctionUlti = new ConnctionUlti();
    
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    @Override
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM categories";

        Category promotion = null;
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category(resultSet.getString("id"), resultSet.getString("name"));
                categories.add(category);
            }

            connctionUlti.closeConnection();
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        Category category = null;
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            category = new Category(resultSet.getString("id"), resultSet.getString("name"));

            connctionUlti.closeConnection();
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
