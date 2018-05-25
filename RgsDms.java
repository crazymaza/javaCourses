import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class RgsDms {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select select;
    private WebElement element;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C://ForPath/chromedriver.exe"); //Указываю где хромдрайвер
        ChromeOptions options = new ChromeOptions(); //Создаю объект класса ChromeOptions
        options.setBinary("C://Program Files (x86)//Google//Chrome//Application");//Указываю путь к браузеру
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

     private void getSelect(WebElement element){
        select = new Select(element);
     }

    @Test
    public void rgsDms() throws Exception {
        firstPage();
        secondPage();
        thirdPage();
        modalWindow();
    }

    private void firstPage(){
        driver.get("http://www.rgs.ru");
        wait.until(titleIs("Росгосстрах – крупнейшая страховая компания России с 1921 года"));
//        WebElement element = driver.findElement(By.className("text-center"));
//        String txt = element.getText();
        element = driver.findElement(By.xpath("//div[@class = 'row text-center']" +
                "/div[@class = 'col-xs-4 col-sm-3 col-lg-2']/a[contains(text(),'Здоровье')]"));
        element.click();
    }

    private void secondPage(){
        wait.until(titleIs("Страхование здоровья"));
        element = driver.findElement(By.cssSelector(".list-group.list-group-rgs-menu.collapse" +
                " a:first-child"));
        element.click();
    }

    private void thirdPage(){
        wait.until(titleIs("ДМС 2018 \uD83D\uDE91 Добровольное медицинское страхование," +
                " рассчитать стоимость и оформить ДМС в Росгосстрахе"));
        element = driver.findElement(By.cssSelector(".rgs-context-bar-content-call-to-action-buttons" +
                " a:nth-child(4)"));
        element.click();
    }

    private void modalWindow(){
        element = driver.findElement(By.className("modal-content"));
        WebElement modalElement = element.findElement(By.name("LastName"));
        modalElement.sendKeys("Педрововочкин");
        modalElement = element.findElement(By.name("FirstName"));
        modalElement.sendKeys("Педро");
        modalElement = element.findElement(By.name("MiddleName"));
        modalElement.sendKeys("Педрович");
        modalElement = element.findElement(By.name("Region"));
        getSelect(modalElement);
        select.selectByVisibleText("Москва");
//        Номер телефона не получилось сделать
//        modalElement = element.findElement(By.cssSelector("input:nth-child(5)"));
//        modalElement = element.findElement(By.cssSelector(".form-control.validation-control-has-error"));
//        modalElement = element.findElement(By.xpath("//input[@class = " +
//                "'.form-control.validation-control-has-error']"));
//        modalElement.sendKeys("9455554545");
        modalElement = element.findElement(By.id("button-m"));
        if (modalElement.isEnabled()){
            System.out.println("Кнопка доступна, тест не пройден.");
        }

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
