package xander.pojos;

import java.math.BigDecimal;

public class CartTillItem extends TillItem {

    private int quantity;

    public CartTillItem(final String itemName,
                        final BigDecimal itemCost,
                        final int quantity) {
        super(itemName, itemCost);
        this.quantity = quantity;
    }

    public CartTillItem addItem() {
        quantity = quantity + 1;
        return this;
    }

    public CartTillItem removeItem() {
        quantity = quantity - 1;
        return this;
    }
    public int getQuantity() {
        return quantity;
    }
}
