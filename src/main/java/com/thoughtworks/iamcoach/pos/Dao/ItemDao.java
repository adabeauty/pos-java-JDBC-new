package com.thoughtworks.iamcoach.pos.Dao;

import com.thoughtworks.iamcoach.pos.module.Category;
import com.thoughtworks.iamcoach.pos.module.Item;
import com.thoughtworks.iamcoach.pos.module.Promotion;

import java.util.ArrayList;

public interface ItemDao {
    Item getItemByBarcode(String barcode);

    ArrayList<Item> getItems();

    ArrayList<Promotion> getPromotions(int id);

    Category getCategory(int id);
}
