package dk.lundogbendsen.photoorganizer.client.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.smartgwt.client.data.RecordList;

public interface PhotosView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	void setData(RecordList data);
	
	public interface Presenter{
		
	}
}
