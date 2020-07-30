package com.amazon.page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='/gp/sva/dashboard?ref_=nav_cs_apay']")
	private WebElement amazonpayLink;

	@FindBy(xpath = "//img[@src=\"https://m.media-amazon.com/images/G/31/apay/"
			+ "dashboard/Mobile-recharge-new._CB449984748_.png\"]")
	private WebElement amazonpay_mobilerecharge;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement phonenumber;

	public void amazonPay(WebDriver driver) throws MalformedURLException, IOException {
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("find the all links and images size" + linklist.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href") + i+"--->"+linklist.get(i).getText());
			linklist = driver.findElements(By.tagName("a"));
			linklist.addAll(driver.findElements(By.tagName("img")));
			if (linklist.get(i).getAttribute("href") != null
					&& (!linklist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(linklist.get(i));
			}
		}
		System.out.println("size of active links and images" + activelinks.size());
		DesiredCapabilities desired = new DesiredCapabilities();
		for (int j = 0; j < activelinks.size(); j++) {
			desired.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			
			/*
			 * try { SSLContext ssl_ctx = SSLContext.getInstance("TLS"); TrustManager[]
			 * trust_mgr = new TrustManager[] { new X509TrustManager() { public
			 * X509Certificate[] getAcceptedIssuers() { return null; }
			 * 
			 * public void checkClientTrusted(X509Certificate[] certs, String t) { }
			 * 
			 * public void checkServerTrusted(X509Certificate[] certs, String t) { } } };
			 * ssl_ctx.init(null, // key manager trust_mgr, // trust manager new
			 * SecureRandom(), null); // random number generator
			 * HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory()); }
			 * catch (NoSuchAlgorithmException e) { e.printStackTrace(); } catch
			 * (KeyManagementException e) { e.printStackTrace(); }
			 */
			HttpURLConnection connec = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();
			//desired.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			connec.connect();

			int responce = connec.getResponseCode();
			connec.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href") + "---->" + responce + j);

			/*
			 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); boolean
			 * status = amazonpayLink.isDisplayed();
			 * 
			 * 
			 * if (!status == status) { amazonpayLink.click();
			 * System.out.println("TestCase is fail"); } else if (status == status) {
			 * amazonpayLink.click(); System.out.println("TestCase is Pass"); } else {
			 * System.out.println("not acepeting"); }
			 * 
			 * if(status) { amazonpayLink.click(); System.out.println("case is pass"); }else
			 * { System.out.println("case is Failled"); } }
			 */
		}
	}

}
