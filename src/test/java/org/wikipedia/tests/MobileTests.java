package org.wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MobileTests extends TestBase {
    @Test
    @DisplayName("Verify search is working")
    void verifySearchIsWorking() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Pass onboarding screen")
    void passOnboardingScreen() {
        step("Check first page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("We’ve found the following on your device:"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check second page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                            .shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
                });
        step("Check third page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check four page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/switchView")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                    .shouldHave(text("GET STARTED")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(text("Customize your Explore feed"));
        });
    }
}
