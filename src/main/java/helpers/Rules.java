package helpers;
import java.util.List;
import java.util.logging.Level;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Rules extends TestWatcher {
    private WebDriver driver;
    private List clientLog, serverLog, browserLog;

    public Rules(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        makeScreenshot();
        getPage();

        clientLog = driver.manage().logs().get(LogType.CLIENT).getAll();
        serverLog = driver.manage().logs().get(LogType.SERVER).getAll();
        browserLog = driver.manage().logs().get(LogType.BROWSER).filter(Level.WARNING);

        if (clientLog.size() > 0) {
            attachClientLog(clientLog);
        } else if (serverLog.size() > 0) {
            attachServerLog(serverLog);
        } else if (browserLog.size() > 0) {
            attachBrowserLog(browserLog);
        }
    }

    @Override
    protected void finished(Description description) {
        driver.quit();
    }

    @Attachment("Screenshot")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "HTML Document", type = "text/html")
    private String getPage() {
        return driver.findElement(By.cssSelector("html")).getAttribute("innerHTML");
    }

    @Attachment(value = "Client Log", type = "text/html")
    private List attachClientLog(List log) {
        return log;
    }

    @Attachment(value = "Server Log", type = "text/html")
    private List attachServerLog(List log) {
        return log;
    }

    @Attachment(value = "Browser Log", type = "text/html")
    private List attachBrowserLog(List log) {
        return log;
    }
}
