package xander.pojos.offer;

import java.util.HashMap;
import java.util.Map;

public class ProductOfferStore {

    private static Map<String, OfferStrategy> productOfferStore = new HashMap();

    static {
        productOfferStore.putIfAbsent("APPLE", new BuyOneNxtFreeStrategy());
        productOfferStore.putIfAbsent("ORANGE", new Three4TwoStrategy());
        productOfferStore.putIfAbsent("TEA", new DefaultStrategy());
    }

    public OfferStrategy getOfferStrategyForProduct(final String stockName) {
        return productOfferStore.get(stockName.toUpperCase());
    }
}
