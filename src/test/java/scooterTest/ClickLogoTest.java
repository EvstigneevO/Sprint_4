package scooterTest;

import org.junit.Test;
import scooter.MainPage;
import scooter.OrderPage;


import static org.junit.Assert.assertEquals;

public class ClickLogoTest extends BaseTest {
    private String mainScooterPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String mainYandexPageUrl = "https://dzen.ru/?yredirect=true";

    @Test
    //Переход по клику на лого Самокат со страницы заказа на главную страницу Самоката
    public void goToMainPageAfterClickScooterLogoOnOrderPage() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.clickScooterLogo();
        String expectedPageUrl = driver.getCurrentUrl();
        assertEquals("При нажатии на логотип Самокат переход на неверную страницу", expectedPageUrl, mainScooterPageUrl);
    }

    @Test
    //Переход по клику на лого Яндекс со страницы заказа на главную страницу Яндекс
    public void goToYandexMainPageAfterClickScooterLogoOnOrderPage() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.clickYandexLogo();
        String currentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(currentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
        String expectedPageUrl = driver.getCurrentUrl();
        assertEquals("При нажатии на логотип Яндекс переход на неверную страницу", expectedPageUrl, mainYandexPageUrl);
    }

    @Test
    //Переход по клику на лого Яндекс с главной станицы Самокат на главную страницу Яндекс
    public void goToYandexMainPageAfterClickScooterLogoOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickYandexLogo();
        String currentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(currentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
        String expectedPageUrl = driver.getCurrentUrl();
        assertEquals("При нажатии на логотип Яндекс переход на неверную страницу", expectedPageUrl, mainYandexPageUrl);
    }
}
