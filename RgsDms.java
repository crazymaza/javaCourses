import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class RgsDms {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C://ForPath/chromedriver.exe"); //Указываю где хромдрайвер
        ChromeOptions options = new ChromeOptions(); //Создаю объект класса ChromeOptions
        options.setBinary("C://Program Files (x86)//Google//Chrome//Application");//Указываю путь к браузеру
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void rgsDms() throws Exception {
        driver.get("http://www.rgs.ru");
        wait.until(titleIs("Росгосстрах – крупнейшая страховая компания России с 1921 года"));
//        WebElement element = driver.findElement(By.className("text-center"));
//        String txt = element.getText();
        WebElement element = driver.findElement(By.xpath("//div[@class = 'row text-center']" +
                "/div[@class = 'col-xs-4 col-sm-3 col-lg-2']/a[contains(text(),'Здоровье')]"));
        element.click();
        wait.until(titleIs("Страхование здоровья"));
        WebElement element1 = driver.findElement(By.cssSelector(".list-group.list-group-rgs-menu.collapse a:first-child"));
        element1.click();
        wait.until(titleIs("ДМС 2018 \uD83D\uDE91 Добровольное медицинское страхование, рассчитать стоимость и оформить ДМС в Росгосстрахе"));
        WebElement element2 = driver.findElement(By.cssSelector(".rgs-context-bar-content-call-to-action-buttons a:nth-child(4)"));
        element2.click();
        WebElement element3 = driver.findElement(By.className("modal-content"));
        WebElement elementLname = element3.findElement(By.name("LastName"));
        elementLname.sendKeys("Педрововочкин");
        WebElement elementFname = element3.findElement(By.name("FirstName"));
        elementFname.sendKeys("Педро");
        WebElement elementMname = element3.findElement(By.name("MiddleName"));
        elementFname.sendKeys("Педрович");


    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
