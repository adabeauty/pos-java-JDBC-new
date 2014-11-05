package com.thoughtworks.iamcoach.pos.module;

import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.model.SeconHalfPromotion;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SeconHalfPromotionTest {
    @Test
    public void can_get_SecondHalfPromotion(){
        Item item = new Item(null, 3, "TF1001", "apple", "kg", 8.00);
        double num = 2.0;

        SeconHalfPromotion seconHalfPromotion = new SeconHalfPromotion(1, 1, "second_half_price", 1);
        assertThat(seconHalfPromotion.calculate(item, num)).isEqualTo(12.0);
    }
}