import PageObject.OrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringStartsWith.startsWith;

@RunWith(Parameterized.class)
public class CheckOrder {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String adress;
    private final String number;
    private final String result;

    public CheckOrder(String name, String surname, String adress, String number, String result) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.number = number;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getCheckOrder() {
        return new Object[][]{{"Марсель", "Файзуллин", "Москва", "89711234567", "Заказ оформлен"},
                {"Имя", "Фамилия", "Санкт-Петербург", "79851024100", "Заказ оформлен"},};
    }


    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void checkOrder() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickOrder();
        orderPage.fillName(name);
        orderPage.fillSurname(surname);
        orderPage.fillAdress(adress);
        orderPage.fillStationMetro();
        orderPage.fillTelephone(number);
        orderPage.clickOk();
        orderPage.fillDate();
        orderPage.fillRentalPeriod();
        orderPage.fillColor();
        orderPage.fillComment();
        orderPage.clickOrderOk();
        orderPage.clickConfirmOrder();
        String textOrderProcessed = driver.findElement(By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ']")).getText();
        MatcherAssert.assertThat(textOrderProcessed, startsWith(result));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
