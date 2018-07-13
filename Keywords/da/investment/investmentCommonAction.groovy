package da.investment

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

public class investmentCommonAction {

	@Keyword
	def createNewInvestment(String org, String acc, String eng, String profitCentre, String ledBy, String engDescription) {
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/CreateNewInvestment'))
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/ImportBSWForInvestment'))
		WebUI.uploadFile(findTestObject('InvestmentObjectRepository/filePath'), 'C:\\Users\\ranjs1\\git\\DAUIAutomation\\Data Files\\BSW\\Investment\\INV-BSW_BSW PRJ v9.xlsm')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/importSubmitButton'))
		WebUI.delay(10)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/Org_Name'), org)
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/Org_Name'), Keys.chord(Keys.TAB))
		WebUI.delay(4)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/Acc_Name'), acc)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/Acc_Name'), Keys.chord(Keys.TAB))
		WebUI.delay(4)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/Eng_Name'), eng)
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/Eng_Name'), Keys.chord(Keys.TAB))

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/profitCentre'), findTestData('NewEngagements').getValue(4, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/ledBy'), findTestData('NewEngagements').getValue(5, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/engDescription'), findTestData('NewEngagements').getValue(6, 1))
		WebUI.delay(2)
	}
}
