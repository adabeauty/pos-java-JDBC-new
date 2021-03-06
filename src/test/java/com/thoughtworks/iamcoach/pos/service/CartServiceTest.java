package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartServiceTest {

    CartService cartService = null;

    @Before
    public void mock_ItemImpl(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("1", 3, "ITEM000001", "apple", "kg", 8.0));
        items.add(new Item("2", 1, "ITEM000002", "cocacola", "can", 2.5));
        items.add(new Item("3", 1, "ITEM000003", "juice", "can", 4.0));
        items.add(new Item("4", 2, "ITEM000004", "chocolate", "bar", 7.5));
        items.add(new Item("5", 3, "ITEM000005", "strawberry", "kg", 25.0));

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        Promotion promotion = new DiscountPromotion(1, 1, "discount", 1.0);
        promotions.add(promotion);

        ItemImple itemImple = mock(ItemImple.class);

        when(itemImple.getItems()).thenReturn(items);
        when(itemImple.getPromotions(1)).thenReturn(promotions);
        when(itemImple.getPromotions(2)).thenReturn(promotions);
        when(itemImple.getPromotions(3)).thenReturn(promotions);
        when(itemImple.getPromotions(4)).thenReturn(promotions);
        when(itemImple.getPromotions(5)).thenReturn(promotions);

        ArrayList<String> inputs = ReadFileUlti.readFile("cart.txt");
        Scanner scanner = new Scanner();
        cartService = new CartService(scanner, itemImple);
    }

    @Test
    public void can_get_all_cartItems(){
        assertThat(cartService.getCartInfo().size()).isEqualTo(3);
        assertThat(cartService.getCartInfo().get(0).getNum()).isEqualTo(5);
        assertThat(cartService.getCartInfo().get(1).getNum()).isEqualTo(2.0);
    }

    @Test
    public void can_get_total_sum(){
        assertThat(cartService.getTotalSum()).isEqualTo(123);
    }

    @Test
    public void can_get_actual_sum(){
        assertThat(cartService.getActualSum()).isEqualTo(123);
    }
}
