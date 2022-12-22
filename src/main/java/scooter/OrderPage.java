package scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/order";
    private final WebDriver driver;
    //Форма ввода данных "Для кого самокат"
    private By firstOrderForm = By.className("Order_Content__bmtHS");
    //Форма ввода имени
    private By nameInput = By.xpath("//input[@placeholder='* Имя']");
    //Форма ввода фамилии
    private By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");
    //Форма ввода адреса
    private By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающий список станций метро
    private By metroStationInput = By.className("select-search__input");
    //Форма ввода номера телефона
    private By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    //Форма ввода данных "Про аренду"
    private By secondOrderForm = By.className("Order_Content__bmtHS");
    //Форма "Когда привезти самокат"
    private By orderDeliveryDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Форма выбора срока аренды
    private By rentalPeriod  = By.className("Dropdown-placeholder");
    //Список кол-ва суток аренды
    private By rentDropdownList = By.xpath(".//div[@class='Dropdown-menu']/div[contains(@class,'Dropdown-option')]");
    //Цвет самоката черный жемчуг
    private By blackScooterColor = By.id("black");
    //Цвет самоката серая безысходность
    private By greyScooterColor = By.id("grey");
    //Комментарий для курьера
    private By courierComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказа самоката
    private By orderButton = By.xpath("//button[contains(@class,'Button_Middle') and contains(text(),'Заказать')]");
    //Модальное окно "Хотите оформить заказ"
    private By orderModal = By.className("Order_Modal__YZ-d3");
    //Кнопка "Да" модалки "Хотите оформить заказ"
    private By confirmOrderButton = By.xpath("//button[contains(@class,'Button_Middle') and contains(text(),'Да')]");
    //Модальное окно "Заказ оформлен"
    private By successOrderModal = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");
    //Самокат лого
    private By scooterLogo =  By.className("Header_LogoScooter__3lsAR");
    //Яндекс лого
    private By yandexLogo =  By.className("Header_LogoYandex__3TSOI");
    //Поле ввода номера заказа

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    //Ожидание загрузки формы "Для кого самокат"
    public void waitForFirstOrderForm() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(firstOrderForm));
    }
    //Заполнение поля имени
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    //Заполнение поля фамилии
    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }
    //Заполнение поля адреса
    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }
    //Заполнение поля станции метро
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationInput).sendKeys(metroStation);
        driver.findElement(metroStationInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroStationInput).sendKeys(Keys.ENTER);
    }
    //Заполнение поля номера телефона
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }
    //Нажатие на кнопку "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    //Ожидание загрузки формы "Про аренду"
    public void waitForSecondOrderForm(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(secondOrderForm));
    }
    //Заполнение поля даты доставки самоката
    public void setOrderDeliveryDate(String deliveryDate){
        driver.findElement(orderDeliveryDate).clear();
        driver.findElement(orderDeliveryDate).sendKeys(deliveryDate);
        driver.findElement(orderDeliveryDate).sendKeys(Keys.ENTER);
    }
    //Заполнение поля срока аренды
    public void setRentalPeriod(String rentRage){
        driver.findElement(rentalPeriod).click();
        List<WebElement> list = driver.findElements(rentDropdownList);
        for(WebElement element:list){
            if(element.getText().equals(rentRage)){
                element.click();
                break;
            }
        }
    }
    //Выбор цвета самоката
    public void setScooterColor(String color){
        switch (color) {
            case "чёрный жемчуг" -> driver.findElement(blackScooterColor).click();
            case "серая безысходность" -> driver.findElement(greyScooterColor).click();
            case "оба цвета" -> {
                driver.findElement(blackScooterColor).click();
                driver.findElement(greyScooterColor).click();
            }
        }
    }
    //Заполнение поля комментария для курьера
    public void setCourierComment(String comment){
        driver.findElement(courierComment).sendKeys(comment);
    }
    //Нажатие на кнопку "Заказать" для завершения заказа
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
    //Ожидание загрузки модального окна "Хотите оформить заказ?"
    public void waitForOrderModal(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderModal));
    }
    //Клик на кнопку "Да" модального окна "Хотите оформить заказ?"
    public void clickConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
    }
    //Ожидание загрузки модального окна "Заказ оформлен"
    public void waitForSuccessOrderModal() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(successOrderModal));
    }
    //Проверка отображениям модального окна "Заказ оформлен"
    public boolean isSuccessOrderModalDisplayed(){
        return driver.findElement(successOrderModal).isDisplayed();
    }
    //Клик по логотипу Самокат
    public void clickScooterLogo(){
        driver.findElement(scooterLogo).click();
    }
    //Клик по логотипу Яндекс
    public void clickYandexLogo(){
        driver.findElement(yandexLogo).click();
    }

}
