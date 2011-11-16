package dk.lundogbendsen.photoorganizer.client;




import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.lundogbendsen.photoorganizer.client.framework.PerspectiveManager;
import dk.lundogbendsen.photoorganizer.client.places.PhotosPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhotoOrganizer implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ClientFactory clientFactory = new ClientFactory();
		new PerspectiveManager(new DefaultPerspectiveMapper(clientFactory), clientFactory.getEventBus(),RootLayoutPanel.get());
	
	
	Place defaultPlace = new PhotosPlace("SAMPLE","SAMPLE");
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(clientFactory.getHistoryMapper());
	historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), defaultPlace);
	historyHandler.handleCurrentHistory();
	GWT.log("onModuleLoad end");
	}
}
