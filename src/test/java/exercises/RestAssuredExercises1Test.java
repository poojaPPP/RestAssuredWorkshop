package exercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;

public class RestAssuredExercises1Test {

	private static RequestSpecification requestSpec;

//	@Rule
//	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	@BeforeClass
	public static void createRequestSpecification() {

		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://api.zippopotam.us").
		//	setPort(9876).
			build();
	}

	/*******************************************************
	 * Send a GET request to /us/90210
	 * and check that the response has HTTP status code 200
	 ******************************************************/

	@Test (groups = { "smoke", "regression" } )
	@Parameters("KeyzfromXmlParameter")
	public void requestUsZipCode90210_checkResponseCode_expect200() {
		System.out.println("==test1=====");
System.out.println("Value fethced form the xml parameter file" +"  KeyzfromXmlParameter");
		given().
			spec(requestSpec).
			when().
				get("/us/90210").
			then().assertThat().statusCode(200);
	}

	/*******************************************************
	 * Send a GET request to /us/99999
	 * and check that the answer has HTTP status code 404
	 ******************************************************/

	@Test (priority = 2)
	public void requestUsZipCode99999_checkResponseCode_expect404() {
		System.out.println("==test2=====");
		given().
			spec(requestSpec).
			when().
				get("/us/99999").
			then().assertThat().statusCode(404);
	}

	/*******************************************************
	 * Send a GET request to /us/90210
	 * and check that the response is in JSON format
	 ******************************************************/

	@Test (priority = 3)
	public void requestUsZipCode90210_checkContentType_expectApplicationJson() {
		System.out.println("==test3=====");
		given().
			spec(requestSpec).
			when().
				get("/us/90210").
			then().log().all().assertThat().statusCode(200).
				and().contentType(equalTo("application/json"));

			Assert.assertEquals(200, 200, "Passed");


	}

	/***********************************************
	 * Send a GET request to /us/90210 and check
	 * that the state associated with the first place
	 * in the list returned is equal to 'California'
	 **********************************************/

	@Test
	public void requestUsZipCode90210_checkStateForFirstPlace_expectCalifornia() {
		System.out.println("====requestUsZipCode90210_checkStateForFirstPlace_expectCalifornia=====");
		given().
			spec(requestSpec).
			when().
				get("/us/90210 ").
				then().assertThat().
				body("places.'state'", hasItem("California"));
	}

	/***********************************************
	 * Send a GET request to /de/24848 and check that
	 * the list of place names returned contains the
	 * value 'Kropp'
	 **********************************************/

	@Test
	public void requestDeZipCode24848_checkListOfPlaceNames_expectContainsKropp() {
		System.out.println("====requestDeZipCode24848_checkListOfPlaceNames_expectContainsKropp=====");
		given().
				spec(requestSpec).
				when().
				get("/de/24848").
				then().
				assertThat().
				body("places.'place name'", hasItem("Kropp"));
	}

	/***********************************************
	 * Send a GET request to /de/24848 and check that
	 * the list of place names returned does not
	 * contain the value 'Frankfurt'
	 **********************************************/

	@Test
	public void requestDeZipCode24848_checkListOfPlaceNames_expectDoesNotContainFrankfurt() {
		System.out.println("====requestDeZipCode24848_checkListOfPlaceNames_expectDoesNotContainFrankfurt=====");
		given().
				spec(requestSpec).
				when().
				get("/de/24848").
				then().
				assertThat().
				body("places.'place name'", not(hasItem("Frankfurt")));
	}

	/***********************************************
	 * Send a GET request to /de/24848 and check that
	 * the list of place names returned is a
	 * collection of size 4
	 **********************************************/

	@Test
	public void requestDeZipCode24848_checkNumberOfPlaceNames_expect4() {
		System.out.println("====requestDeZipCode24848_checkNumberOfPlaceNames_expect4=====");
		given().
			spec(requestSpec).
			when().
				get("/de/24848").
			then().assertThat().body("places.'place name'", hasSize(4));
	}
}