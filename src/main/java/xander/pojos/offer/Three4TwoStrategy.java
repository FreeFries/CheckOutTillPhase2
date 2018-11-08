package xander.pojos.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Three4TwoStrategy extends DefaultStrategy {

    @Override
    public BigDecimal applyOffer(final int quantity) {


        if (quantity >=1 && quantity <= 2) {

            return new BigDecimal(quantity * 1.00).setScale(2, RoundingMode.CEILING);
        }
        else if (quantity % 3 == 0)
        {
            return new BigDecimal((quantity/3) *2).setScale(2, RoundingMode.CEILING);
        }
        else
        {

            return new BigDecimal(((quantity -1)/3) *2).setScale(2, RoundingMode.CEILING).add( new BigDecimal(1 * 1.00).setScale(2, RoundingMode.CEILING));
        }



    }
}
