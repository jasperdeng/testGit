package student;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.awt.Label;
import java.lang.invoke.LambdaConversionException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.swing.MenuElement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test.None;
import org.openqa.jetty.html.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.CheckedFuture;
import com.thoughtworks.selenium.Wait;

public class student {

	private AppiumDriver driver;
	private FluentWait<WebDriver> wait;

	// WebDriverWait wait = new WebDriverWait(driver, 10);

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities
				.setCapability(
						"app",
						"C:\\Users\\Dell\\Downloads\\100edututor-3.8.0-3526-student-official.apk");
		// desiredCapabilities.setCapability("app",
		// "C:\\Users\\Dell\\Downloads\\100edututor-2.5.0-SNAPSHOT-3424-teacher-official.apk");
		desiredCapabilities.setCapability("appActivity",
				"com.yy.android.tutor.student.views.LoginDispatchActivity");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("deviceName", "emulator-5554");

        desiredCapabilities.setCapability("automationName", "uiautomator2");

		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		

	}

	@Test(priority = 0)
	// ��¼������
	public void login() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/edit");
		if (el1.getAttribute("text") == "14718094269") {
			driver.findElementById(
					"com.yy.android.tutor.student:id/next_button").click();
		} else {
			el1.sendKeys("14718094269");
		}
		MobileElement el2 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/next_button");// ��һ��
		el2.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MobileElement el3 = (MobileElement) driver
				.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		el3.click();
		MobileElement el4 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/dialog_right_button");// ѡ������
		el4.click();
		MobileElement el5 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/student_login_cb_agreement");
		if (el5.getAttribute("checked").equals("true")) {
			driver.findElementById(
					"com.yy.android.tutor.student:id/login_button").click();
		} else {
			el5.click();
			driver.findElementById(
					"com.yy.android.tutor.student:id/login_button").click();// ��¼
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MobileElement el6 = (MobileElement) driver
				.findElementByXPath("//android.view.View[@content-desc=\"�γ̱�\"]");
		assertEquals("�γ̱�", el6.getAttribute("name"));

	}

	@Test(priority = 1)
	// Ԥϰ������
	public void prepare() throws InterruptedException {
		// �A���n��
		if (byElementIsExist(By
				.xpath("//android.view.View[@content-desc='Ԥϰ']")) == true) {
			driver.findElementByAccessibilityId("Ԥϰ").click();
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("�뿪").click();
		} else {
			System.out.println("undo prepare");
		}
	}

	@Test(priority = 3)
	// ��ϰ��������
	public void review() throws InterruptedException {
		// ��ϰ
		driver.findElementById("com.yy.android.tutor.student:id/review_img")
				.click();
		driver.findElementByXPath(
				"//android.webkit.WebView[@content-desc=\"100����\"]/android.view.View[3]")
				.click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout")
				.click();
		driver.findElementById("com.yy.android.tutor.student:id/back_button")
				.click();
		// �鿴����
		driver.findElementByXPath(
				"(//android.view.View[@content-desc=\"�鿴����\"])[2]").click();
		driver.findElementByAccessibilityId("�Z").click();
	}

	@Test(priority = 2)
	// ��ҵ��������
	public void homework() throws InterruptedException {
		// int x = 0;
		driver.findElementById(
				"com.yy.android.tutor.student:id/rl_tab_course_hour").click();// ��ҵ
		// �ύ��ҵ
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]")
				.click();
		driver.findElementById("com.yy.android.tutor.student:id/photo_select")
				.click();
		driver.findElementById("com.android.gallery:id/grid").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/confirmPictureBtn").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_right_text").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_left_text").click();
		// �޸���ҵ
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView")
				.click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.View/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]")
				.click();
		driver.findElementById("com.yy.android.tutor.student:id/modify")
				.click();
		for (int i = 1; byElementIsExist(By
				.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["
						+ i + "]/android.widget.ImageView")) == true; i++) {
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["
							+ i + "]/android.widget.ImageView").click();

		}
		driver.findElementById("com.yy.android.tutor.student:id/btn_album")
				.click();
		driver.findElementById("com.android.gallery:id/grid").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/confirmPictureBtn").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_right_text").click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  MobileElement el8 = (MobileElement) wait .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yy.android.tutor.student:id/text_loading")));
		assertEquals("�ύ�ɹ�", el8.getAttribute("name"));
		// ����
		driver.findElementById("com.yy.android.tutor.student:id/modify")
				.click();
		if (byElementIsExist(By.id("com.yy.android.tutor.student:id/iv_delete")) == true) {
			driver.findElementById("com.yy.android.tutor.student:id/iv_delete")
					.click();// ɾ��ͼƬ
		} else {
			for (int j = 0; byElementIsExist(By
					.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["
							+ j + "]/android.widget.ImageView[2]")) == true; j++) {
				MobileElement el = (MobileElement) driver
						.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["
								+ j + "]/android.widget.ImageView[2]");
				el.click();
			}
		}
		driver.findElementById(
				"com.yy.android.tutor.student:id/dialog_right_button").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_right_text").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_left_text").click();
	}

	@Test(priority = 4)
	// �Ͽβ�������
	public void begin() throws InterruptedException {
		driver.findElementById(
				"com.yy.android.tutor.student:id/classroom_imgview").click();
		driver.findElementById("com.yy.android.tutor.student:id/ok_button")
				.click();

		// test
		driver.findElementById(
				"com.yy.android.tutor.student:id/yellow_edit_button").click();// ����
		(new TouchAction(driver)).press(373, 108).moveTo(601, 194).release()
				.perform();
		(new TouchAction(driver)).press(608, 131).moveTo(382, 284).release()
				.perform();
		MobileElement el8 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/erase_paints_button");
		el8.click();// ��Ƥ��
		(new TouchAction(driver)).press(610, 45).moveTo(598, 191).release()
				.perform();

		MobileElement el13 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/add_more_btn");// +
		el13.click();
		driver.findElementById("com.yy.android.tutor.student:id/picture_button")
				.click();// ���ͼƬ
		driver.findElementById("com.android.gallery:id/grid").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/confirmPictureBtn").click();
		el13.click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/new_page_button").click();// �½��װ�
		el13.click();
		driver.findElementById("com.yy.android.tutor.student:id/camera_button")
				.click();// ����
		driver.findElementById("com.yy.android.tutor.student:id/shutterBtn")
				.click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/confirmPictureBtn").click();
		driver.findElementById("com.yy.android.tutor.student:id/add_tag")
				.click();// ����ص�
		if (byElementIsExist(By
				.id("com.yy.android.tutor.student:id/finish_button")) == true) {
			driver.findElementById(
					"com.yy.android.tutor.student:id/finish_button").click();// �˳�����
			driver.findElementById(
					"com.yy.android.tutor.student:id/dialog_right_button")
					.click();
		} else {
			Thread.sleep(5000);
		}
	}

	@Test(priority = 5)
	// (dependsOnMethods = { "login" })
	// �ҵĲ�������
	public void me() throws InterruptedException {
		driver.findElementById("com.yy.android.tutor.student:id/me_img")
				.click();// �ҵ�
		// �޸�ͷ��
		driver.findElementByAccessibilityId("�v").click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/setting_item_avatar").click();
		// driver.findElementByAccessibilityId("profile-defaults.23031ea").click();
		driver.findElementById("com.yy.android.tutor.student:id/recommand")
				.click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.GridView/android.widget.ImageView[7]")
				.click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_left_text").click();

		// �ϴ����Ȿ
		driver.findElementByAccessibilityId("���Ȿ").click();
		MobileElement el9 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/img_upload_add");
		el9.click();
		MobileElement el10 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/btn_album");
		el10.click();
		MobileElement el11 = (MobileElement) driver
				.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[6]/android.widget.RelativeLayout/android.widget.ImageView");
		el11.click();
		MobileElement el12 = (MobileElement) driver
				.findElementById("com.yy.android.tutor.student:id/finish");
		el12.click();
		driver.findElementById(
				"com.yy.android.tutor.student:id/title_left_text").click();

		// �˳���¼
		MobileElement el7 = (MobileElement) driver
				.findElementByAccessibilityId("A8EHkCnCVNqcAAAAAElFTkSuQmCC");
		el7.click();
		driver.findElementById("com.yy.android.tutor.student:id/logout_button")
				.click();
	}

	private boolean byElementIsExist(By id) {
		try {
			driver.findElement(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
