package com.sparta.fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwagCartPage {

    private final WebDriver driver;
    private String password = "secret_sauce";
    private String usernameStandard = "standard_user";
    private String userNameLocked = "locked_out_user";
    private String usernamePerformance = "performance_glitch_user";

    private By burgerMenuLink= new By.ById("react-burger-menu-btn");

    public SwagCartPage(WebDriver driver) {
        this.driver = driver;
    }
    //interactions with other pages

    public void clickContinueShopping(){
        driver.findElement(By.id("continue-shopping")).click();
    }

    public void checkout(){
        driver.findElement(By.id("checkout")).click();
    }

    public SwagCheckoutPage goToCheckoutPage(){
        driver.findElement(By.id("checkout")).click();
        return new SwagCheckoutPage(driver);
    }

    public SwagHomePage goToHomePage(){
        driver.findElement(By.id("continue-shopping")).click();
        return new SwagHomePage(driver);
    }

    public void goToAboutPage(){
        driver.findElement(burgerMenuLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));
        driver.findElement(By.id("about_sidebar_link")).click();
    }

    public void goToResetAppState(){
        driver.findElement(burgerMenuLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reset_sidebar_link")));
        driver.findElement(By.id("reset_sidebar_link")).click();
    }

    public List<WebElement> cartItemAdded(){
        return driver.findElements(By.className("cart_item"));
    }




}
