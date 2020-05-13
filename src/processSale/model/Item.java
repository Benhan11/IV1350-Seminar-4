package processSale.model;

import java.lang.String;
import processSale.dto.ItemDTO;

/**
 * Represents an <code>Item</code> in a <code>Sale</code>.
 */
public class Item {
    private int price;
    private float taxRate;
    private String description;
    private int quantity;

    protected Item(ItemDTO itemInfo, int quantity) {
        price = itemInfo.getPrice();
        taxRate = itemInfo.getTaxRate();
        description = itemInfo.getDescription();
        this.quantity = quantity;
    }

    protected int getPrice() {
        return price;
    }

    protected float getTaxRate() {
        return taxRate;
    }

    protected String getDescription() {
        return description;
    }

    protected int getQuantity() {
        return quantity;   
    }

    /**
     * Increases amount of <code>Item</code>, quantity values of less than 1 are not handled.
     * The operation will overflow if the <code>amount</code> is smaller than <code>Integer.MIN_VALUE</code>
     * or larger than <code>Integer.MAX_VALUE</code>.
     * @param amount Amount to increase with.
     */
    protected void increaseQuantity(int amount) {
        quantity += amount;
    }

}