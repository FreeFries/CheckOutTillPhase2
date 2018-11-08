package xander.pojos.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneNxtFreeStrategy extends DefaultStrategy {

    public BuyOneNxtFreeStrategy() {
        super();
    }

    @Override
    public BigDecimal applyOffer(final int quantity) {
        if (quantity == 1) {
            return new BigDecimal(quantity * 1.00).setScale(2, RoundingMode.CEILING);
        }


        if (quantity % 2 == 0) {
            return new BigDecimal(quantity/2).setScale(2, RoundingMode.CEILING);




        } else {
            return new BigDecimal(((quantity - 1)/2)  + 1).setScale(2, RoundingMode.CEILING);
        }
    }
}
