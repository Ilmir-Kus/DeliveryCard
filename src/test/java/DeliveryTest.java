import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {

    PlanningDate planningDate = new PlanningDate();
    int days = 4;

    @Test
    public void delTest() {
        open("http://localhost:9999/");
        $("[placeholder=Город]").setValue("Уфа");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(planningDate.generateDate(4));
        $("[name=name]").setValue("Иван Иванов");
        $("[name=phone]").setValue("+79372456783");
        $("[class=checkbox__text").click();
        $("[class=button__text]").click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate.generateDate(4)), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}