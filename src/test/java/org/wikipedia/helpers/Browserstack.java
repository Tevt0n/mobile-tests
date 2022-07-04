package org.wikipedia.helpers;

import org.aeonbits.owner.ConfigFactory;
import org.wikipedia.configs.BrowserstackConfig;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String getVideo(String sessionId) {
        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.browserstackUser(), config.browserstackKey())
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
