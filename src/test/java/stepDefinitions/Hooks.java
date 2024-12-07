package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		if(StepDefinition.place_id==null) {
		
		StepDefinition sd =new StepDefinition();
		sd.add_place_payload_with("Kane","Japanese","Tokyo");
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using("Kane","GetPlaceAPI");
		}
	}

}
