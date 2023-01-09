package scooterTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.MainPage;
import scooter.OrderPage;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderButtonsTest extends BaseTest {
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String orderDeliveryDate;
    private String rentRange;
    private String color;
    private String comment;
    private boolean isDisplayed;

    public OrderButtonsTest(String name,
                            String surname,
                            String address,
                            String metroStation,
                            String phoneNumber,
                            String orderDeliveryDate,
                            String rentRange,
                            String color,
                            String comment,
                            boolean isDisplayed) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.orderDeliveryDate = orderDeliveryDate;
        this.rentRange = rentRange;
        this.color = color;
        this.comment = comment;
        this.isDisplayed = isDisplayed;
    }

    @Parameterized.Parameters
    public static Object[][] scooterRentParams() {
        return new Object[][]{
                {"Сергей", "Иванов", "Веласкеса, 7к5", "Пушкинская", "89263528482", "22.12.2022", "сутки", "чёрный жемчуг", "позвонить за 15минут до приезда", true},
                {"Чан", "Джеки", "Пушкина,125", "Выхино", "+7165171215", "11.11.2022", "четверо суток", "серая безысходность", "1242422324", true},
                {"Тони", "Старк", "Петровка,38 корпус 1, строение 8", "Лубянка", "123456647325", "10.02.2023", "семеро суток", "оба цвета", "", true},
        };
    }

    @Test
    //Успешный заказ самоката с использованием кнопки "Заказать" в хэдере
    public void orderScooterFromHeaderButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickHeaderOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitForFirstOrderForm();
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.waitForSecondOrderForm();
        orderPage.setOrderDeliveryDate(orderDeliveryDate);
        orderPage.setRentalPeriod(rentRange);
        orderPage.setScooterColor(color);
        orderPage.setCourierComment(comment);
        orderPage.clickOrderButton();
        orderPage.waitForOrderModal();
        orderPage.clickConfirmOrderButton();
        orderPage.waitForSuccessOrderModal();
        assertEquals("Модальное окно успешного заказа не отображается", orderPage.isSuccessOrderModalDisplayed(), isDisplayed);
    }

    @Test
    //Успешный заказ самоката с использованием кнопки "Заказать" в блоке "Как это работает"
    public void orderScooterFromHomeButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scrollToHomeOrderButton();
        mainPage.clickHomeOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitForFirstOrderForm();
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.waitForSecondOrderForm();
        orderPage.setOrderDeliveryDate(orderDeliveryDate);
        orderPage.setRentalPeriod(rentRange);
        orderPage.setScooterColor(color);
        orderPage.setCourierComment(comment);
        orderPage.clickOrderButton();
        orderPage.waitForOrderModal();
        orderPage.clickConfirmOrderButton();
        orderPage.waitForSuccessOrderModal();
        assertEquals("Модальное окно успешного заказа не отображается", orderPage.isSuccessOrderModalDisplayed(), isDisplayed);
    }
}
