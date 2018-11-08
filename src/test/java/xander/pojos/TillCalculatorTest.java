package xander.pojos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import xander.pojos.offer.DiscountManager;
import xander.pojos.offer.ProductOfferStore;

//Should be able to calculate running totals and item totals,
//Should be able to calculate offer method

//IT Test

public class TillCalculatorTest {
    @Test
    public void shouldCalculatesRunningTotals() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore);
        final TillCalculator calculator = new TillCalculator(discountManager,itemStore);
        calculator.calculateItemTotals("apple", 2);
        calculator.calculateItemTotals("orange", 2);
        final BigDecimal runningTotals = calculator.getRunningTotals();



        BigDecimal expected = new BigDecimal(1.10);
        //System.out.println(expected + "=" + runningTotals);
        assertThat(runningTotals.toPlainString(),expected.setScale(2,RoundingMode.FLOOR),is(runningTotals));



    }

    @Test
    public void shouldCalculatesIndividualTotals() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore );
        final TillCalculator calculator = new TillCalculator(discountManager,itemStore);
        calculator.calculateItemTotals("apple", 2);
        final BigDecimal value = new BigDecimal(0.60).setScale(2, RoundingMode.CEILING);
        assertThat(calculator.getRunningTotals().setScale(2, RoundingMode.CEILING), is(value));
    }

    @Test
    public void shouldBeAbleToApplyOfferMethod() {

    }

}