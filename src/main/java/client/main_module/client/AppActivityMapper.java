package client.main_module.client;

import client.main_module.client.activity.HomeActivity;
import client.main_module.client.place.HomePlace;
import client.shared.client.ClientFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Created by Saniye on 27.10.16.
 */
public class AppActivityMapper  implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace)
            return new HomeActivity((HomePlace) place,clientFactory);
        return null;
    }
}
