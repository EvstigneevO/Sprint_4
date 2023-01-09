package scooterTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.MainPage;
import scooter.OrderStatusPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderStatusTest extends BaseTest {
    private String orderNumber;

    public OrderStatusTest(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static String[] scooterRentParams() {
        return new String[]{
                "213",
                "42343242343243",
                "32432423423",
                "1"
        };
    }

    @Test
    public void orderNotFoundTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOrderStatusButton();
        mainPage.setOrderNumber(orderNumber);
        mainPage.clickGoButton();
        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        boolean isDisplayed = orderStatusPage.orderNotFoundImageIsDisplayed();
        assertTrue("Изображение \"Такого заказа нет\" не отображается", isDisplayed);

    }
}
