package xander.pojos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import xander.pojos.offer.DiscountManager;
import xander.pojos.offer.ProductOfferStore;


public class TillPrinterTest {

    @Test
    public void shouldPrintReceipts() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore);
        final TillCalculator calculator = new TillCalculator(discountManager, itemStore);
        final TillPrinter tillPrinter = new TillPrinter();
        final ShoppingCart shoppingCart = new ShoppingCart(calculator);
        shoppingCart.addOneItem("apple");

        shoppingCart.addOneItem("orange");
        shoppingCart.addOneItem("orange");
        shoppingCart.addOneItem("orange");
        final Receipt receipt = new Receipt(1, calculator, shoppingCart);
        final boolean printResult = tillPrinter.printReceipt(receipt);
        assertThat(printResult, is(true));
    }
}