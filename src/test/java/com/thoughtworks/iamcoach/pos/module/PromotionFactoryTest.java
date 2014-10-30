package com.thoughtworks.iamcoach.pos.module;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by wanghuan on 14-10-30.
 */
public class PromotionFactoryTest {
    @Test
    public void can_generate_BuyTwoOneFreePromotion(){
        int type = 1;
        PromotionFactory promotionFactory = new PromotionFactory();
        promotionFactory.generatePromotion(type);
        assertThat(promotionFactory.generatePromotion(type) instanceof BuyTwoOneFreePromotion).isTrue();
    }


}
