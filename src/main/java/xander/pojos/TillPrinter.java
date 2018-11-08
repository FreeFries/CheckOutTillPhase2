package xander.pojos;

import static java.lang.String.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Set;

public class TillPrinter {

    public boolean printReceipt(final Receipt receipt) {
        System.out.println("|-------------------------------------------------------|");
        System.out.println(format("|Printed receipt no: %s ", receipt.getReceiptNo()));
        System.out.println("|-------------------------------------------------------|");
        System.out.println(format("|Item Name|Item Cost|Quantity|Totals                   |"));
        final Map<String, BigDecimal> transactions = receipt.getTransactions();
        final Set<String> items = transactions.keySet();
        for (final String itemName : items) {
            System.out.println("|------------------------------------------------------|");
            final Map<String, CartTillItem> items1 = receipt.getShoppingCart().getItems();
            System.out.println("|" + itemName + "                | "
                    + items1.get(itemName).getItemCost().setScale(2, RoundingMode.CEILING) + "|"
                    + items1.get(itemName).getQuantity() + "|"
                    + transactions.get(itemName).setScale(2, RoundingMode.CEILING) + "                   |");
        }
        System.out.println("|------------------------------------------------------|");
        System.out.println("| Grand Total           |" + receipt.getRunningTotal());
        System.out.println("|------------------------------------------------------|");

        return true;
    }
}
