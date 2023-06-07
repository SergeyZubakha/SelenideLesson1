package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsTest {


    @Test
    void checkCodeForJunit() {
        Configuration.holdBrowserOpen = true;

//        - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
//        - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-rightbar .wiki-more-pages-link").$("[type=button]").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
