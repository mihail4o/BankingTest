import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_Class1 {
    static {
        System.setProperty("webdriver.gecko.driver",
//                "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
                "/Users/balivo/Downloads/selenium/course/geckodriver");

    }
    public static final WebDriver webDriver = new FirefoxDriver();

    String launchPageHeading = "//h2[text()='Guru99 Bank']";
    final String    userName_element = "//input[@name='uid']",
            password_element = "//input[@name='password']",
            signIn_element = "//input[@name='btnLogin']";

    // Take a new credentials from wwww.demo.guru99.com
    final String userName_value = "mngr214692", password_value = "nYrurUd";

    final String managerID = "//td[contains(text(),'Manger Id')]";
    final String newCustomer = "//a[@href='addcustomerpage.php']";
    final String fundTransfer = "//a[@href='FundTransInput.php']";

    /**
     * This test case will initialize the webDriver
     */

    @Test (groups = {"bonding", "strong_ties"})
    public void tc01LaunchURL() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://www.demo.guru99.com/V4/");
    }

    /**
     * Will check the presence of Heading on Login Page
     */
    @Test (groups = {"bonding"})
    public void tc02VerifyLaunchPage() {
        Assert.assertTrue(webDriver.findElement(By.xpath(launchPageHeading)).isDisplayed(),
                "Home Page heading is not displayed");
        System.out.println("Home Page heading is displayed");
    }

    /**
     * This test case will enter User name, password and will then click on
     * signIn button
     */
    @Test (groups = {"bonding", "strong_ties"})
    public void tc03EnterCredentials() {
        webDriver.findElement(By.xpath(userName_element)).sendKeys(userName_value);
        webDriver.findElement(By.xpath(password_element)).sendKeys(password_value);
        webDriver.findElement(By.xpath(signIn_element)).click();
    }

    /**
     * This test case will verify manger's ID presence on DashBoard
     */
    @Test (groups = {"strong_ties"})
    public void tc04VerifyLoggedInPage() {
        Assert.assertTrue(webDriver.findElement(By.xpath(managerID)).isDisplayed(),
                "Manager ID label is not displayed");
        System.out.println("Manger Id label is displayed");
    }

    /**
     * This test case will check the presence of presence of New customer link
     * And FundTransfer link in Left pannel
     */
    @Test (groups = {"bonding"})
    public void tc05VerifyHyperLinks() {
        Assert.assertTrue(webDriver.findElement(By.xpath(newCustomer)).isEnabled(),
                "New customer hyperlink is not displayed");
        System.out.println("New customer hyperlink is displayed");

        Assert.assertTrue(webDriver.findElement(By.xpath(fundTransfer)).isEnabled(),
                "Fund Transfer hyperlink is not displayed");
        System.out.println("Fund Transfer hyperlink is displayed");
    }
}