package com.thoughtworks.iamcoach.pos.model.promotion;

import com.thoughtworks.iamcoach.pos.model.Item;

public class SeconHalfPromotion extends Promotion {
    public SeconHalfPromotion() {
    }

    public SeconHalfPromotion(int id, int type, String description, double discount) {
        super(id, type, description, discount);
    }

    @Override
    public double calcultaPromotion(Item item, double num) {
        double promotionNumber = ((int) num)/2;
        double actualNumber = (num - promotionNumber) + promotionNumber/2;
        return actualNumber * item.getPrice();
    }
}
