package scooterTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {
    //Заголовок элемента аккордеона
    private String accordionElementHeader;

    //Выпадающий текст элемента аккордеона
    private String accordionDropdownText;

    //Номер элемента аккордеона
    private int itemNumber;

    public FaqTest(String accordionElementHeader, String accordionDropdownText, int itemNumber) {
        this.accordionElementHeader = accordionElementHeader;
        this.accordionDropdownText = accordionDropdownText;
        this.itemNumber = itemNumber;
    }

    @Parameterized.Parameters
    public static Object[][] expectedHeaderAndText() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Test
    // Проверка текста хэдеров аккордеона
    public void faqCheckHeaderTextTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToFaq();
        String actualHeaderText = driver.findElement(mainPage.getFaqAccordionElementHeader(itemNumber)).getText();
        assertEquals("Текст хэдера не соответствует ожидаемому", accordionElementHeader, actualHeaderText);

    }

    @Test
    //Проверка текста при нажатии на хэдер блока "Вопросы о важном"
    public void faqCheckDropdownTextTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToFaq();
        driver.findElement(mainPage.getFaqAccordionElementHeader(itemNumber)).click();
        mainPage.waitForVisible(mainPage.getAccordionDropdownText(itemNumber), 3);
        String actualDropDownText = driver.findElement(mainPage.getAccordionDropdownText(itemNumber)).getText();
        assertEquals("Текст блока не соответствует ожидаемому", accordionDropdownText, actualDropDownText);
    }

}
