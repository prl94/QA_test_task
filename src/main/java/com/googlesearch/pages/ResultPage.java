package com.googlesearch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Володя on 03.06.2015.
 */
public class ResultPage extends Page {

    @FindBy (tagName = "title")
    public String UrlDomain;


    public ResultPage(WebDriver driver){
        super(driver);
       //  this.UrlDomain = driver.getCurrentUrl();
    }

    @Override
    public void open() {

    }

    public String currentUrl(){

        return driver.getCurrentUrl();
    }
}
