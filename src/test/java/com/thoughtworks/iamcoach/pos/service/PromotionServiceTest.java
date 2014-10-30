package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.Dao.*;
import com.thoughtworks.iamcoach.pos.module.promotion.Promotion;
import com.thoughtworks.iamcoach.pos.module.promotion.SeconHalfPromotion;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PromotionServiceTest {
    @Test
    public void can_get_promotion_by_type(){
        PromotionService promotionService = new PromotionService();
        promotionService.setPromotionImple(mock_PromotionImple());
        int type = 1;
        assertThat(promotionService.getPromotionByType(type) instanceof SeconHalfPromotion).isTrue();
    }

    @Test
    public void can_get_promotions(){
        PromotionService promotionService = new PromotionService();
        promotionService.setPromotionImple(mock_PromotionImple());

        assertThat(promotionService.getPromotions().size()).isEqualTo(1);
    }

    private PromotionDao mock_PromotionImple(){
        int type = 1;
        Promotion promotion = new SeconHalfPromotion();

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(promotion);

        PromotionDao promotionImple = mock(PromotionImple.class);
        when(promotionImple.getPromotionByType(type)).thenReturn(promotion);
        when(promotionImple.getPromotions()).thenReturn(promotions);

        return promotionImple;
    }
}
