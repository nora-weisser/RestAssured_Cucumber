package resources;

import pojoClasses.AddPlace;
import pojoClasses.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayload(String name, String language, String address) {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 393");
        p.setAddress(address);
        p.setWebsite("http://google.com");
        p.setLanguage(language);
        List<String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("shop");
        p.setTypes(types);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        p.setLocation(location);
        return p;
    }
}
