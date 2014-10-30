package com.thoughtworks.iamcoach.pos.Dao;

import com.thoughtworks.iamcoach.pos.module.*;
import com.thoughtworks.iamcoach.pos.Ulti.ConnctionUlti;

import java.sql.*;
import java.util.ArrayList;

public class ItemImple implements ItemDao {
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ConnctionUlti connctionUlti = new ConnctionUlti();

    @Override
    public Item getItemByBarcode(String barcode) {
        String sql = "SELECT * FROM items WHERE barcode = ?";
        Item item = null;
        Connection conn = connctionUlti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, barcode);
            rs = pstmt.executeQuery();
            rs.next();
            item = new Item(rs.getString("id"), rs.getInt("categoryId"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));

            connctionUlti.closeConnection();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM items";

        Item item = null;
        Connection conn = connctionUlti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery(sql);
            while (rs.next()){
                item = new Item(rs.getString("id"), rs.getInt("categoryId"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));
                items.add(item);
            }

            connctionUlti.closeConnection();
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public ArrayList<Promotion> getPromotions(int id) {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";

        Connection connection = connctionUlti.getConnection();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs = pstmt.executeQuery();
            while(rs.next()){
                Promotion promotion =PromotionFactory.generatePromotion(rs.getInt("type"));

                promotion.setId(rs.getInt("id"));
                promotion.setId(rs.getInt("type"));
                promotion.setDescription(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));

                promotions.add(promotion);
            }

            connctionUlti.closeConnection();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotions;
    }

    @Override
    public Category getCategory(int id) {
        String sql = "SELECT categories.name, items.* FROM categories, items "+
                "WHERE items.id = ? AND categories.id = items.categoryId" ;

        Category category = null;
        Connection connection = connctionUlti.getConnection();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs = pstmt.executeQuery();
            rs.next();
            category = new Category(rs.getString("id"), rs.getString("name"));

            connctionUlti.closeConnection();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
