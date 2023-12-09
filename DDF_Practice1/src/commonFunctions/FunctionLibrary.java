package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import driverFactory.AppUtile;

public class FunctionLibrary extends AppUtile{
	public static boolean Login(String USERNAME,String PASSWORD)
	{
		dr.get(p.getProperty("Url"));
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.findElement(By.xpath(p.getProperty("Objuser"))).sendKeys(USERNAME);
		dr.findElement(By.xpath(p.getProperty("Objpass"))).sendKeys(PASSWORD);
		dr.findElement(By.xpath(p.getProperty("LoginBtn"))).click();
		String Expected="dashboard";
		String Actual=dr.getCurrentUrl();
		if ( Actual.endsWith(Expected)) {
			Reporter.log("Login success::::"+Expected+"       "+Actual);
			return true;
		}
		else
		{
			Reporter.log("Login Failure::::"+Expected+"       "+Actual);
			return false;

		}
		


	}

}
