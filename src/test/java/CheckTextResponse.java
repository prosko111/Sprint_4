import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.MainPage;

public class CheckTextResponse {
    private WebDriver driver;

    @Before
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверяем строки в выпадающем списке
    @Test
    public void checkTextHowMuchCost() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickHowMuchCostQuestion();
        String textActualCost = objMainPage.getTextReponseCost();
        String textExpectedCost = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(textExpectedCost, textActualCost);
    }

    @Test
    public void checkTextManyScooters() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickManyScootersQuestion();
        String textActualManyScooters = objMainPage.getTextReponseManyScooters();
        String textExpectedManyScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(textExpectedManyScooters, textActualManyScooters);
    }

    @Test
    public void checkTextRentalTime() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickRentalTimeCalcQuestion();
        String textActualRentalTime = objMainPage.getTextReponseRentalTime();
        String textExpectedRentalTime = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(textExpectedRentalTime, textActualRentalTime);
    }

    @Test
    public void checkTextOrderToday() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickOrderTodayQuestion();
        String textActualOrderToday = objMainPage.getTextReponseOrderToday();
        String textExpectedOrderToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(textExpectedOrderToday, textActualOrderToday);
    }

    @Test
    public void checkTextLongOrder() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickLongOrderQuestion();
        String textActualLongOrder = objMainPage.getTextReponseLongOrder();
        String textExpectedLongOrder = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals(textExpectedLongOrder, textActualLongOrder);
    }

    @Test
    public void checkTextCharge() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickChargeQuestion();
        String textActualCharge = objMainPage.getTextReponseCharge();
        String textExpectedCharge = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals(textExpectedCharge, textActualCharge);
    }

    @Test
    public void checkTextCancel() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickCancelQuestion();
        String textActualCancel = objMainPage.getTextReponseCancel();
        String textExpectedCancel = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals(textExpectedCancel, textActualCancel);
    }

    @Test
    public void checkTextAddress() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickAcceptCookie();
        objMainPage.clickAdressQuestion();
        String textActualAddress = objMainPage.getTextReponseAdress();
        String textExpectedAddress = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals(textExpectedAddress, textActualAddress);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
