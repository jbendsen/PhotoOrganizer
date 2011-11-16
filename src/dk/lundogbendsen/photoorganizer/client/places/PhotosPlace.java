package dk.lundogbendsen.photoorganizer.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class PhotosPlace extends Place {
	private String customer;
	private String folder;

	public PhotosPlace(String customer, String folder) {
		this.customer=customer;
		this.folder=folder;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public String getFolder() {
		return folder;
	}
	
	 @Prefix(value = "!Photos")
	public static class Tokenizer implements PlaceTokenizer<PhotosPlace> {
		@Override
		public String getToken(PhotosPlace place) {
			return place.getCustomer()+"-"+place.getFolder();
		}

		@Override
		
		public PhotosPlace getPlace(String anchor) {
			String[] tokens = anchor.split("-");
			return new PhotosPlace(tokens[0],tokens[1]);
		}
	}
	
}
