package xander.pojos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItemStore {

    private static Map<String, BigDecimal> itemStore = new HashMap();

    static {
        itemStore.putIfAbsent("APPLE", new BigDecimal(0.60));
        itemStore.putIfAbsent("ORANGE", new BigDecimal(0.25));
        itemStore.putIfAbsent("TEA", new BigDecimal(1.20));
    }

    public BigDecimal itemCost(final String itemName) {
        return itemStore.get(itemName.toUpperCase());
    }

    public static Map<String, BigDecimal> getItemStore() {


        return itemStore;
    }

}
