package com.thoughtworks.iamcoach.pos.module;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by wanghuan on 14-10-30.
 */
public class PromotionFactoryTest {
    @Test
    public void can_generate_Promotion(){
        assertThat(PromotionFactory.generatePromotion(1) instanceof BuyTwoOneFreePromotion).isTrue();
        assertThat(PromotionFactory.generatePromotion(2) instanceof SeconHalfPromotion).isTrue();
        assertThat(PromotionFactory.generatePromotion(3) instanceof DiscountPromotion).isTrue();
    }

}
