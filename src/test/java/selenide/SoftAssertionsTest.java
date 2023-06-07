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
        //$(".markdown-body").$("div", 4).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
//                "class Tests {\n" +
//                "  @Test\n" +
//                "  void test() {\n" +
//                "    Configuration.assertionMode = SOFT;\n" +
//                "    open(\"page.html\");\n" +
//                "\n" +
//                "    $(\"#first\").should(visible).click();\n" +
//                "    $(\"#second\").should(visible).click();\n" +
//                "  }\n" +
//                "}"));
//         тут вопрос, почему по индексу 4 тест сверяет текст не с тем дивом, что я предплаоагаю? (с индексом 8 тест работает)
//         ведь такая запись $("h1").$("div") должна искать дочерний элемент первого уровня вложенности
//         а не дивы внутри дивов
    }
}
