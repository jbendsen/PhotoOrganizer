package dk.lundogbendsen.photoorganizer.client.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.smartgwt.client.data.RecordList;

import dk.lundogbendsen.photoorganizer.client.data.Oracle;
import dk.lundogbendsen.photoorganizer.client.views.PhotosView;

public class PhotosActivity extends AbstractActivity implements PhotosView.Presenter {

	private final PhotosView view;
	public PhotosActivity(PhotosView view) {
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		RecordList records = Oracle.getRecords();
		view.setData(records);
		
		panel.setWidget(view);
	}

}
