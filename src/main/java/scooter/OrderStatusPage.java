package scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/track";
    private final WebDriver driver;
    //Картинка "Такого заказа нет"
    private By orderNotFoundImage = By.className("Track_NotFound__6oaoY");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean orderNotFoundImageIsDisplayed() {
        return driver.findElement(orderNotFoundImage).isDisplayed();
    }
}
