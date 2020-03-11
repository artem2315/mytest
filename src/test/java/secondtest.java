import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondtest {
    @Test
    public void secondtest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("softserve");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.quit();
    }
}