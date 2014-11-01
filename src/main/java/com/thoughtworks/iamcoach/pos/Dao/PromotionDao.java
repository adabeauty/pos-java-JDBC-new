package com.thoughtworks.iamcoach.pos.Dao;

import com.thoughtworks.iamcoach.pos.model.promotion.Promotion;

import java.util.ArrayList;

public interface PromotionDao {
    Promotion getPromotionByType(int type);

    ArrayList<Promotion> getPromotions();
}
