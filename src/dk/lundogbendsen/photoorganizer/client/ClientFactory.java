package dk.lundogbendsen.photoorganizer.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import dk.lundogbendsen.photoorganizer.client.activities.PhotosActivity;
import dk.lundogbendsen.photoorganizer.client.views.PhotosPanel;
import dk.lundogbendsen.photoorganizer.client.views.PhotosView;
import dk.lundogbendsen.photoorganizer.client.views.PhotosViewImpl;

public class ClientFactory {
	private PlaceController placeController;
	private EventBus eventBus;
	private AppPlaceHistoryMapper historyMapper;



	public Activity createPhotosActivity(){
		return new PhotosActivity(createPhotosView());
	}

	private PhotosPanel createPhotosView() {
		// TODO Auto-generated method stub
		return new PhotosPanel();
	}
	
	public AppPlaceHistoryMapper getHistoryMapper() {
		if(historyMapper==null){
			historyMapper = GWT.create(AppPlaceHistoryMapper.class);
			
		}
		return historyMapper;
	}
	
	public PlaceController getPlaceController() {
		if(placeController==null){
			placeController = new PlaceController(getEventBus());
		}
		return placeController;
	}
	
	
	public EventBus getEventBus(){
		if(eventBus==null){
			eventBus=new SimpleEventBus();
		}
		return eventBus;
	}
	}
