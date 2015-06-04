package com.googlesearch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.org.mozilla.javascript.internal.ast.PropertyGet;

import java.util.NoSuchElementException;

/**
 * Created by Володя on 03.06.2015.
 */
public abstract class Page {

    public WebDriver driver;

    public Page (WebDriver driver){
        this.driver = driver;
    }

    public void type (WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public abstract void open();

    public boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
