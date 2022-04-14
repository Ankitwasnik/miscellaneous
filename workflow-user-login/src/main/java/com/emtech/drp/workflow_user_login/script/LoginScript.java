package com.emtech.drp.workflow_user_login.script;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginScript {

  private static final String FF_PROFILE_PATH = "C:\\Users\\ankitw\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\1n0y5itx.Emtech-Workflow";
  private static final String URL = "http://localhost:3004";
  private static final String DEFAULT_OTP = "87654";

  public static void main(final String[] args) throws IOException, InterruptedException {
    WebDriverManager.firefoxdriver().setup();
    final FirefoxProfile firefoxProfile = new FirefoxProfile(new File(FF_PROFILE_PATH));
    final FirefoxOptions options = new FirefoxOptions();
    options.setProfile(firefoxProfile);
    final FirefoxDriver driver = new FirefoxDriver(options);

    final ObjectMapper objectMapper = new ObjectMapper();
    ClassLoader classLoader = LoginScript.class.getClassLoader();
    String departmentUsersFilePath = "department-users.json";
    final List<Department> departments1 = objectMapper.readValue(new File(classLoader.getResource(departmentUsersFilePath).getFile()),
        new TypeReference<List<Department>>() {});

    for (final Department dept : departments1) {
      for (final User user : dept.getUsers()) {
        final String containerName = dept.getName() + " " + user.getRole();
        final String containerUrl = "ext+container:name=" + containerName + "&url=" + URL + "&color=" + dept.getTabColor();
        driver.get(containerUrl);
        Thread.sleep(2000);
        final String[] windows = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(windows[windows.length - 1]);
        driver.get(URL);
        final WebElement email = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rea-wrapper > input:nth-child(1)")));
        email.sendKeys(user.getEmail());
        final WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys(user.getPassword());

        final WebElement signInBtn = driver.findElement(By.cssSelector(".btn"));
        signInBtn.click();

        final WebElement otpElem = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#otp")));

        otpElem.sendKeys(DEFAULT_OTP);
        WebElement submitOtpBtn = driver.findElement(By.cssSelector(".btn"));
        submitOtpBtn.click();
        driver.switchTo().newWindow(WindowType.TAB);
      }
    }
    // driver.quit();

  }
}

