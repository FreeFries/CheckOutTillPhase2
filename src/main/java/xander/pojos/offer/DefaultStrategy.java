package xander.pojos.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DefaultStrategy implements OfferStrategy {

    public DefaultStrategy() {
    }

    protected BigDecimal discountMultiple = new BigDecimal(1.0);

    @Override
    public BigDecimal applyOffer(final int quantity) {

        return discountMultiple.multiply(
                new BigDecimal(quantity).setScale(2, RoundingMode.CEILING));
    }
}
