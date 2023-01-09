package scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    //Аккордеон с распространеными вопросами
    private By faq = By.className("accordion");
    //Заголовок элемента аккордеона
    private By faqAccordionElementHeader;
    //Выпадающий текст элемента аккордеона
    private By faqDropdownText;
    //Кнопка "Заказать" в хэдере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" в блоке "Как это работает"
    private By homeOrderButton = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[contains(text(), 'Заказать')]");
    //Яндекс лого
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    //Кнопка "Статус заказа"
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    //Поле ввода статуса заказа
    private By orderNumber = By.xpath("//input[@placeholder = 'Введите номер заказа']");
    //Кнопка Go!
    private By goButton = By.xpath("//button[contains(text(),'Go!')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    //Скролл до блока "Вопросы о важном"
    public void scrollToFaq() {
        WebElement element = driver.findElement(faq);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Получить элемент заголовка блока "Вопросы о важном"
    public By getFaqAccordionElementHeader(int itemNumber) {
        faqAccordionElementHeader = By.id("accordion__heading-" + itemNumber);
        return faqAccordionElementHeader;
    }

    //Получить элемент выпадающего списка из блока "Вопросы о важном"
    public By getAccordionDropdownText(int itemNumber) {
        faqDropdownText = By.id("accordion__panel-" + itemNumber);
        return faqDropdownText;
    }

    //Ожидание до появления элемента на странице
    public void waitForVisible(By element, int duration) {
        new WebDriverWait(driver, Duration.ofSeconds(duration))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //Клик по кнопке заказать в хэдере
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    //Скролл до кнопки заказать в блоке "Как это работает"
    public void scrollToHomeOrderButton() {
        WebElement element = driver.findElement(By.className("Home_RoadMap__2tal_"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Клик по кнопке заказать в блоке "Как это работает"
    public void clickHomeOrderButton() {
        driver.findElement(homeOrderButton).click();
    }

    //Клик по логотипу Яндекс
    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    //Клик по кнопке "Статус заказа"
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    //Заполнение номера заказа
    public void setOrderNumber(String order) {
        driver.findElement(orderNumber).sendKeys(order);
    }

    //Клик по кнопке Go!
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }
}

