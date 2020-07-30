package com.floweraura.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.SkipException;

public class DynamicImages extends BasePage {
	public DynamicImages(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[@class=\"clr-3b3b muli-font\"]/span")
	private WebElement HeadTextWithSpanTag;
	
	//-------for h3 tag inside text-------//
	@FindBy(xpath = "//h3/p/span")
	WebElement subtextOf_SecondImage;

	@FindBy(xpath = "//h3/p[text()=\"Aapki kalpana aur hamara sahara.\"]")
	WebElement SubTextOf_ThirdImage;

	@FindBy(xpath = "//h3/p[text()=\"For a Better Tomorrow !!\"]")
	WebElement SubTextOf_FourthImage;

	@FindBy(xpath = "//h3/p[text()=\"A chance to get more than you hope for…\"]")
	WebElement SubTextOf_FifthImage;

	@FindBy(xpath = "//h3/p[text()=\"Life comes with no guarantees, we do..\"]")
	WebElement SubTextOf_SixthImage;

	@FindBy(xpath = "//h3/p[text()=\"Suraksha ke saath bachat…\"]")
	WebElement SubTextOf_SeventhImage;

	@FindBy(xpath = "//h3/p[text()=\"Securing each other…\"]")
	WebElement SubTextOf_TenthImage;

	public void allImagesHeadText(WebDriver driver) {

		List<WebElement> headtagtext = driver.findElements(By.xpath("//h1[@class=\"clr-3b3b muli-font\"]"));
		List<String> values = new ArrayList<String>();
		values.add(0, "Safety Of Our Customers Is Our Top Most Priority");
		values.add(1, null);
		values.add(2, "Shriram Life Golden Premier Saver Plan");
		values.add(3, "Shriram Life Assured Advantage Plus");
		values.add(4, "Shriram Life Growth Plus");
		values.add(5, "Shriram Life Online Term Plan");
		values.add(6, "Shriram Life Assured Income Plus");
		values.add(7, "Shriram Life Genius Assured Benefit Plan");
		values.add(8, "Shriram Life Comprehensive Cancer Care");
		values.add(9, "Shriram Life My Spouse Term Pla");
		for (int i = 0; i < headtagtext.size(); i++) {          // headtagtext size is =10
			String alltext = headtagtext.get(i).getAttribute("innerHTML");
			if (i == 1) {
				/*
				 * StringBuffer bf = new StringBuffer(alltext); StringBuffer buffer1 =
				 * bf.delete(0, 24); StringBuffer buffer = buffer1.delete(30, 37); String wing =
				 * buffer.toString(); System.out.println(wing); values.set(1, wing); alltext =
				 * wing;
				 */
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String lathkore = HeadTextWithSpanTag.getAttribute("innerHTML");
				// String lathkore =HeadTextWithSpanTag.getText();
				alltext = lathkore;
				values.set(1, lathkore);
			}
			String expectedvaliues = values.get(i);
			Assert.assertEquals(alltext, expectedvaliues);
			log.error("lkkofof--->" + expectedvaliues);
		}
	}

	public void eachImageUlListText(WebDriver driver) {
		String[][] kkkkoo = new String[12][];
		kkkkoo[1] = new String[3];
		kkkkoo[1][1] = "Owing to various advisories / directions by Government authorities, "
				+ "Shriram Life offices will remain closed till the situation improves";
		kkkkoo[1][2] = "Access our 24* 7 Digital Servicing Options from the convenience of your home";

		kkkkoo[2] = new String[4];
		kkkkoo[2][1] = "Life Insurance cover till Age 75";
		kkkkoo[2][2] = "Guaranteed Monthly Income till Age 75";
		kkkkoo[2][3] = "Flexibility to change Premium Payment Term";

		kkkkoo[3] = new String[4];
		kkkkoo[3][1] = "Life cover for chosen policy term";
		kkkkoo[3][2] = "Assured Benefit on maturity along with bonus*";
		kkkkoo[3][3] = "Get another assured sum assured through extended cover benefits*";

		kkkkoo[4] = new String[4];
		kkkkoo[4][1] = null;

		kkkkoo[5] = new String[4];
		kkkkoo[5][1] = "Pay premium only once";
		kkkkoo[5][2] = "Life Insurance for 10 years";
		kkkkoo[5][3] = "3 Maturity benefit options";

		kkkkoo[6] = new String[4];
		kkkkoo[6][1] = "Multiple fund options and flexibility to switch between funds";
		kkkkoo[6][2] = "Two death benefit option";
		kkkkoo[6][3] = "Premium payment options – Single, Regular and Limited";

		kkkkoo[7] = new String[4];
		kkkkoo[7][1] = "Enhanced protection using the 3 options for comprehensive cover";
		kkkkoo[7][2] = "Provides life cover up to 75 years";
		kkkkoo[7][3] = "Lower premium rates for women";

		kkkkoo[8] = new String[4];
		kkkkoo[8][1] = "Pay premium for only 5 years";
		kkkkoo[8][2] = "Life cover for 10 years";
		kkkkoo[8][3] = "Additional protection through Riders";

		kkkkoo[9] = new String[4];
		kkkkoo[9][1] = "Guaranteed benefits";
		kkkkoo[9][2] = "Flexible premium payment modes";
		kkkkoo[9][3] = "Auto Cover";

		kkkkoo[10] = new String[4];
		kkkkoo[10][1] = "Flexible premium payment modes";
		kkkkoo[10][2] = "Monthly income option";
		kkkkoo[10][3] = "Premium waiver after early detection";

		kkkkoo[11] = new String[4];
		kkkkoo[11][1] = "Affordable Premiums for a cover of ₹ 1 crore (T&C Apply)";
		kkkkoo[11][2] = "Enhanced protection with Optional Coverage";
		kkkkoo[11][3] = "Lower premium rates for women";
		   
		
		 int i;
		for ( i = 1; i <= 11; i++) {
			String before = "//div[@class=\"col-xs-12 col-md-6 blue-list-bg pl-0 mt-2\"]"
					+ "//preceding::ul[@class=\"dropdown-menu dropdown_menu_2\"]//following::ul[";
			String after = "]/li";
			String total = before + i + after;
			List<WebElement> with_li_items = driver.findElements(By.xpath(total));
			// System.out.println(with_li_items.size());
			for (int j = 1; j <= with_li_items.size(); j++) {
				// System.out.println(with_li_items.size());
				WebElement totalcare = driver.findElement(By.xpath(total + "[" + j + "]"));
				String cockko = totalcare.getAttribute("innerHTML");
				if (i != 4) {
					if (i == 11 && j == 1) {
						String taook = totalcare.getAttribute("innerHTML");
						StringBuffer delete_em_tages = new StringBuffer(taook);
						// System.out.println(delete_em_tages.length());
						StringBuffer kokilla = delete_em_tages.delete(45, 49);
						StringBuffer remaing = kokilla.delete(60, 65);
						StringBuffer exterawords = remaing.delete(48, 52);
						String conver = exterawords.toString();
						cockko = conver;
					}
					String jkj = kkkkoo[i][j];
					Assert.assertEquals(cockko, jkj);
					System.out.println(cockko);
				} else {
					String kfj = totalcare.getAttribute("innerHTML");
					StringBuffer bb = new StringBuffer(kfj);
					StringBuffer anotherone = bb.delete(0, bb.length());
					String extraone = anotherone.toString();
					cockko = extraone;
				}
			}
			
			System.out.println();
			throw new SkipException("Skip test case");
		}
		
	}
	
	public void allImage_SubText(WebDriver driver) {
		List<String> HeadTextBelow = new ArrayList<String>();
		HeadTextBelow.add(0, "Security. Stability. Control… Sab aapki mutthi me!");
		HeadTextBelow.add(1, "Aapki kalpana aur hamara sahara.");
		HeadTextBelow.add(2, "For a Better Tomorrow !!");
		HeadTextBelow.add(3, "A chance to get more than you hope for…");
		HeadTextBelow.add(4, "Life comes with no guarantees, we do..");
		HeadTextBelow.add(5, "Suraksha ke saath bachat…");
		HeadTextBelow.add(6, "You give them wings, we help them fly");
		HeadTextBelow.add(7, "You look after your loved ones, we’ll do the rest!");
		HeadTextBelow.add(8, "Securing each other…");
		List<WebElement> subtextss = driver.findElements(By.xpath("//h3[@class=\"clr-blue-dark mt-0 muli-font\"]"));
		subtextss.remove(0);
		subtextss.remove(6);
		subtextss.remove(7);

		for (int i = 0; i < subtextss.size(); i++) {
			//System.out.println(subtextss.size());
			String h3_texts = subtextss.get(i).getAttribute("innerHTML");
		
			switch (i) {
			case 0:
				String withspantag = subtextOf_SecondImage.getAttribute("innerHTML");
				h3_texts = withspantag;
				break;
				
			case 1:
				String withPtag = SubTextOf_ThirdImage.getAttribute("innerHTML");
				h3_texts = withPtag;
				break;
			case 2:
				String withPtag_Fourth = SubTextOf_FourthImage.getAttribute("innerHTML");
				h3_texts = withPtag_Fourth;
				break;
			case 3:
				String withPtag_Fifth = SubTextOf_FifthImage.getAttribute("innerHTML");
				h3_texts = withPtag_Fifth;
				break;
			case 4:
				String withPtag_Sixth = SubTextOf_SixthImage.getAttribute("innerHTML");
				h3_texts = withPtag_Sixth;
				break;
			case 5:
				String withPtag_Seventh = SubTextOf_SeventhImage.getAttribute("innerHTML");
				h3_texts = withPtag_Seventh;
				break;
			case 8:
				String withPtag_Ten = SubTextOf_TenthImage.getAttribute("innerHTML");
				h3_texts = withPtag_Ten;
				break;
			}	
			
			String expected = HeadTextBelow.get(i);
			Assert.assertEquals(h3_texts, expected);
			System.out.println(h3_texts);
			
		}
	}

	public void getAllImage_KnowMore_Link(WebDriver driver) {
		String [] knoemore_link= {"KNOW MORE","KNOW MORE","KNOW MORE","KNOW MORE","KNOW MORE",
				"KNOW MORE","KNOW MORE","KNOW MORE","KNOW MORE","KNOW MORE"};
		List<WebElement> each_KnowMore_Link = driver.findElements(By.xpath("//a[text()=\"KNOW MORE \"]"));
		for (int k = 0; k < each_KnowMore_Link.size(); k++) {
				String eachkowmorelink = each_KnowMore_Link.get(k).getAttribute("innerHTML");
				StringBuffer buffy = new StringBuffer(eachkowmorelink);
				StringBuffer cuttunwantedlength = buffy.delete(9, 52);
				String cinversation = cuttunwantedlength.toString();	
				eachkowmorelink = cinversation;
				String actual=knoemore_link[k];
				Assert.assertEquals(actual, eachkowmorelink);
				log.info(eachkowmorelink);
		}	
	}
}
