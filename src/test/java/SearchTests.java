import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
        sleep(3000);
    }

    @Test
    void negativeSearchTest(){
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldNot(text("https://selenideeee.org"));
        Selenide.closeWindow();
    }

    @Test
    void searchInFlip(){
        open("https://www.flip.kz");
        $(By.xpath("/html//input[@id='search_input']")).setValue("казахстан").pressEnter();
        $("filter-left").isDisplayed();

    }
}
