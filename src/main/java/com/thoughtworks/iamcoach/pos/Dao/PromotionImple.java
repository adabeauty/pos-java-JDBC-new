package com.thoughtworks.iamcoach.pos.Dao;

import com.thoughtworks.iamcoach.pos.Ulti.ConnctionUlti;
import com.thoughtworks.iamcoach.pos.module.promotion.Promotion;
import com.thoughtworks.iamcoach.pos.module.promotion.PromotionFactory;

import java.sql.*;
import java.util.ArrayList;

public class PromotionImple implements PromotionDao {
    private ConnctionUlti connctionUlti = new ConnctionUlti();

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        Connection connection = connctionUlti.getConnection();
        Promotion promotion = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, type);

            result = preparedStatement.executeQuery();
            result.next();

            promotion = PromotionFactory.generatePromotion(result.getInt("type"));

            promotion.setId(result.getInt("id"));
            promotion.setId(result.getInt("type"));
            promotion.setDescription(result.getString("description"));
            if(result.getInt("type") == 3){
                promotion.setDiscount(result.getDouble("discount"));
            }

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }

    @Override
    public ArrayList<Promotion> getPromotions() {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT * FROM promotions";

        Promotion promotion = null;
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);

            result = preparedStatement.executeQuery(sql);
            while (result.next()){
                promotion = PromotionFactory.generatePromotion(result.getInt("type"));

                promotion.setId(result.getInt("id"));
                promotion.setId(result.getInt("type"));
                promotion.setDescription(result.getString("description"));
                promotion.setDiscount(result.getDouble("discount"));

                promotions.add(promotion);
            }
            closeAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    private void closeAll(){
        connctionUlti.closeConnection();
        try {
            preparedStatement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private Promotion generatePromotion(type){
//        Promotion promotion =  promotion = PromotionFactory.generatePromotion(type);
//
//        promotion.setId(id);
//        promotion.setId(type);
//        promotion.setDescription(description);
//        if(type == 3){
//            rs.getDouble("discount");
//        }
//        return promotion;
//    }
}
