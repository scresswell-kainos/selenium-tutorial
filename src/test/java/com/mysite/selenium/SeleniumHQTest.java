package com.mysite.selenium;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.xml.utils.StringComparable;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by seanc on 28/11/2016.
 */
public class SeleniumHQTest {

    private WebDriver driver = new ChromeDriver();

    public void main(String args[]){

    }

    @Test
    public void kevLogoExists(){
        setup(URL.HOME);
        WebElement mainLogo = driver.findElement(By.cssSelector(HomePage.LOC_IMG_MAINNAVKEV));
        assert (mainLogo.isDisplayed());
        burndown();
    }

    @Test
    public void loginButtonGoesToLogin(){
        setup(URL.HOME);
        WebElement loginNavButton = driver.findElement(By.id(HomePage.LOC_BTN_LOGIN));
        loginNavButton.click();
        WebElement loginButton = driver.findElement(By.id(LoginPage.LOC_BTN_LOGIN));
        assert(loginButton.isEnabled());
        burndown();
    }

    @Test
    public void loginErrorMessages(){
        setup(URL.LOGIN);
        WebElement loginButton = driver.findElement(By.id(LoginPage.LOC_BTN_LOGIN));
        loginButton.click();
        WebElement emailError = driver.findElement(By.cssSelector(LoginPage.LOC_DIV_EMAILERROR));
        WebElement passwordError = driver.findElement(By.cssSelector(LoginPage.LOC_DIV_PASSWORDERROR));
        String emailErrorShown = emailError.getText();
        String passwordErrorShown = passwordError.getText();
        assert(emailErrorShown.equals("You must enter an email address."));
        assert(passwordErrorShown.equals("You must enter your password."));
        burndown();
    }


    private void setup(String URI){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URI);
    }

    private void burndown() {
        driver.close();
    }



}
