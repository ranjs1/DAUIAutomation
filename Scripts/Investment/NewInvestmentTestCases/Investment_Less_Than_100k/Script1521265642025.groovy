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

WebUI.openBrowser(findTestData('URL').getValue(1, 1))

WebUI.maximizeWindow()

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(findTestData('Role-UserName-Password').getValue(2, 2), findTestData(
        'Role-UserName-Password').getValue(3, 2), '')

WebUI.delay(2)

CustomKeywords.'da.common.methods.CommonActionsInDA.createInvestment'()

CustomKeywords.'da.investment.investmentCommonAction.createNewInvestment'(findTestData('NewEngagements').getValue(1, 1), 
    findTestData('NewEngagements').getValue(2, 1), findTestData('NewEngagements').getValue(3, 1), findTestData('NewEngagements').getValue(
        4, 1), findTestData('NewEngagements').getValue(5, 1), findTestData('NewEngagements').getValue(6, 1))

