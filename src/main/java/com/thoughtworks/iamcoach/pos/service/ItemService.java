package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.Dao.ItemImple;
import com.thoughtworks.iamcoach.pos.module.*;

import java.util.ArrayList;

public class ItemService {
    private ItemImple itemImple = new ItemImple();

    public void setItemImple(ItemImple itemImple) {
        this.itemImple = itemImple;
    }

    public ArrayList<Item> getItems() {
        return itemImple.getItems();
    }

    public Item getItemByBarcode(String barcode) {
        return itemImple.getItemByBarcode(barcode);
    }

    public ArrayList<Promotion> getPromotions(int id) {
        return itemImple.getPromotions(id);
    }

    public Category getCategory(int id) {
        return itemImple.getCategory(id);
    }
}
