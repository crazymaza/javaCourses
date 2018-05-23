import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class InsuranceTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","C://ForPath/chromedriver.exe"); //Указываю где хромдрайвер
        ChromeOptions options = new ChromeOptions(); //Создаю объект класса ChromeOptions
        options.setBinary("C://Program Files (x86)//Google//Chrome//Application");//Указываю путь к браузеру
        driver = new ChromeDriver(); //Создаю экземпляр класса ChromeDriver
        wait = new WebDriverWait(driver,10); // Делаю тоже, для таймаута.
    }

    @Test
    public void myFirstTest(){
        driver.get("http://google.com"); //Открываю страницу по адресу
        WebElement element = driver.findElement(By.name("q")); //Нахожу там элемент по имени и присваиваю его переменной
        element.sendKeys("webdriver\n"); //Ввожу текст в поисковую строку
        wait.until(titleIs("webdriver - Поиск в Google")); //Ожидание отображения страницы
    }

    @After
    public void stop(){
        driver.quit(); //Закрытие браузера
        driver = null;
    }



}
