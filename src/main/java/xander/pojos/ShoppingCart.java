package xander.pojos;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, CartTillItem> items = new HashMap<>();

    final TillCalculator calculator;

    public ShoppingCart(final TillCalculator tillCalculator) {
        this.calculator = tillCalculator;
    }

    public void addOneItem(final String itemName) {
        CartTillItem cartTillItem = items.get(itemName);
        if (cartTillItem == null) {
            cartTillItem = new CartTillItemFactory().create(itemName);
        }
        items.put(itemName, cartTillItem.addItem());
        calculator.calculateItemTotals(itemName, cartTillItem.getQuantity());
    }

    public void removeOneItem(final String itemName) {
        final CartTillItem cartTillItem = items.get(itemName);
        if (cartTillItem == null) {
            throw new RuntimeException(format("Item not in cart %s", itemName));
        }
        items.put(itemName, cartTillItem.removeItem());
        calculator.calculateItemTotals(itemName, cartTillItem.getQuantity());
    }

    public Map<String, CartTillItem> getItems() {
        return items;
    }
}

