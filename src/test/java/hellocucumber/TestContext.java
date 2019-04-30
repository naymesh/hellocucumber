package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestContext {

    private final WebDriver driver = new ChromeDriver();

    private String favouriteSerchEngineName;
    private String favouriteSerchEngineUrl;

    public TestContext() {
        String defaultConfig = "default";
        String suppliedConfig = System.getProperty("testConfig");
        String configToUse = suppliedConfig != null ? suppliedConfig : defaultConfig;
        System.out.println("Using config: " + configToUse);
        try (InputStream input = SearchStepdefs.class.getClassLoader().getResourceAsStream(configToUse + ".config")) {
            // Load property file
            Properties prop = new Properties();
            prop.load(input);

            // Set properties in test context
            this.setFavouriteSerchEngineName(prop.getProperty("favourite.search.engine.name"));
            this.setFavouriteSerchEngineUrl(prop.getProperty("favourite.search.engine.url"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getFavouriteSerchEngineName() {
        return favouriteSerchEngineName;
    }

    public void setFavouriteSerchEngineName(String favouriteSerchEngineName) {
        this.favouriteSerchEngineName = favouriteSerchEngineName;
    }

    public String getFavouriteSerchEngineUrl() {
        return favouriteSerchEngineUrl;
    }

    public void setFavouriteSerchEngineUrl(String favouriteSerchEngineUrl) {
        this.favouriteSerchEngineUrl = favouriteSerchEngineUrl;
    }

    public void navigateTo(String url) {
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
