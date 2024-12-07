Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with "POST" http request
	Then The API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify place_Id created maps to "<name>" using "GetPlaceAPI"
Examples:
	|	name | language | address |
	|John	 | Chinese  | World Trade center|
#	|Mike  | Hindi    | Times Square      |


@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
	Given Delete Place Payload
	When User calls "DeletePlaceAPI" with "POST" http request
	Then The API call is success with status code 200
	And "status" in response body is "OK"