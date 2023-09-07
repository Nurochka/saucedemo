package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

//singletone - pattern класса для создания только одного! экземпляра драйвера
//(=private конструктор, private переменная, только геттер, нет сеттера (чтобы нельзя было создать, изменить экземпляр), метод статический)

public class DriverSingleton {

    private static ThreadLocal<DriverSingleton> instance = new ThreadLocal<>(); //потокобезопасность! предоставляет локальные переменные потока (hashCode)
    // для каждого потока свой driverSingleTone
    private WebDriver driver;

    private DriverSingleton() {

        driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized DriverSingleton getInstance() {
        if (null == instance.get()) {
            instance.set(new DriverSingleton());
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } finally {
            instance.remove();
        }
    }

}
