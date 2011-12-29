package dk.lundogbendsen.photoorganizer.client.data;

import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Date;

public class PhotoRecord extends ListGridRecord {

    public PhotoRecord() {
    }

    public PhotoRecord(int photoId, String item, String sku, String description, String album, String units, Double unitCost, Boolean inStock, Date nextShipment) {
        setItemID(photoId);
        setitemName(item);
        setSKU(sku);
        setDescription(description);
        setCategory(album);
        setUnits(units);
        setUnitCost(unitCost);
        setInStock(inStock);
        setNextShipment(nextShipment);
    }

    /**
     * Set the photoId.
     *
     * @param photoId the photoId
     */
    public void setItemID(int photoId) {
        setAttribute("photoId", photoId);
    }

    /**
     * Return the photoId.
     *
     * @return the photoId
     */
    public int getItemID() {
        return getAttributeAsInt("photoId");
    }


    /**
     * Set the item.
     *
     * @param item the item
     */
    public void setitemName(String item) {
        setAttribute("itemName", item);
    }

    /**
     * Return the item.
     *
     * @return the item
     */
    public String getitemName() {
        return getAttribute("itemName");
    }

    /**
     * Set the SKU.
     *
     * @param SKU the SKU
     */
    public void setSKU(String SKU) {
        setAttribute("SKU", SKU);
    }

    /**
     * Return the SKU.
     *
     * @return the SKU
     */
    public String getSKU() {
        return getAttribute("SKU");
    }

    /**
     * Set the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * Return the description.
     *
     * @return the description
     */
    public String getDescription() {
        return getAttribute("description");
    }

    /**
     * Set the category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        setAttribute("category", category);
    }

    /**
     * Return the category.
     *
     * @return the category
     */
    public String getCategory() {
        return getAttribute("category");
    }

    /**
     * Set the units.
     *
     * @param units the units
     */
    public void setUnits(String units) {
        setAttribute("units", units);
    }

    /**
     * Return the units.
     *
     * @return the units
     */
    public String getUnits() {
        return getAttribute("units");
    }

    /**
     * Set the unitCost.
     *
     * @param unitCost the unitCost
     */
    public void setUnitCost(Double unitCost) {
        setAttribute("unitCost", unitCost);
    }

    /**
     * Return the unitCost.
     *
     * @return the unitCost
     */
    public Float getUnitCost() {
        return getAttributeAsFloat("unitCost");
    }

    /**
     * Set the inStock.
     *
     * @param inStock the inStock
     */
    public void setInStock(Boolean inStock) {
        setAttribute("inStock", inStock);
    }

    /**
     * Return the inStock.
     *
     * @return the inStock
     */
    public Boolean getInStock() {
        return getAttributeAsBoolean("inStock");
    }

    /**
     * Set the nextShipment.
     *
     * @param nextShipment the nextShipment
     */
    public void setNextShipment(Date nextShipment) {
        setAttribute("nextShipment", nextShipment);
    }

    /**
     * Return the nextShipment.
     *
     * @return the nextShipment
     */
    public Date getNextShipment() {
        return getAttributeAsDate("nextShipment");
    }


}
