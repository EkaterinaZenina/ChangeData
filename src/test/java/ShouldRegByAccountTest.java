import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class ShouldRegByAccountTest {
    String planingDate = DataGenerator.generateDate(3);
    String newPlaningDate = DataGenerator.generateDate(5);
    @Test
    public void shouldRegByAccount() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        $("[data-test-id='city'] .input__control").setValue(DataGenerator.getCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.generateDate(3));
        $("[data-test-id='name'] .input__control").setValue(DataGenerator.getName());
        $x("//*[@name='phone']").setValue(DataGenerator.getPhone());
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='notification']").shouldHave(text("Встреча успешно забронирована на "+ planingDate), Duration.ofSeconds(15)).shouldBe(visible);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(DataGenerator.newPlanningDate(1));
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + newPlaningDate) , Duration.ofSeconds(15)).shouldBe(visible);
    }
}





