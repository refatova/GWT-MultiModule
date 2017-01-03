package client.hello_module.client;

import client.main_module.client.place.HomePlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Created by Saniye on 27.10.16.
 */

@WithTokenizers( { HomePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
