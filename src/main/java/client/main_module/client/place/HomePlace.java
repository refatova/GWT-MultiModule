package client.main_module.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Saniye on 27.10.16.
 */
public class HomePlace extends Place {
    private String greetingMessage;


    public HomePlace(String s){
        this.greetingMessage=s;
    }

    public String getGreetingMessage(){

        return greetingMessage;
    }

    public static class Tokenizer implements PlaceTokenizer<HomePlace>
    {

        @Override
        public HomePlace getPlace(String token)
        {
            return new HomePlace(token);
        }

        @Override
        public String getToken(HomePlace place) {
            return place.getGreetingMessage();
        }


    }
}
