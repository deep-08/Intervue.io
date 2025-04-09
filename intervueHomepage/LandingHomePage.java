package intervueHomepage;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class LandingHomePage {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.get("https://www.intervue.io/");
            driver.findElement(By.xpath("//div[@id='iv-homepage-login']//div//span[contains(text(),'Login')]")).click();
            Thread.sleep(2000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(1));
                System.out.println("Switched to new tab: " + driver.getCurrentUrl());
            } else {
                System.out.println("No new tab opened!");
            }
            System.out.println("New tab title: " + driver.getTitle());

            driver.findElement(By.xpath("//a[@href='/login']//div[@class='AccessAccount-ColoredButton-Text'][normalize-space()='Login']")).click();
            driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("neha@intervue.io");
            driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Ps@neha@123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            Thread.sleep(2000);

            boolean loginFailed = !driver.findElements(By.xpath("//span[@class='ant-alert-description']")).isEmpty();
            if (loginFailed) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationFile = new File("screenshots/login_failure_" + System.currentTimeMillis() + ".png");
                FileUtils.copyFile(screenshot, destinationFile);
                System.out.println("Login failed! Screenshot saved at: " + destinationFile.getAbsolutePath());
            } else {
                System.out.println("Login successful! Proceeding to next step...");
            }
            
            driver.findElement(By.xpath("//span[@class='search_placeholder']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Type what you want to search for']")).sendKeys("hello");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='SearchThrough__SearchText-sc-8f4vh4-1 rBWuk']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='ProfileHeader__UsernameWrap-sc-1gwp6c1-2 jRhmUi']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
        	driver.quit();
        }
    }
}