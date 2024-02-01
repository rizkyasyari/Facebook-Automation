package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LoginPositif {

	def path = RunConfiguration.getProjectDir().replace('/', '\\')
	def excel = ExcelKeywords.getExcelSheetByName('Data Files/' + GlobalVariable.Data, 'Login')

	@Given("User Menuju Url Facebook")
	def MenujuUrlFacebook() {

		'Setup Driver Browser'
		RunConfiguration.setWebDriverPreferencesProperty('args', ['window-size=1920,1080'])

		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_setting_values.notifications", 2);
		RunConfiguration.setWebDriverPreferencesProperty('prefs', chromePrefs);

		'Opening Browser'
		WebUI.openBrowser(GlobalVariable.Url)

		'Deleting Cookies'
		WebUI.deleteAllCookies()
	}

	@When("User Mengisi Email dan Password")
	def MengisiEmaildanPassword() {

		'Get Value Email from Excel'
		String Email = ExcelKeywords.getCellValueByAddress(excel,'A2')

		'Get Value Password from Excel'
		String Password = ExcelKeywords.getCellValueByAddress(excel,'B2')


		'Input Email'
		WebUI.sendKeys(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id='email']"), Email)

		'Input Password'
		WebUI.sendKeys(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@type='password']"), Password)

		'Delay'
		WebUI.delay(3)

		'Take Screenshot'
		WebUI.takeScreenshot()

		'Click Button Login'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@name='login']"))
	}

	@Then("User Berhasil Login ke Facebook")
	def BerhasilLoginkeFacebook() {

		'Verify Element'
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[text()='Selamat datang di Facebook, Markonah']"), 5)

		'Take Screenshot'
		WebUI.takeFullPageScreenshot()
	}
}
