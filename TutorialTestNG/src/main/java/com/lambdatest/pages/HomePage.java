package com.lambdatest.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
    private By jqueryDownloadProgressBar = By.linkText("JQuery Download Progress bars");

    public BootstrapProgressBarPage clickBootstrapProgressBar(){
        click(bootstrapProgressBar);
        return new BootstrapProgressBarPage();
    }

    public JqueryDownloadProgressBarPage clickJqueryDownloadProgressBar(){
        click(jqueryDownloadProgressBar);
        return new JqueryDownloadProgressBarPage();
    }

}
