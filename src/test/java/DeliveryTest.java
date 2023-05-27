import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class DeliveryTest {
    @Test
    public void delTest() {
        open("http://localhost:9999/");
        $("[placeholder=Город]").setValue("Уфа");
        $$("[type=tel]").get(0).setValue("31.05.2023");
        $("[name=name]").setValue("Иван Иванов");
        $("[name=phone]").setValue("+79372456783");
        $("[class=checkbox__text").click();
        $("[class=button__text]").click();
        $("[data-test-id=notification]").should(appear, Duration.ofSeconds(12));
    }
}