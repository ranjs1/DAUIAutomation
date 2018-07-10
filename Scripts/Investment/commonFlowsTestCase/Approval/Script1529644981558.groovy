import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


while (status != 'Resolved-Approved') {
	if (status == 'Pending-OPSApproval') {
	CustomKeywords.'da.common.methods.CommonActionsInDA.logOff'()
	WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
	CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 4), findTestData(
	'Role-UserName-Password').getValue(3, 3))
	CustomKeywords.'da.common.methods.CommonActionsInDA.searchWO'(x)
	
	WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'Gsops Comments')
	
	WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/category'), findTestData('NewEngagements').getValue(15, 1))
	WebUI.delay(6)
	
	WebUI.sendKeys(findTestObject('Object Repository/InvestmentObjectRepository/Code'), findTestData('NewEngagements').getValue(16, 1))
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
	
	}

	
	else if(status == 'Pending-RDApproval') {
	CustomKeywords.'da.common.methods.CommonActionsInDA.logOff'()
	WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
	CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 5), findTestData(
	'Role-UserName-Password').getValue(3, 3))
	CustomKeywords.'da.common.methods.CommonActionsInDA.searchWO'(x)
	
	WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'RD Comments')
	WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
	
    }
	
	else if(status == 'Pending-RLApproval') {
	CustomKeywords.'da.common.methods.CommonActionsInDA.logOff'()
	WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
	CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 6), findTestData(
	'Role-UserName-Password').getValue(3, 3))
	CustomKeywords.'da.common.methods.CommonActionsInDA.searchWO'(x)
	WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'RL Comments')
	WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
	
	}
	
	else if(status == 'Pending-SVPApproval') {
	CustomKeywords.'da.common.methods.CommonActionsInDA.logOff'()
	WebUI.navigateToUrl(findTestData('URL').getValue(1, 1))
	CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 7), findTestData(
	'Role-UserName-Password').getValue(3, 3))
	CustomKeywords.'da.common.methods.CommonActionsInDA.searchWO'(x)
	WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('InvestmentObjectRepository/ApprovalComments'), 'SVP Comments')
	WebUI.click(findTestObject('Object Repository/InvestmentObjectRepository/Approve Button'))
	
	}
	
	else if(status == 'RESOLVED-APPROVED') {
		break
	}
	status = WebUI.getText(findTestObject('InvestmentObjectRepository/status'))
}
