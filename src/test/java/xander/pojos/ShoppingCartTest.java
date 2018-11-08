package xander.pojos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;
import xander.pojos.offer.DiscountManager;
import xander.pojos.offer.ProductOfferStore;

//Till produces a receipt

//Should allow you add items to shopping cart
//Should allow you remove items to shopping cart
//Shopping cart contains a list of till Items

//IT Test
public class ShoppingCartTest {


    @Test
    public void shouldAddItemsToShoppingCart() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore);

        final TillCalculator calculator = new TillCalculator(discountManager, itemStore);
        final ShoppingCart shoppingCart = new ShoppingCart(calculator);
        final String itemName = "apple";

        shoppingCart.addOneItem(itemName);

        final Map<String, CartTillItem> cart = shoppingCart.getItems();
        assertThat(cart.size(), is(1));

        final CartTillItem actual = cart.get(itemName);
        assertThat(actual.getQuantity(), is(1));
    }


    @Test
    public void shouldRemoveItemsToShoppingCart() {
        final ProductOfferStore productOfferStore = new ProductOfferStore();
        final ItemStore itemStore = new ItemStore();

        final DiscountManager discountManager = new DiscountManager(productOfferStore);

        final TillCalculator calculator = new TillCalculator(discountManager, itemStore);
        final ShoppingCart shoppingCart = new ShoppingCart(calculator);
        final String itemName = "apple";

        shoppingCart.addOneItem(itemName);

        shoppingCart.addOneItem(itemName);

        shoppingCart.addOneItem(itemName);

        shoppingCart.addOneItem(itemName);

        shoppingCart.addOneItem(itemName);


        shoppingCart.removeOneItem(itemName);
        final Map<String, CartTillItem> cart = shoppingCart.getItems();
        assertThat(cart.size(), is(1));

        final CartTillItem actual = cart.get(itemName);
        assertThat(actual.getQuantity(), is(4));
    }


}