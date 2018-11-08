package xander.pojos.offer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class Three4TwoStrategyTest {

    @Test
    public void shouldReturnDiscountedAmount() {
        Three4TwoStrategy i3for2 = new Three4TwoStrategy();

        BigDecimal amount = i3for2.applyOffer(1);
        assertThat("for 1 you get" + amount,amount, is(new BigDecimal(1).setScale(2, RoundingMode.CEILING)));


        amount = i3for2.applyOffer(2);
        assertThat("for 2 you get" + amount,amount, is(new BigDecimal(2).setScale(2, RoundingMode.CEILING)));

        amount = i3for2.applyOffer(3);
        assertThat("for 3 you get" + amount,amount, is(new BigDecimal(2).setScale(2, RoundingMode.CEILING)));

        amount = i3for2.applyOffer(4);
        assertThat("for 4 you get" +amount,amount, is(new BigDecimal(3).setScale(2, RoundingMode.CEILING)));

        amount = i3for2.applyOffer(6);
        assertThat("for 6 you get" +amount,amount, is(new BigDecimal(4).setScale(2, RoundingMode.CEILING)));

    }
}