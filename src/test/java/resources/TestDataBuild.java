package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.LocationData;
import pojo.Place;

public class TestDataBuild {
	
	public Place addPlacePayload(String name, String language, String address) {
		Place newPlace = new Place();
		LocationData l = new LocationData();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		newPlace.setAccuracy(50);
		newPlace.setName(name);
		newPlace.setPhoneNumber("(+91) 983 893 3937");
		newPlace.setWebsite("https://kane.com");
		newPlace.setLanguage(language);
		newPlace.setAddress(address);
		List<String> typeslist = new ArrayList<String>();
		typeslist.add("mango");
		typeslist.add("apple");
		newPlace.setTypes(typeslist);
		newPlace.setLocation(l);
		return newPlace;
	}

	public String deletePlacePayload(String placeId) {
		
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}\r\n"
				+ "";
		
	}
}
