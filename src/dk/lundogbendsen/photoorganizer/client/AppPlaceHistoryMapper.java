package dk.lundogbendsen.photoorganizer.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import dk.lundogbendsen.photoorganizer.client.places.PhotosPlace;
@WithTokenizers({PhotosPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper { }