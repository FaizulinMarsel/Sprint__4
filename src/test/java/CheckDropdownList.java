import PageObject.MainPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckDropdownList {
    //Переменная для выпадающего текста <Сколько это стоит? И как оплатить?>
    private String responseRentPrice = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Переменная для выпадающего текста <Хочу сразу несколько самокатов! Так можно?>
    private String responseRentalOfSeveralScooters = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Переменная для выпадающего текста <Как рассчитывается время аренды?>
    private String responseTimeRental = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Переменная для выпадающего текста <Можно ли заказать самокат прямо на сегодня?>
    private String responseRentForToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Переменная для выпадающего текста <Можно ли продлить заказ или вернуть самокат раньше?>
    private String responseChangeRentalTime = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Переменная для выпадающего текста <Вы привозите зарядку вместе с самокатом?>
    private String responseChargingScooter = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Переменная для выпадающего текста <Можно ли отменить заказ?>
    private String responseCancelOrder = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Переменная для выпадающего текста <Я жизу за МКАДом, привезёте?>
    private String responseBorderDelivery = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private WebDriver driver;

    @Before
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void CheckRentPrice(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickRentPrice();
        String textResponseOne = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-0']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseRentPrice, textResponseOne);
    }
    @Test
    public void CheckRentalOfSeveralScooters(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickRentalOfSeveralScooters();
        String textResponseTwo = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-1']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseRentalOfSeveralScooters, textResponseTwo);
    }
    @Test
    public void CheckTimeRental(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickTimeRental();
        String textResponseThree = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-2']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseTimeRental, textResponseThree);
    }
    @Test
    public void CheckRentForToday(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickRentForToday();
        String textResponseFour = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-3']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseRentForToday, textResponseFour);
    }
    @Test
    public void CheckChangeRentalTime(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickChangeRentalTime();
        String textResponseFive = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-4']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseChangeRentalTime, textResponseFive);
    }
    @Test
    public void CheckChargingScooter(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickChargingScooter();
        String textResponseSix = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-5']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseChargingScooter, textResponseSix);
    }
    @Test
    public void CheckCancelOrder(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickCancelOrder();
        String textResponseSeven = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-6']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseCancelOrder, textResponseSeven);
    }
    @Test
    public void CheckBorderDelivery(){
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickBorderDelivery();
        String textResponseEight = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-7']/p")).getText();
        Assert.assertEquals("Текст не совпадает", responseBorderDelivery, textResponseEight);
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
