package trainline.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class ParentPage extends DSL {

    public ParentPage(WebDriver driver) {
        super(driver);
    }


}
