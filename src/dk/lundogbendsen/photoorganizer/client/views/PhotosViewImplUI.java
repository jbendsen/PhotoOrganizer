package dk.lundogbendsen.photoorganizer.client.views;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

import dk.lundogbendsen.photoorganizer.client.data.Oracle;

public class PhotosViewImplUI extends Composite {
	TileGrid tileGrid;
	Button b;

	public PhotosViewImplUI() {
		initWidget(getTileGrid());
		setSize("100%", "100%");
	}
	


	TileGrid getTileGrid() {
		if (tileGrid == null) {
			tileGrid = new TileGrid();
			tileGrid.setTileWidth(150);
			tileGrid.setTileHeight(150);
			tileGrid.setHeight(400);
			tileGrid.setWidth(400);
			tileGrid.setCanReorderTiles(true);
			tileGrid.setShowAllRecords(true);
			// tileGrid.setDataSource(AnimalXmlDS.getInstance());
			//tileGrid.setAutoFetchData(true);
			tileGrid.setAnimateTileChange(true);
			
			 DetailViewerField pictureField = new DetailViewerField("picture");
		        pictureField.setType("image");
		        pictureField.setImageURLPrefix("chords/");
		        pictureField.setImageWidth(186);
		        pictureField.setImageHeight(120);

		        DetailViewerField nameField = new DetailViewerField("name");
		        DetailViewerField priceField = new DetailViewerField("price");

		        tileGrid.setFields(pictureField, nameField, priceField);

		}
		return tileGrid;
	}

}
