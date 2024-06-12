package ru.yandex.stellar.burgers;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellar.burgers.pages.MainPage;

import static com.codeborne.selenide.Condition.attributeMatching;
import static ru.yandex.stellar.burgers.constants.Constants.CLASS_ATTRIBUTE;
import static ru.yandex.stellar.burgers.constants.Constants.containsCurrent;

public class BuilderTest {
    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = MainPage.openMainPage();
    }

    @Test
    public void bunTabShouldBeSelected() {
        mainPage
                .clickOnBunTab()
                .getBunTab()
                .shouldHave(attributeMatching(CLASS_ATTRIBUTE, containsCurrent));
    }

    @Test
    public void sauceTabShouldBeSelected() {
        mainPage
                .clickOnSauceTab()
                .getSauceTab()
                .shouldHave(attributeMatching(CLASS_ATTRIBUTE, containsCurrent));
    }

    @Test
    public void fillingTabShouldBeSelected() {
        mainPage
                .clickOnFillingTab()
                .getFillingTab()
                .shouldHave(attributeMatching(CLASS_ATTRIBUTE, containsCurrent));
    }
}
