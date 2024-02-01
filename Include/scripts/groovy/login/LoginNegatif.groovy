package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

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

class LoginNegatif {
	///InvalidEmail///
	@When("User mengisi dengan Email {string} dan password {string} pada halaman Login Facebook")
	def inputFieldd(String Email, String Password){

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

	@Then("User Gagal Login ke HomePage Facebook")
	def failedRejected() {

		'Verify Element Not Present'
		WebUI.verifyElementNotPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[text()='Selamat datang di Facebook, Markonah']"), 5)

		'Take Screenshot'
		WebUI.takeScreenshot()

	}

}