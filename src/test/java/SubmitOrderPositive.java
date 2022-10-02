import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import po.FormOrder;
import po.MainPage;


public class SubmitOrderPositive {
    private WebDriver driver;

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
/*        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверяем что заказ успешно создан
    @Test
    public void checkModalSubmit() {

        FormOrder objFormOrder = new FormOrder(driver);
        MainPage objMainPage = new MainPage(driver);

        objMainPage.clickSubmitOrderUp();
        objFormOrder.setNameInput("Алеша");
        objFormOrder.setSurnameInput("Паввло");
        objFormOrder.setAdressInput("Москва");
        objFormOrder.setMetroInput("Сокольники");
        objFormOrder.setPhoneInput("954578455456");
        objFormOrder.clickNextButton();
        objFormOrder.setDateInput("02.10.2022");
        objFormOrder.clickCheckBoxPeriod();
        objFormOrder.clickDropdownBlack();
        objFormOrder.clickSubmitOrderFormButton();
        objFormOrder.clickConfirmButton();
        objFormOrder.checkEnabledModalConfirm();
    }

    @Test
    public void checkModalSubmitTwo() {

        FormOrder objFormOrder = new FormOrder(driver);
        MainPage objMainPage = new MainPage(driver);

        objMainPage.clickSubmitOrderUp();
        objFormOrder.setNameInput("Павелаааааааааа");
        objFormOrder.setSurnameInput("Варигон");
        objFormOrder.setAdressInput("Санкт-Петербург");
        objFormOrder.setMetroInput("Красносельская");
        objFormOrder.setPhoneInput("88116111214");
        objFormOrder.clickNextButton();
        objFormOrder.setDateInput("4.10.22");
        objFormOrder.clickCheckBoxPeriod();
        objFormOrder.clickDropdownGrey();
        objFormOrder.clickSubmitOrderFormButton();
        objFormOrder.clickConfirmButton();
        objFormOrder.checkEnabledModalConfirm();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
