package com.lambdatest.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JqueryDownloadProgressBarPage extends BasePage {

    private By startDownloadButton = By.id("downloadButton");
    private By CompletedMessage = By.xpath("//div[@id='dialog']//div[@class='progress-label']");

    public void clickStartDownloadButton() {
        click(startDownloadButton);
    }

    public String getCompletedMessage() {
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 100 Milliseconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progress = find(CompletedMessage);
                String progressBarText = progress.getText();

                if (progressBarText.equals("Complete!")) {
                    System.out.println("Progress Is Complete!");
                    return progress;
                } else {
                    System.out.println(progress.getText());
                    return null;
                }
            }
        });
        return getText(CompletedMessage);
    }

}
