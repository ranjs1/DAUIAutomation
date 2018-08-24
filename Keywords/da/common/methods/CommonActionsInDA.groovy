package da.common.methods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.Keys as Keys

import java.util.concurrent.ThreadLocalRandom

public class CommonActionsInDA {
	@Keyword
	def static loginDA(String userName, String passWord) {
		WebUI.setText(findTestObject('CommonDAObjectRepository/Page_Pega 7/input_UserIdentifier'), userName)

		WebUI.setText(findTestObject('CommonDAObjectRepository/Page_Pega 7/input_Password'), passWord)

		WebUI.click(findTestObject('CommonDAObjectRepository/Page_Pega 7/button_pyActivityCode-Security'))

		WebUI.delay(10)
	}

	@Keyword
	def static createPriage() {
		WebUI.delay(2)
		WebUI.click(findTestObject('CommonDAObjectRepository/Page_Pega 7/New'))
		WebUI.delay(2)
		WebUI.click(findTestObject('CommonDAObjectRepository/Page_Pega 7/PriageLink'))
		WebUI.delay(2)
	}

	@Keyword
	def static createInvestment() {
		WebUI.delay(2)
		WebUI.click(findTestObject('CommonDAObjectRepository/Page_Pega 7/New'))
		WebUI.delay(2)
		WebUI.click(findTestObject('CommonDAObjectRepository/Page_Pega 7/InvestmentLink'))
		WebUI.delay(2)
	}

	@Keyword
	def static logOff() {
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/UsernameLogInOff'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/Logout'))
		WebUI.delay(2)
	}

	@Keyword
	def static searchWO(String wo) {
		WebUI.setText(findTestObject('CommonDAObjectRepository/Page_Pega 7/luceneSearch'), wo)
		WebUI.sendKeys(findTestObject('CommonDAObjectRepository/Page_Pega 7/luceneSearch'), Keys.chord(Keys.ENTER))
	}

	@Keyword
	def static randomEngagementNameGenerator() {
		Date today = new Date()
		String todaysDate = today.format('MMddyy-hhmm')
		String engagementName = 'auto_eng ' + todaysDate
		return engagementName
	}
}
