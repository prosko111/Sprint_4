import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.FormOrder;
import po.MainPage;

public class ModalOrderForm {

    private WebDriver driver;

    //Проверяем что форма заказа появилась, при нажатии кнопки "ЗаказатЬ" внизу страницы
    @Test
    public void checkModalForm() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        FormOrder objFormOrder = new FormOrder(driver);
        MainPage objMainPage = new MainPage(driver);

        objMainPage.clickAcceptCookie();
        objMainPage.clickSubmitOrderDown();
        objFormOrder.isDisplayedOrderForm();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
