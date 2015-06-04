package com.googlesearch.test;

import com.googlesearch.pages.GooglePage;
import com.googlesearch.pages.ResultPage;
import com.googlesearch.utils.ConfigProperties;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Володя on 03.06.2015.
 */
public class SearchTestCase extends BasicTestCase {

    private GooglePage googlePage = PageFactory.initElements(getWebDriver(), GooglePage.class);

    private ResultPage resultPage;

    @Test
    public void SuccessfulSearch() throws Exception {

        openGooglePage();
        fillAndSearch();
        checkSearch();
    }

    @Test (dependsOnMethods = { "SuccessfulSearch" })
    public void RandomClick(){
        randomClick();
        checkEquals();
    }

    @Step
    public void openGooglePage(){
        googlePage.open();
    }

    @Step
    public void fillAndSearch(){
        googlePage.makeSearch(ConfigProperties.getProperty("search.text"));
    }
    @Step
    public void checkSearch(){

        Assert.assertTrue(googlePage.searchResult.isDisplayed());
    }



    @Step
    public void randomClick(){
       resultPage =  googlePage.randomClick();
    }

    public void checkEquals(){
        System.out.println("random click link: " + googlePage.RandomLink);
        System.out.println("new page current URL: " + resultPage.currentUrl());
        Assert.assertTrue(googlePage.RandomLink.equals(resultPage.currentUrl()));
    }



}