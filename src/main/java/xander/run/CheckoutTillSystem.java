package xander.run;


//Should be able to produce a till reciept,
//Should be able to print receipt
//Should be able to calculate running totals and item totals,
//Should allow you to print receipts
//Should allow you add items to shopping cart
//Should be able to calculate offers and apply to the totals

//TillCalculator
//Should be able to give customers different discount offer methods(strategies)

//Shopping cart contains a list of till Items
//A Till Item is a item in the shopping cart


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import xander.pojos.ItemStore;
import xander.pojos.Receipt;
import xander.pojos.ShoppingCart;
import xander.pojos.TillCalculator;
import xander.pojos.TillPrinter;
import xander.pojos.offer.DiscountManager;
import xander.pojos.offer.ProductOfferStore;



public class CheckoutTillSystem {

    public static void main(String[] args) throws Exception {
        //Validate the args
        //MAKE sure that they are upper case so that it picks up the correct value from the product offer / item store
        int i = 0;
        for (final String item : args) {
            args[i] = args[i].toUpperCase();
            System.out.print(item.toString() + " ");
            i = i + 1 ;
        }
        System.out.println("\n---- Scanned till items ----");
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore);
        final TillCalculator tillCalculator = new TillCalculator(discountManager, itemStore);

        for (String product: ItemStore.getItemStore().keySet()             ) {
            System.out.print(product + " " + itemStore.itemCost(product).setScale(2, RoundingMode.CEILING));
            String offerType = productOfferStore.getOfferStrategyForProduct(product).getClass().getSimpleName();
            System.out.println(" "  +offerType);
        }
        System.out.println("---- Pricing/Offers ----\n\n");

        final List<String> items = Arrays.asList(args);
        ShoppingCart shoppingCart = new ShoppingCart(tillCalculator);
        for (final String item : items) {
            shoppingCart.addOneItem(item);
        }

        final Receipt receipt = new Receipt(1, tillCalculator, shoppingCart);
        final TillPrinter printer = new TillPrinter();
        printer.printReceipt(receipt);
    }
}
