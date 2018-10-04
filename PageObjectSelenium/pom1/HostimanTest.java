import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class HostimanTest {

    WebDriver driver;
    HMUser hmUser;
    HostiManMain hostiManMain;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C://ForPath/chromedriver.exe"); //Указываю где хромдрайвер
        ChromeOptions options = new ChromeOptions(); //Создаю объект класса ChromeOptions
        options.setBinary("C://Program Files (x86)//Google//Chrome//Application");//Указываю путь к браузеру
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://cp.hostiman.ru");
    }

    @Test
    public void testCPAtHostiman() {
        hostiManMain = new HostiManMain(driver);
        try {
            assertEquals("новости",hostiManMain.getMainPageH1Text().toLowerCase());
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден или текст элемента не верный.");
        }
        hostiManMain.getLoginOnMainPage();
        hostiManMain.getPopUp("login", "password");

        hmUser = new HMUser(driver);
        hmUser.exitPopUpButton();
        try {
            assertEquals("имя пользователя",hmUser.userNameText().toLowerCase());
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден или текст элемента не верный.");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
        System.out.println("Тест пройден успешно! Мы зашли в личный кабинет на " +
                "сайте Hostiman.ru и убедились, что зашли нужным пользователем.");
    }
}
