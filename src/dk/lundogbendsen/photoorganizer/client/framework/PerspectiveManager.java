package dk.lundogbendsen.photoorganizer.client.framework;


import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;


public class PerspectiveManager implements PlaceChangeEvent.Handler {
private final PerspectiveMapper mapper;


AcceptsOneWidget display;

public PerspectiveManager(PerspectiveMapper mapper, EventBus eventBus, Panel display)  {
	this.mapper = mapper;
	
	setDisplay(display);
	eventBus.addHandler(PlaceChangeEvent.TYPE, this);
}

public void setDisplay(Panel root) {

	if(root instanceof AcceptsOneWidget){
		this.display=(AcceptsOneWidget)root;
	}
	else if(root instanceof ComplexPanel ){
		ComplexPanel c = (ComplexPanel)root;
		while(c.getWidgetCount()>0){
			c.remove(0);
		}
		SimplePanel p = new SimplePanel();
		p.setSize("100%", "100%");
		c.add(p);
		this.display=p;
	}
	else{
		SimplePanel p = new SimplePanel();
		p.setSize("100%", "100%");
		root.add(p);
		this.display=p;
	}
}

@Override
public void onPlaceChange(PlaceChangeEvent event) {
 display.setWidget(mapper.getPerspective(event.getNewPlace()));
}
}
