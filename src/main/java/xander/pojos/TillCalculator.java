package xander.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import xander.pojos.offer.DiscountManager;

public class TillCalculator {

    private BigDecimal runningTotals = new BigDecimal(0.0);
    private Map<String, BigDecimal> itemsTotals = new HashMap<>();

    private DiscountManager discountManager;

    private ItemStore itemStore;

    public TillCalculator(final DiscountManager discountManager,
                          final ItemStore itemStore) {
        this.discountManager = discountManager;
        this.itemStore = itemStore;
    }

    public void calculateRunningTotals() {
        for (final String item : itemsTotals.keySet()) {
            final BigDecimal itemTotal = itemsTotals.get(item);
            runningTotals = runningTotals.add(itemTotal);
        }
    }

    public void calculateItemTotals(final String itemName,
                                    final int quantity) {
        final BigDecimal adjustedQuantity = discountManager
                .adjustedQuantity(quantity, itemName);
        final BigDecimal itemCost = itemStore.itemCost(itemName);
        itemsTotals.put(itemName, adjustedQuantity.multiply(itemCost /*.setScale(2,RoundingMode.CEILING)*/));
    }

    public BigDecimal getRunningTotals() {
        calculateRunningTotals();
        return runningTotals.setScale(2, RoundingMode.CEILING);
    }

    public Map<String, BigDecimal> getItemsTotals() {
        return itemsTotals;
    }
}
