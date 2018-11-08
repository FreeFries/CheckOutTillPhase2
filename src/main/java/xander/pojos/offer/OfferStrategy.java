package xander.pojos.offer;

import java.math.BigDecimal;

@FunctionalInterface
public interface OfferStrategy {

    BigDecimal applyOffer(final int quantity);
}
