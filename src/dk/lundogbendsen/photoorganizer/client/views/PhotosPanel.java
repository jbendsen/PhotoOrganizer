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

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FilterCriteriaFunction;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.events.NodeClickEvent;
import com.smartgwt.client.widgets.tree.events.NodeClickHandler;

public class PhotosPanel extends HLayout {

    private SearchForm searchForm;
    private AlbumTreeGrid albumTree;
    private PhotoTileGrid itemList;
    private PhotoDetailTabPane itemDetailTabPane;
    
	private VLayout middleLayout;
//private SectionStackSection findSection;
	
	private VLayout rightSideLayout;

	private SectionStackSection itemDetailsSection;
	private VLayout leftSideLayout;
	
	DataSource albumDS = AlbumXmlDS.getInstance();
    DataSource supplyItemDS = PhotoXmlDS.getInstance();
//	private SectionStackSection photosSection;

    public PhotosPanel() {
        setWidth100();
        setHeight100();
        setLayoutMargin(20);

        

      

        searchForm = new SearchForm(supplyItemDS);

        //when showing options in the combo-box, only show the options from the selected album if appropriate
        final ComboBoxItem itemNameCB = searchForm.getitemNameField();
        itemNameCB.setPickListFilterCriteriaFunction(new FilterCriteriaFunction() {
            public Criteria getCriteria() {
                ListGridRecord record = albumTree.getSelectedRecord();
                if ((itemNameCB.getValue() != null) && record != null) {
                    Criteria criteria = new Criteria();
                    criteria.addCriteria("albumId", record.getAttribute("albumId"));
                    return criteria;
                }
                return null;
            }
        });

    //    setupContextMenu();


//        itemList.addSelectionChangedHandler(new RecordClickHandler() {
//            public void onRecordClick(RecordClickEvent event) {
//                itemDetailTabPane.updateDetails();
//            }
//        });
//
//        itemList.addCellSavedHandler(new CellSavedHandler() {
//            public void onCellSaved(CellSavedEvent event) {
//                itemDetailTabPane.updateDetails();
//            }
//        });
//
//        itemList.addCellContextClickHandler(new CellContextClickHandler() {
//            public void onCellContextClick(CellContextClickEvent event) {
//                itemListMenu.showContextMenu();
//                event.cancel();
//            }
//        });


      

       
        

        searchForm.setHeight(60);
        searchForm.addFindListener(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                findItems(null);
            }
        });

      

        
   
        
    
      
        
      


        

        addMember(getLeftSideLayout());
        addMember(getMiddleLayout());
        addMember(getRightSideLayout());
    }
    
    public PhotoTileGrid getItemList() {
    	if(itemList==null){
    		 itemList = new PhotoTileGrid(supplyItemDS);
    		    itemList.addClickHandler(new ClickHandler() {
    				
    				@Override
    				public void onClick(ClickEvent event) {
    					itemDetailTabPane.updateDetails();
    					
    				}
    			});
    	}
		return itemList;
	}
   
    
    public AlbumTreeGrid getAlbumTree() {
    	if(albumTree==null){
    		 albumTree = new AlbumTreeGrid(albumDS);
    		    albumTree.setAutoFetchData(true);
    		    albumTree.addNodeClickHandler(new NodeClickHandler() {
    		        public void onNodeClick(NodeClickEvent event) {
    		            String albumId = event.getNode().getAttribute("albumId");
    		            findItems(albumId);
    		        }
    		    });
    	}
		return albumTree;
	}
   
    
    public VLayout getLeftSideLayout() {
    	if(leftSideLayout==null){
    		 leftSideLayout = new VLayout();
    		    leftSideLayout.setWidth(280);
    		    leftSideLayout.setShowResizeBar(true);
    		
    		    leftSideLayout.addMember(getAlbumTree());
    		  
    	}
		return leftSideLayout;
	}
   
    
    public VLayout getRightSideLayout() {
    	if(rightSideLayout==null){
    		 rightSideLayout = new VLayout();
    		   
    		    rightSideLayout.addMember(getItemDetailTabPane());
    	}
		return rightSideLayout;
	}
    

    
    public PhotoDetailTabPane getItemDetailTabPane() {
    	if(itemDetailTabPane==null){
    		itemDetailTabPane = new PhotoDetailTabPane(supplyItemDS, albumDS, itemList);
    	}
		return itemDetailTabPane;
	}
    

    

   
   
    

    

    
    public VLayout getMiddleLayout(){
    	if(middleLayout==null){
    		  middleLayout = new VLayout();
    	       
    	      
    	        middleLayout.addMember(getItemList());
    	        middleLayout.addMember(searchForm);
    	        middleLayout.setShowResizeBar(true);
    	}
    	return middleLayout;
    }
    
   

//    private void setupContextMenu() {
//        itemListMenu = new Menu();
//        itemListMenu.setCellHeight(22);
//
//        MenuItem detailsMenuItem = new MenuItem("Show Details", "silk/application_form.png");
//        detailsMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
//            public void onClick(MenuItemClickEvent event) {
//                itemDetailTabPane.selectTab(0);
//                itemDetailTabPane.updateDetails();
//            }
//        });
//
//        final MenuItem editMenuItem = new MenuItem("Edit Item", "demoApp/icon_edit.png");
//        editMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
//            public void onClick(MenuItemClickEvent event) {
//                itemDetailTabPane.selectTab(1);
//                itemDetailTabPane.updateDetails();
//            }
//        });
//
//        final MenuItem deleteMenuItem = new MenuItem("Delete Item", "silk/delete.png");
//        deleteMenuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
//            public void onClick(MenuItemClickEvent event) {
//                itemList.removeSelectedData();
//                itemDetailTabPane.clearDetails(null);
//            }
//        });
//
//        itemListMenu.setData(detailsMenuItem, editMenuItem, deleteMenuItem);
//    }


    public void findItems(String albumName) {
    	System.out.println(albumName);
        Criteria findValues;

        String formValue = searchForm.getValueAsString("findInCategory");
        ListGridRecord selectedCategory = albumTree.getSelectedRecord();
        if (formValue != null && selectedCategory != null) {
            albumName = selectedCategory.getAttribute("albumId");
            findValues = searchForm.getValuesAsCriteria();
            findValues.addCriteria("albumId", albumName);

        } else if (albumName == null) {
            findValues = searchForm.getValuesAsCriteria();
        } else {
            findValues = new Criteria();
            findValues.addCriteria("albumId", albumName);
        }

        itemList.filterData(findValues);
        itemDetailTabPane.clearDetails(albumTree.getSelectedRecord());
    }
}