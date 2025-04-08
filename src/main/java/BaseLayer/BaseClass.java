package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	public BaseClass() {
		File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\ConfigurationLayer\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(f);

			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialisation() {

		System.setProperty("webdriver.chrome.driver", "chromedriverpath");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		String url = prop.getProperty("URL");
		driver.get(url);

	}
}