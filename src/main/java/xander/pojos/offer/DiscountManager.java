package xander.pojos.offer;

import java.math.BigDecimal;

public class DiscountManager {

    private ProductOfferStore productOfferStore;

    public DiscountManager(final ProductOfferStore productOfferStore) {
        this.productOfferStore = productOfferStore;
    }

    public BigDecimal adjustedQuantity(final int quantity,
                                       final String itemName) {
        final OfferStrategy offerStrategy = productOfferStore
                .getOfferStrategyForProduct(itemName);
        return offerStrategy.applyOffer(quantity);
    }
}
