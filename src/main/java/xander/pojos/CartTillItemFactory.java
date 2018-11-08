package xander.pojos;

public class CartTillItemFactory {

    final ItemStore itemStore = new ItemStore();

    public CartTillItem create(final String itemName) {
        return new CartTillItem(itemName, itemStore.itemCost(itemName), 0);
    }
}
