package dk.lundogbendsen.photoorganizer.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import dk.lundogbendsen.photoorganizer.client.activities.PhotosActivity;
import dk.lundogbendsen.photoorganizer.client.framework.PerspectiveMapper;
import dk.lundogbendsen.photoorganizer.client.framework.Region;

public class DefaultPerspectiveMapper implements PerspectiveMapper {
	Region main;
	private final ClientFactory clientFactory;
	public DefaultPerspectiveMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		main =new Region(new MainRegionMapper(), clientFactory.getEventBus());
	}
	
	
	class MainRegionMapper implements ActivityMapper {
		@Override
		public Activity getActivity(Place place){
			GWT.log("MainRegionMapper.getActivity");
			return clientFactory.createPhotosActivity();
		}
	}

	@Override
	public Widget getPerspective(Place place) {
		// TODO Auto-generated method stub
		DockLayoutPanel root = new DockLayoutPanel(Unit.PX);
		root.setSize("100%", "100%");
		root.add(main);
		return root;
	}

}
