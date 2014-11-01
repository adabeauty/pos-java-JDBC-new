package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.module.*;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

public interface ItemDao {
    Item getItemByBarcode(String barcode);

    ArrayList<Item> getItems();

    ArrayList<Promotion> getPromotions(int id);

    Category getCategory(int id);
}
