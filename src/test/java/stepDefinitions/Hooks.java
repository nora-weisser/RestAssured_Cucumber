package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        StepDefinition m = new StepDefinition();
        // execute this code only when place id is null
        if(StepDefinition.placeId == null) {
            // write code that will give you place id
            m.add_place_payload("Shetty", "French", "Asia");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
        }
    }
}
