package processSale.integration;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;

import processSale.dto.ItemDTO;
import processSale.model.SaleLog;

/**
 * A unit to operate as a bridge to external systems.
 */
public class DBHandler {
    private static DBHandler instance;

    private ArrayList<ItemDTO> dbItems = new ArrayList<ItemDTO>();/*(Arrays.asList(new ItemDTO(10, 0.06f, "Banana"),
            new ItemDTO(5, 0.06f, "Apple"),
            new ItemDTO(15, 0.25f, "Kiwi"),
            new ItemDTO(3, 0.12f, "Potato"),
            new ItemDTO(20, 0.12f, "Strawberries")));*/

    private static ArrayList<SaleLog> sales = new ArrayList<SaleLog>();

    private DBHandler() {
        dbItems.add(new ItemDTO(10, 0.06f, "Banana"));
        dbItems.add(new ItemDTO(5, 0.06f, "Apple"));
        dbItems.add(new ItemDTO(15, 0.25f, "Kiwi"));
        dbItems.add(new ItemDTO(3, 0.12f, "Potato"));
        dbItems.add(new ItemDTO(20, 0.12f, "Strawberries"));
    }

    /**
     * Returns the only instance of <code>DBHandler</code>, if there exists none one is created.
     * @return The <code>DBHandler</code> to be returned.
     */
    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler();
        }
        return instance;
    }

    /**
     * Initiates a search in an external inventory (in this case not) for an <code>Item</code>, throws exception if
     * <code>itemIdentifier</code> is null or the <code>Item</code> does not exist in the database.
     * @param itemIdentifier The identifier used to identify an <code>Item</code> from the external system.
     * @return Information about an <code>Item</code>.
     * @throws InvalidItemIdentifierException If <code>ItemDTO</code> could not be found with
     *                                        <code>itemIdentifier</code>
     * @throws InventorySystemException If connection to database failed (in this case hardcoded to when "Apple"
     *                                  is the identifier).
     */
    public ItemDTO searchInventory(String itemIdentifier) throws InvalidItemIdentifierException, InventorySystemException {
        for (int i = 0; i < dbItems.size(); i++) {
            if (itemIdentifier == null) {
                throw new InvalidItemIdentifierException("null");
            }

            // HARDCODED: 'Apple' will trigger database failure.
            if (itemIdentifier.equals("Apple")) {
                throw new InventorySystemException("An error has occurred, please try again.");
            }

            if (itemIdentifier.equals(dbItems.get(i).getDescription())) {
                return dbItems.get(i);
            }
        }
        throw new InvalidItemIdentifierException(itemIdentifier);
    }

    /**
     * Sends sale information to an external system (in this case not), <code>SaleLog</code> that are null
     * are omitted.
     * @param saleLog Information to be saved.
     */
    public void logSale(SaleLog saleLog) {
        if (saleLog.equals(null)) {
            sales.add(saleLog);
        }
    }

    /**
     * @return All recorded <code>Sale</code>.
     */
    public ArrayList<SaleLog> getSales() {
        return sales;
    }

    /**
     * Dummy method that would in a real system check the customer id against a database to make sure it is valid.
     * Here <code>true</code> is always returned.
     * @param customerId Id to be checked.
     * @return Boolean representing whether or not the id is valid.
     */
    public boolean checkIdValidity(int customerId) {
        return true;
    }

}