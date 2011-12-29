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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class PhotoDetailTabPane extends VLayout {

    //private DetailViewer itemViewer;
 //   private DynamicForm editorForm;
 //   private Label editorLabel;
    private PhotoTileGrid itemListGrid;
	private DynamicForm dynamicForm;
	private Img image;
   

    public PhotoDetailTabPane(DataSource supplyItemDS, DataSource albumDS, PhotoTileGrid itemListGrid) {
        this.itemListGrid = itemListGrid;
       dynamicForm = new DynamicForm();
        dynamicForm.setDataSource(supplyItemDS);
     setWidth100();
       setMargin(25);
        //setEmptyMessage("Select an item to view its details");
       
        
      TextItem picture = new TextItem(PhotoXmlDS.FieldNameEnum.photoName.toString());
      
      TextAreaItem description = new TextAreaItem(PhotoXmlDS.FieldNameEnum.description.toString());
      
      SelectItem selectItemMultipleGrid = new SelectItem(PhotoXmlDS.FieldNameEnum.tag.toString());  
      selectItemMultipleGrid.setMultiple(true);  
      selectItemMultipleGrid.setMultipleAppearance(MultipleAppearance.PICKLIST);  
      selectItemMultipleGrid.setValueMap("natur", "bil", "dyr", "ferie");  
   
      image = new Img("cars/shelby.jpg",300,200);
      dynamicForm.setFields(picture,selectItemMultipleGrid,description);

      addMember(image);
      addMember(dynamicForm);


draw();
    }


    public void clearDetails(Record selectedCategoryRecord) {
     //   int selectedTab = getSelectedTabNumber();
     //if (selectedTab == 0) {
            //view tab : show empty message
    	dynamicForm.editRecord(selectedCategoryRecord);
    	
//        } else {
//            // edit tab : show new record editor, or empty message
//            if (selectedCategoryRecord != null) {
//               // updateTab(1, editorForm);
//                Map initialValues = new HashMap();
//                initialValues.put("albumName", selectedCategoryRecord.getAttribute("albumName"));
//               // editorForm.editNewRecord(initialValues);
//            } else {
//              //  updateTab(1, editorLabel);
//            }
//        }
    }

    public void updateDetails() {
    	  Record selectedRecord  = itemListGrid.getSelectedRecord();
    	  System.out.println(selectedRecord.getAttribute("photoUrl"));
    	  image.setImageType(ImageStyle.CENTER);
    	  image.setSrc("cars/"+selectedRecord.getAttribute("photoUrl"));
    	  image.setSize("300", "200");
    	  image.redraw();
    	  dynamicForm.editRecord(selectedRecord);
      }
}
