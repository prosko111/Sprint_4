package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Заказать" вверху
    private By submitOrderUp = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" внизу
    private By submitOrderDown = By.className("Home_FinishButton__1_cWm");
    //Лого "Яндекс" в шапке
    private By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']");
    //Лого "Самокат" в шапке
    private By logoScooters = By.xpath(".//img[@src='/assets/scooter.svg']");
    //Кнопка "Статус заказа"
    private By statusButton = By.className("Header_Link__1TAG7");
    //Выпадающий список, "Сколько это стоит?"
    private By howMuchCostQuestion = By.xpath(".//*[@id=\"accordion__heading-0\"]");
    //Выпадающий список, "Сутки -400руб"
    private By howMuchCostResponse = By.id("accordion__panel-0");
    //Выпадающий список "Хочу сразу несколько самокатов"
    private By manyScootersQuestion = By.id("accordion__heading-1");
    //Выпадающий список "Пока что у нас один"
    private By manyScootersResponse = By.id("accordion__panel-1");
    //Выпадающий список "Как рассчитывается время аренды"
    private By rentalTimeCalculationQestion = By.id("accordion__heading-2");
    //Выпад. список "пока что у нас один"
    private By rentalTimeCalculationResponse = By.id("accordion__panel-2");
    //Выпад. список "Можно ли заказать сегодня"
    private By orderTodayQuestion = By.id("accordion__heading-3");
    //Выпад. список "Только с завтрешнего дня"
    private By orderTodayResponse = By.id("accordion__panel-3");
    //Выпад список "Продлить заказ"
    private By longOrderQuestion = By.id("accordion__heading-4");
    //Выпад список "Пока что нет"
    private By longOrderResponse = By.id("accordion__panel-4");
    //Выпад список "Привозите зарядку?"
    private By chargeQuestion = By.id("accordion__heading-5");
    //Выпад список "Самока тприезжает с полной зарядкой"
    private By chargeResponse = By.id("accordion__panel-5");
    //Выпад список "отменить заказ"
    private By cancelQuestion = By.id("accordion__heading-6");
    //Выпад список "Да, можно отменить"
    private By cancelResponse = By.id("accordion__panel-6");
    //Выпад список "Живу за МКАДОМ"
    private By adressQuestion = By.id("accordion__heading-7");
    //Выпад список "Да, обязательно"
    private By adressResponse = By.id("accordion__panel-7");
    //Кнопка "Принять куки"
    private By acceptCookie = By.className("App_CookieButton__3cvqF");


    public void clickSubmitOrderUp() {
        driver.findElement(submitOrderUp).click();
    }

    public void clickSubmitOrderDown() {

//        WebElement element = driver.findElement(submitOrderDown);
/*        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);*/
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(submitOrderDown).click();
    }

    public void clickHowMuchCostQuestion() {
        driver.findElement(howMuchCostQuestion).click();
    }

    public String getTextReponseCost() {
        return driver.findElement(howMuchCostResponse).getText();
    }

    public void clickManyScootersQuestion() {
        driver.findElement(manyScootersQuestion).click();
    }

    public String getTextReponseManyScooters() {
        return driver.findElement(manyScootersResponse).getText();
    }

    public void clickRentalTimeCalcQuestion() {
        driver.findElement(rentalTimeCalculationQestion).click();
    }

    public String getTextReponseRentalTime() {
        return driver.findElement(rentalTimeCalculationResponse).getText();
    }

    public void clickOrderTodayQuestion() {
        driver.findElement(orderTodayQuestion).click();
    }

    public String getTextReponseOrderToday() {
        return driver.findElement(orderTodayResponse).getText();
    }

    public void clickLongOrderQuestion() {
        driver.findElement(longOrderQuestion).click();
    }

    public String getTextReponseLongOrder() {
        return driver.findElement(longOrderResponse).getText();
    }

    public void clickChargeQuestion() {
        driver.findElement(chargeQuestion).click();
    }

    public String getTextReponseCharge() {
        return driver.findElement(chargeResponse).getText();
    }

    public void clickCancelQuestion() {
        driver.findElement(cancelQuestion).click();
    }

    public String getTextReponseCancel() {
        return driver.findElement(cancelResponse).getText();
    }

    public void clickAdressQuestion() {
        driver.findElement(adressQuestion).click();
    }

    public String getTextReponseAdress() {
        return driver.findElement(adressResponse).getText();
    }

    public void clickAcceptCookie() {
        driver.findElement(acceptCookie).click();
    }

}
