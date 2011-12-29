package dk.lundogbendsen.photoorganizer.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import dk.lundogbendsen.photoorganizer.client.views.*;



public class PhotosActivity extends AbstractActivity  {

	private final PhotosPanel view;
	public PhotosActivity(PhotosPanel view) {
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

	
		
		panel.setWidget(view);
	}

}
