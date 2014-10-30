package com.thoughtworks.iamcoach.pos.module.promotion;

import com.thoughtworks.iamcoach.pos.module.Item;
import com.thoughtworks.iamcoach.pos.module.promotion.Promotion;

public class BuyTwoOneFreePromotion extends Promotion {
    public BuyTwoOneFreePromotion() {
    }

    public BuyTwoOneFreePromotion(int id, int type, String description, double discount) {
        super(id, type, description, discount);
    }

    @Override
    public double calcultaPromotion(Item item, double num) {
        double promotionNumber = ((int) num)/3;
        double actualNumber = num - promotionNumber;
        return actualNumber * item.getPrice();
    }
}
