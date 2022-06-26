package org.wikipedia.helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class GetVideo {

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("sergeyburmistrov_A82pwk", "1NiPAqNAFTco7tjsL6Ay")
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
