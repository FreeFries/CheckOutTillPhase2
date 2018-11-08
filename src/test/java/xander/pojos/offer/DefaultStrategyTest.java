package xander.pojos.offer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class DefaultStrategyTest {

    @Test
    public void shouldReturnDiscountedAmount() {
        DefaultStrategy defaultStrategy = new DefaultStrategy();
        final BigDecimal amount = defaultStrategy.applyOffer(2);
        assertThat(amount, is(new BigDecimal(2.00).setScale(2, RoundingMode.CEILING)));
    }
}