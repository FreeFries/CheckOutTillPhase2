package xander.pojos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import xander.pojos.offer.DiscountManager;
import xander.pojos.offer.ProductOfferStore;

//Should be able to apply(apply discount) by selecting the correct the offer strategy/method
//Should be able and apply to the totals

public class DiscountManagerTest {
    @Test
    public void shouldFindDiscountAmount() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();
        final DiscountManager discountManager = new DiscountManager(productOfferStore);
        final BigDecimal amountAfterDiscount = discountManager.adjustedQuantity(6, "apple");

        final BigDecimal value = new BigDecimal(3.00).setScale(2, RoundingMode.HALF_DOWN);
        assertThat(amountAfterDiscount, is(value));
    }
}