package xander.pojos.offer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class BuyOneNxtFreeStrategyTest {

    @Test
    public void shouldReturnDiscountedAmount() {
        BuyOneNxtFreeStrategy buyOneNxtFreeStrategy = new BuyOneNxtFreeStrategy();
        final BigDecimal amount = buyOneNxtFreeStrategy.applyOffer(2);
        assertThat(amount, is(new BigDecimal(1.00).setScale(2, RoundingMode.CEILING)));
    }
}