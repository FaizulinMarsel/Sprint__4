package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject {

    private final WebDriver driver;

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки <Сколько это стоит? И как оплатить?>
    private final static By RENT_PRICE = By.xpath(".//*[@id = 'accordion__heading-0']");

    //Локатор для кнопки <Хочу сразу несколько самокатов! Так можно?>
    private final static By RENTAL_OF_SEVERAL_SCOOTERS = By.id("accordion__heading-1");

    //Локатор для кнопки <Как рассчитывается время аренды?>
    private final static By TIME_RENTAL = By.id("accordion__heading-2");

    //Локатор для кнопки <Можно ли заказать самокат прямо на сегодня?>
    private final static By RENT_FOR_TODAY = By.id("accordion__heading-3");

    //Локатор для кнопки <Можно ли продлить заказ или вернуть самокат раньше?>
    private final static By CHANGE_RENTAL_TIME = By.id("accordion__heading-4");

    //Локатор для кнопки <Вы привозите зарядку вместе с самокатом?>
    private final static By CHARGING_SCOOTER = By.id("accordion__heading-5");

    //Локатор для кнопки <Можно ли отменить заказ?>
    private final static By CANCEL_ORDER = By.id("accordion__heading-6");

    //Локатор для кнопки <Я жизу за МКАДом, привезёте?>
    private final static By BORDER_DELIVERY = By.id("accordion__heading-7");

    public void clickRentPrice() {driver.findElement(RENT_PRICE).click();}
    public void clickRentalOfSeveralScooters() {
        driver.findElement(RENTAL_OF_SEVERAL_SCOOTERS).click();
    }
    public void clickTimeRental() {
        driver.findElement(TIME_RENTAL).click();
    }
    public void clickRentForToday(){
        driver.findElement(RENT_FOR_TODAY).click();
    }
    public void clickChangeRentalTime(){
        driver.findElement(CHANGE_RENTAL_TIME).click();
    }
    public void clickChargingScooter(){
        driver.findElement(CHARGING_SCOOTER).click();
    }
    public void clickCancelOrder(){
        driver.findElement(CANCEL_ORDER).click();
    }
    public void clickBorderDelivery(){
        driver.findElement(BORDER_DELIVERY).click();
    }
}
