/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package dk.lundogbendsen.photoorganizer.client.views;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridFieldIfFunction;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PhotoTileGrid extends TileGrid {

    public PhotoTileGrid(DataSource supplyItemDS) {

        setDataSource(supplyItemDS);
      //  setUseAllDataSourceFields(true);


        DetailViewerField itemName = new DetailViewerField("photoName", "Name");
        //itemName.setShowHover(true);
        //DetailViewerField unitCost = new DetailViewerField("unitCost");

//        unitCost.setCellFormatter(new CellFormatter() {
//            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
//                if (value == null) return null;
//                try {
//                    NumberFormat nf = NumberFormat.getFormat("##0.00");
//                    return "$" + nf.format(((Number) value).floatValue());
//                } catch (Exception e) {
//                    return value.toString();
//                }
//            }
//        });

        SpinnerItem spinnerItem = new SpinnerItem();
        spinnerItem.setStep(0.01);
      //  unitCost.setEditorType(spinnerItem);

        //category.setCanEdit(false);

        DetailViewerField inStock = new DetailViewerField("inStock");
      //  inStock.setWidth(55);
       // inStock.setAlign(Alignment.CENTER);
        
		 DetailViewerField pictureField = new DetailViewerField("photoUrl");
	        pictureField.setType("image");
	        pictureField.setImageURLPrefix("cars/");
	        pictureField.setImageWidth(100);
	        pictureField.setImageHeight(60);

        ListGridField nextShipment = new ListGridField("nextShipent");
        nextShipment.setShowIfCondition(new ListGridFieldIfFunction() {
            public boolean execute(ListGrid grid, ListGridField field, int fieldNum) {
                return false;
            }
        });

        setFields(itemName, inStock,pictureField);
     //   setCanEdit(true);
        setCanDragTilesOut(true);
        setHoverWidth(110);
        setHoverHeight(20);
        setWidth100();
        setSelectionType(SelectionStyle.SINGLE);
        setTileSize(140);
    }
}