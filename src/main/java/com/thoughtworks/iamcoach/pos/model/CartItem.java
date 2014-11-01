package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.model.promotion.Promotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartItem extends Item{
    private double num;
    private List<Promotion> promotionList = new ArrayList<Promotion>();

    public CartItem(Item item, double num, ArrayList<Promotion> promotionList) {
        super(item.getId(), item.getCategoryId(), item.getBarcode(), item.getName(), item.getUnit(), item.getPrice());
        this.num = num;
        this.promotionList = promotionList;
    }

    public double getNum() {
        return this.num;
    }

    public void setNum(double num) {
        this.num  = num;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public double getSubtotal() {
        ArrayList<Double> allSubTotals = new ArrayList<Double>();

        Item item = new Item(this.getId(), this.getCategoryId(), this.getBarcode(), this.getName(), this.getUnit(), this.getPrice());

        for(int i=0; i<getPromotionList().size(); i++){
            allSubTotals.add(getPromotionList().get(i).calcultaPromotion(item, num));
        }

        return Collections.min(allSubTotals);
    }
}
