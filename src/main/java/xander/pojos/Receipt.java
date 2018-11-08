package xander.pojos;

import java.math.BigDecimal;
import java.util.Map;

public class Receipt {
    final int receiptNo;
    final TillCalculator tillCalculator;
    final ShoppingCart shoppingCart;

    public Receipt(final int receiptNo,
                   final TillCalculator tillCalculator,
                   final ShoppingCart shoppingCart) {
        this.receiptNo = receiptNo;
        this.tillCalculator = tillCalculator;
        this.shoppingCart = shoppingCart;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public Map<String, BigDecimal> getTransactions() {
        return tillCalculator.getItemsTotals();
    }

    public BigDecimal getRunningTotal() {
        return tillCalculator.getRunningTotals();
    }

    public ShoppingCart getShoppingCart() {
         return shoppingCart;
    }
}
