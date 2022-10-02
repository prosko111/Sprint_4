package po;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormOrder {
    private WebDriver driver;

    public FormOrder(WebDriver driver) {
        this.driver = driver;
    }

    /* Кнопка "Заказать" вверху
    private By submitOrderUp = By.className("Button_Button__ra12g")
    */
    //Модальное окно "Форма заказа"
    private By modalFormOrder = By.className("Order_Content__bmtHS");
    // Поле "Имя"
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    private By adressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private By metroInput = By.className("select-search__input");
    // Поле "Телефон"
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    //Поле "Когда привезти самокат"
    private By dateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Выпадающий список "Срок аренды"
    private By arendaPeriod = By.xpath(".//div[contains(text(),'* Срок аренды')]");
    //Выбор в выпадающем списке, 2ое суток
    private By periodDay = By.xpath(".//div[contains(text(),'двое суток')]");
    //Чек-бокс "Черный жемчуг"
    private By checkboxBlack = By.id("black");
    //Чек-бокс "Серая безысходность"
    private By checkboxGrey = By.id("grey");
    //Кнопка Заказать внизу формы оформления
    private By submitOrderFormButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка подтверждения заказа "Да"
    private By confirmButton = By.xpath(".//button[contains(text(),'Да')]");
    // Поп-ап "Успешное создание заказа"
    private By modalConfirm = By.xpath(".//div[contains(text(),'оформлен')]");

    public void isDisplayedOrderForm() {
        boolean actualResultOrderForm = driver.findElement(modalFormOrder).isDisplayed();
        Assert.assertTrue(actualResultOrderForm);
    }

    public void setNameInput(String username) {
        driver.findElement(nameInput).sendKeys(username);
    }

    public void setSurnameInput(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAdressInput(String adress) {
        driver.findElement(adressInput).sendKeys(adress);
    }

    public void setMetroInput(String metro) {
        driver.findElement(metroInput).click();
        driver.findElement(metroInput).sendKeys(metro);
        driver.findElement(metroInput).sendKeys(Keys.DOWN);
        driver.findElement(metroInput).sendKeys(Keys.ENTER);
    }

    public void setPhoneInput(String phoneNumber) {
        driver.findElement(phoneInput).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setDateInput(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        date = LocalDate.now().plusDays(2).format(formatter);
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);
    }

    public void clickCheckBoxPeriod() {
        driver.findElement(arendaPeriod).click();
        driver.findElement(periodDay).click();
    }

    public void clickDropdownBlack() {
        driver.findElement(checkboxBlack).click();
    }

    public void clickDropdownGrey() {
        driver.findElement(checkboxGrey).click();
    }

    public void clickSubmitOrderFormButton() {
        driver.findElement(submitOrderFormButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void checkEnabledModalConfirm() {
        boolean actualResult = driver.findElement(modalConfirm).isDisplayed();
        Assert.assertTrue(actualResult);
    }

}
