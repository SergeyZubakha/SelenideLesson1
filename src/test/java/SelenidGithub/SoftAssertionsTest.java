package SelenidGithub;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsTest {
    @Test
    void checkCodeForJunit(){
//        - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
//        - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-more-pages-link").$(byText("Show 2 more pages")).click();
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    }
}
