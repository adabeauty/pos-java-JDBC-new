package com.thoughtworks.iamcoach.pos.module.promotion;

import com.thoughtworks.iamcoach.pos.module.Item;
import com.thoughtworks.iamcoach.pos.module.promotion.Promotion;

public class DiscountPromotion extends Promotion {
    public DiscountPromotion() {
    }

    public DiscountPromotion(int id, int type, String description, double discount) {
        super(id, type, description, discount);
    }

    @Override
    public double calcultaPromotion(Item item, double num) {
        return item.getPrice() * num * getDiscount();
    }
}
