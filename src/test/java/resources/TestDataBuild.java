package resources;

import pojoClasses.AddPlace;
import pojoClasses.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayload() {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setName("Frontline house");
        p.setPhone_number("(+91) 983 893 393");
        p.setAddress("29, side layout, cohen 09");
        p.setWebsite("http://google.com");
        p.setLanguage("French-IN");
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
