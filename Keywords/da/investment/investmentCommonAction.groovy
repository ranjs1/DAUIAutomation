package da.investment



import da.common.methods.*

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
	def createNewInvestment(String org, String acc, String eng, String profitCentre, String ledBy, String engDescription, String filePath) {
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/CreateNewInvestment'))
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))

		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/ImportBSWForInvestment'))
		WebUI.uploadFile(findTestObject('InvestmentObjectRepository/filePath'),filePath)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/importSubmitButton'))
		WebUI.delay(20)
		//WebUI.waitForElementVisible(findTestObject('Object Repository/InvestmentObjectRepository/Org_Name'), 50)
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
<<<<<<< HEAD
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/profitCentre'), findTestData('NewEngagements').getValue(4, 1))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/engDescription'), findTestData('NewEngagements').getValue(6, 1))
		WebUI.delay(2)
=======

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/profitCentre'), findTestData('NewEngagements').getValue(4, 1))
		WebUI.delay(2)
>>>>>>> nipin_updatingglobalvariable

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/ledBy'), findTestData('NewEngagements').getValue(5, 1))
		WebUI.delay(2)

<<<<<<< HEAD
		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/EL'), findTestData('NewEngagements').getValue(7, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/PL'), findTestData('NewEngagements').getValue(8, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/RL'), findTestData('NewEngagements').getValue(9, 1))
=======
		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/engDescription'), findTestData('NewEngagements').getValue(6, 1))
>>>>>>> nipin_updatingglobalvariable
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/RD'), findTestData('NewEngagements').getValue(10, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/Work Location'), findTestData('NewEngagements').getValue(11, 1))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/Platform'), findTestData('NewEngagements').getValue(12, 1))
		WebUI.delay(4)

		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/Platform Version'), findTestData('NewEngagements').getValue(13, 1))
		WebUI.delay(4)

		WebUI.click(findTestObject('InvestmentObjectRepository/IsPlatformOnlyYES'))
		WebUI.delay(2)

		WebUI.click(findTestObject('InvestmentObjectRepository/Next Button'))
		WebUI.delay(2)

	}
<<<<<<< HEAD

	@Keyword
	def createDateOnlyInvestment(String woid) {
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/createDateOnlyExtension'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/extendableInvestmentWOFirstRow'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))
		WebUI.delay(6)
		WebUI.sendKeys(findTestObject('InvestmentObjectRepository/RL'), findTestData('NewEngagements').getValue(9, 1))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/plannedStartDate'), '3/1/2018')
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/plannedEndDate'), '3/14/2018')
		WebUI.click(findTestObject('InvestmentObjectRepository/Next Button'))
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/InvestmentObjectRepository/extendMessage'), 'Please explain why dates have changed.')
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/dateOnlyExtendPlComments'), 'PL COmments for Investment')
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Finish Button'))
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/ApprovalComments'), 'Extension Comments')
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'RESOLVED-APPROVED')
		WebUI.verifyElementClickable(findTestObject('InvestmentObjectRepository/Projector Engagement'))
	}


	@Keyword
	def enterJustificationAndBackGround() {
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/background'), 'PL Enters Background')
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/justification'), 'PL Enters Justification')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Next Button'))
		WebUI.delay(20)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Next Button'))
		WebUI.delay(20)
		WebUI.setText(findTestObject('Object Repository/InvestmentObjectRepository/PL Comment'), 'PL Comment')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Finish Button'))
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'PENDING-OPSAPPROVAL')
	}


	@Keyword
	def gsopsApproval(String woid) {

		CommonActionsInDA.logOff()

		WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))

		CommonActionsInDA.loginDA(findTestData('Role-UserName-Password').getValue(2, 4), findTestData(
				'Role-UserName-Password').getValue(3, 3))

		CommonActionsInDA.searchWO(woid)
		WebUI.delay(4)
		WebUI.waitForElementVisible(findTestObject('CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'), 0)

		WebUI.verifyElementClickable(findTestObject('CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'Gsops Comments')

		WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/category'), findTestData('NewEngagements').getValue(15, 1))
		WebUI.delay(6)

		WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/Code'), findTestData('NewEngagements').getValue(16, 1))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
		WebUI.delay(4)
	}

	@Keyword
	def rdApproval(String woid) {
		CommonActionsInDA.logOff()
		WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
		CommonActionsInDA.loginDA(findTestData('Role-UserName-Password').getValue(2, 5), findTestData(
				'Role-UserName-Password').getValue(3, 3))
		CommonActionsInDA.searchWO(woid)

		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'PENDING-RDAPPROVAL')
		WebUI.verifyElementClickable(findTestObject('CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'RD Comments')
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
		WebUI.delay(4)
	}

	@Keyword
	def rlApproval(String woid) {
		CommonActionsInDA.logOff()
		WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
		CommonActionsInDA.loginDA(findTestData('Role-UserName-Password').getValue(2, 6), findTestData(
				'Role-UserName-Password').getValue(3, 3))
		CommonActionsInDA.searchWO(woid)
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'PENDING-RLAPPROVAL')
		WebUI.verifyElementClickable(findTestObject('CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'RL Comments')
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
		WebUI.delay(4)
	}

	@Keyword
	def svpApproval(String woid) {

		CommonActionsInDA.logOff()
		WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
		CommonActionsInDA.loginDA(findTestData('Role-UserName-Password').getValue(2, 7), findTestData(
				'Role-UserName-Password').getValue(3, 3))
		CommonActionsInDA.searchWO(woid)
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'PENDING-SVPAPPROVAL')
		WebUI.verifyElementClickable(findTestObject('CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'SVP Comments')
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
		WebUI.delay(10)
	}

	@Keyword
	def verifyProjectInfoOnInv(String woid) {
		CommonActionsInDA.logOff()
		WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
		CommonActionsInDA.loginDA(findTestData('Role-UserName-Password').getValue(2, 4), findTestData(
				'Role-UserName-Password').getValue(3, 3))
		CommonActionsInDA.searchWO(woid)
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WO Status'), 'RESOLVED-APPROVED')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Investment Information Tab'))
		WebUI.delay(2)
		WebUI.verifyElementClickable(findTestObject('InvestmentObjectRepository/Projector Engagement'))
		WebUI.comment(woid)
	}



	@Keyword
	def verifyDateOnlyExtendInv(String woid) {
	}
=======
>>>>>>> nipin_updatingglobalvariable
}
