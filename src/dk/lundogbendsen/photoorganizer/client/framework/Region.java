package dk.lundogbendsen.photoorganizer.client.framework;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

public class Region implements IsWidget {
	SimplePanel panel;
	
	public Region(ActivityMapper acm,EventBus eventBus)  {
		this(new SimplePanel(),acm,eventBus);
	}


	public Region(SimplePanel panel,ActivityMapper acm,EventBus eventBus) {
		super();
		
		panel.setSize("100%", "100%");
	
		
		ActivityManager activityManager = new ActivityManager(acm, eventBus);
		activityManager.setDisplay(panel); 
		this.panel = panel;
	}

	



	@Override
	public Widget asWidget() {
		return panel;
	}
	

}
