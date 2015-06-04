package com.googlesearch.pages;

import com.googlesearch.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

/**
 * Created by Володя on 03.06.2015.
 */
public class GooglePage extends Page{

    public String RandomLink;

    @FindBy(id="lst-ib")
    public WebElement searchField;

    @FindBy(name = "btnG")
    public WebElement searchButton;

    @FindBy(className = "srg")
    public WebElement searchResult;


    public GooglePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("base.url"));
    }

    public void makeSearch(String searchString){
        type(searchField, searchString);
        searchButton.click();
    }

    public boolean isDisplayedResult(){
        if(searchResult.isDisplayed()){
            return true;
        }else return false;

    }
    public ResultPage randomClick(){

          //google "reclama"
            WebElement wb1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/li[1]/div/h3/a"));
            WebElement wb2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/li[2]/div/h3/a"));
            WebElement wb3 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/li[3]/div/h3/a"));
            WebElement wb4 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/li[4]/div/h3/a"));
          //google pictures
            WebElement wb5 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[1]/div/h3/a"));
            WebElement wb6 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[2]/div/h3/a"));
            WebElement wb7 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[3]/div/h3/a"));
            WebElement wb8 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[4]/div/h3/a"));
            WebElement wb9 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[5]/div/h3/a"));

            List<WebElement> searchList = new ArrayList<WebElement>();
            searchList.add(wb1);
            searchList.add(wb2);
            searchList.add(wb3);
            searchList.add(wb4);
            searchList.add(wb5);
            searchList.add(wb6);
            searchList.add(wb7);
            searchList.add(wb8);
            searchList.add(wb9);

        //get links to List
        List<WebElement> linkList = driver.findElements(By.className("_Rm"));

        //generate random number
        int randomLinkNumber = rand(linkList.size() - 1);

        RandomLink = linkList.get(randomLinkNumber).getText();

        searchList.get(randomLinkNumber).click();

    return PageFactory.initElements(driver, ResultPage.class);
    }

    public static int rand(int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - 0) + 1) + 0;

        return randomNum;
    }
}
