package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.Dao.ItemImple;
import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.model.promotion.BuyTwoOneFreePromotion;
import com.thoughtworks.iamcoach.pos.model.promotion.Promotion;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceTest {
    @Test
    public void can_get_all_items(){

        ItemService itemService = new ItemService();
        itemService.setItemImple(mock_ItemImple());

        assertThat(itemService.getItems().size()).isEqualTo(1);
    }


    @Test
    public void can_get_item_by_barcode(){
        ItemService itemService = new ItemService();
        itemService.setItemImple(mock_ItemImple());

        Item item = new Item(null, 3,"TF1001", "juice", "can", 8.0);
        String barcode = "TF1001";
        assertThat(itemService.getItemByBarcode(barcode).toString()).isEqualTo(item.toString());
    }

    @Test
    public void can_get_promotions_of_item(){
        ItemService itemService = new ItemService();
        itemService.setItemImple(mock_ItemImple());

        int id = 1;
        assertThat(itemService.getPromotions(id).size()).isEqualTo(1);
    }

    @Test
    public void can_get_category_of_item(){
        ItemService itemService = new ItemService();
        itemService.setItemImple(mock_ItemImple());

        int id = 1;
        Category category = new Category(null, "drink");
        assertThat(itemService.getCategory(id).toString()).isEqualTo(category.toString());
    }

    private  ItemImple mock_ItemImple(){
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item(null, 3,"TF1001", "juice", "can", 8.0);
        items.add(item);

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        Promotion promotion = new BuyTwoOneFreePromotion(1, 1, "buy_two_one_free", 1.0);
        promotions.add(promotion);

        String barcode = "TF1001";
        int id = 1;
        Category category = new Category(null, "drink");

        ItemImple itemImple = mock(ItemImple.class);
        when(itemImple.getItems()).thenReturn(items);
        when(itemImple.getItemByBarcode(barcode)).thenReturn(item);
        when(itemImple.getPromotions(id)).thenReturn(promotions);
        when(itemImple.getCategory(id)).thenReturn(category);

        return itemImple;
    }

}
