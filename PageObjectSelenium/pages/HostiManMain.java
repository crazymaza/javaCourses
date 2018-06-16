import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HostiManMain {

    WebDriver driver;
    By login = By.id("loginOrRegister");
    By homePage = By.tagName("h2");
    //By loginPopUp = By.className("popover-content");
    By popUpForm = By.className("form-control");
    By enter = By.xpath("//div[@class='popover-content']/form[1]/div[@class='form-group' and 2]" +
            "/div[@class='input-group' and 1]/span[@class='input-group-btn' and 1]" +
            "/input[@class='btn btn-primary' and 1]");


    /**
     * Конструктор класса
     * @param driver - это драйвер, который я указываю уже в тестовом классе
     */
    public HostiManMain(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Находим элемент на странице
     * @return - возвращаем текст элемента,
     * чтобы убедиться, что мы на главной странице
     */
    public String getMainPageH1Text() {
        return driver.findElement(homePage).getText();
    }

    /**
     * Нажимаем на кнопку входа
     */
    public void getLoginOnMainPage() {
         driver.findElement(login).click();
    }

    /**
     * Находим элементы в открывшемся попап элементе входа в ЛК
     * @param userName - имя пользователя
     * @param password - пароль пользователя
     */
    public void getPopUp(String userName, String password){
        List <WebElement> elements = driver.findElements(popUpForm);
        elements.get(2).sendKeys(userName);
        elements.get(3).sendKeys(password);
        driver.findElement(enter).click();
    }


}
