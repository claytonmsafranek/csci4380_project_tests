
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class DeleteTodoItem {
  private WebDriver driver; 
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testDeleteTodoItem() throws Exception {
    driver.get("http://ec2-44-202-119-23.compute-1.amazonaws.com/app2/calendar_home.html");
    driver.findElement(By.id("Uname")).click();
    driver.findElement(By.id("Uname")).clear();
    driver.findElement(By.id("Uname")).sendKeys("test");
    driver.findElement(By.id("Pass")).click();
    driver.findElement(By.id("Pass")).clear();
    driver.findElement(By.id("Pass")).sendKeys("test");
    driver.findElement(By.id("log")).click();
    driver.get("http://ec2-44-202-119-23.compute-1.amazonaws.com/app2/user_calendar.html");
    driver.findElement(By.id("todoList")).click();
    driver.get("http://ec2-44-202-119-23.compute-1.amazonaws.com/app2/todo_list.html");
    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test todo medium'])[3]/following::a[1]")).click();
    driver.findElement(By.xpath("/html/body/div/div/ul/div[1]/a")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
