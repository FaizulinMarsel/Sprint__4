package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки заказать возле статуса заказа
    private final static By ORDER = By.cssSelector("button.Button_Button__ra12g");

    //Локатор для поля <Имя>
    private final static By NAME = By.xpath("//input[@placeholder='* Имя']");

    //Локатор для поля <Фамилия>
    private final static By SURNAME = By.xpath("//input[@placeholder='* Фамилия']");

    //Локатор для поля <Адрес>
    private final static By ADRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор для выбора станции метро
    private final static By STATION_METRO = By.cssSelector("input.select-search__input");

    //Локатор для поля <Телефон>
    private final static By TELEPHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор для кнопки <Далее>
    private final static By OK = By.xpath("//button[text()='Далее']");

    //Локатор для поля <Когда привезти самокат>
    private final static By DATE = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //Локатор для поля <Срок аренды>
    private final static By RENTAL_PERIOD = By.xpath("//div[@class = 'Dropdown-placeholder']");

    //Локатор для выбора цвета самоката
    private final static By COLOR = By.xpath("(//input[@class = 'Checkbox_Input__14A2w'])[2]");

    //Локатор для поля <Комментарий>
    private final static By COMMENT = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //Локатор для кнопки <Заказать> после ввода данных
    private final static By ORDER_OK = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для кнопки <Да> при подтверждении заказа
    private final static By CONFIRM_ORDER = By.xpath("//button[text()='Да']");

    public void clickOrder() {//Нажимаем на кнопку <Заказать>
        driver.findElement(ORDER).click();
    }

    public void fillName(String name) {//Заполняем имя
        driver.findElement(NAME).sendKeys(name);
    }

    public void fillSurname(String surname) {//Заполняем фамилию
        driver.findElement(SURNAME).sendKeys(surname);
    }

    public void fillAdress(String adress) {//Заполняем адрес
        driver.findElement(ADRESS).sendKeys(adress);
    }

    public void fillStationMetro() {//Выбираем станцию метро
        driver.findElement(STATION_METRO).click();
        driver.findElement(By.xpath("(//li[@class = 'select-search__row'])[3]")).click(); }//выбираем конкретную станцию

    public void fillTelephone(String number) {//Указываем телефон
        driver.findElement(TELEPHONE).sendKeys(number);
    }

    public void clickOk() {//Подтверждаем заполненную форму
        driver.findElement(OK).click();
    }

    public void fillDate() {//Указываем дату
        driver.findElement(DATE).click();
        driver.findElement(By.xpath("//div[contains(@class,'today')]")).click(); }//Указываем конкретный день

    public void fillRentalPeriod() {//указываем на какой период арендуем
        driver.findElement(RENTAL_PERIOD).click();
        driver.findElement(By.xpath("(//div[@class = 'Dropdown-option'])[3]")).click(); }//Выбираем период

    public void fillColor() {//Выбираем цвет
        driver.findElement(COLOR).click();//Цвет выбирается в локаторе
    }

    public void fillComment() {//Добавляем комментарий
        driver.findElement(COMMENT).sendKeys("Ну хоть что-то у меня получилось");
    }

    public void clickOrderOk() {//Подтверждаем изменения
        driver.findElement(ORDER_OK).click();
    }//Жмем на <Заказать> после заполнения всех полей

    public void clickConfirmOrder() {//Подтверждаем заказ
        driver.findElement(CONFIRM_ORDER).click(); }
}
