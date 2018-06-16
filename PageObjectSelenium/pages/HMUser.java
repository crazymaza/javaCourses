import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HMUser {

    WebDriver driver;
    By exitPopUpButton = By.xpath("//a[@class='btn btn-danger']");
    By nameText = By.xpath("//div[@class='panel-body']/strong[1]");

    public HMUser(WebDriver driver) {
        this.driver = driver;
    }

    public void exitPopUpButton() {
        driver.findElement(exitPopUpButton).click();
    }

    /**
     * Здесь мы смотрим, что по данному запросу нам возвращает нужное значение
     * Предварительно "Игорь Вальнев".
     * @return
     */
    public String userNameText() {
        return driver.findElement(nameText).getText();
    }

}
