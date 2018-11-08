package xander.pojos;

import java.math.BigDecimal;

public class TillItem {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TillItem tillItem = (TillItem) o;

        if (itemName != null ? !itemName.equals(tillItem.itemName) : tillItem.itemName != null)
            return false;
        return itemCost != null ? itemCost.equals(tillItem.itemCost) : tillItem.itemCost == null;
    }

    @Override
    public int hashCode() {
        int result = itemName != null ? itemName.hashCode() : 0;
        result = 31 * result + (itemCost != null ? itemCost.hashCode() : 0);
        return result;
    }

    protected String itemName;
    protected BigDecimal itemCost;

    public TillItem(final String itemName, final BigDecimal itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }


}
