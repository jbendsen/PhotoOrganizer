package dk.lundogbendsen.photoorganizer.client.views;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.data.RecordList;

public class PhotosViewImpl implements PhotosView {

	private Presenter presenter;
	private PhotosViewImplUI ui= new PhotosViewImplUI();

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
		
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return ui;
	}

	@Override
	public void setData(RecordList data) {
		ui.getTileGrid().setData(data);
		
	}

}
