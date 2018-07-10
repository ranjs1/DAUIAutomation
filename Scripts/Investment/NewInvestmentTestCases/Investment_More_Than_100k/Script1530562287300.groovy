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

'Login as Practice Leader'
CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 2), findTestData(
        'Role-UserName-Password').getValue(3, 2))

WebUI.delay(2)

String engagementName = CustomKeywords.'da.common.methods.CommonActionsInDA.randomEngagementNameGenerator'()

WebUI.comment(engagementName)

String filePath = 'C:\\Users\\ranjs1\\git\\DAUIAutomation\\Data Files\\BSW\\Investment\\INV-BSW_BSW PRJ v9_MoreThan100K.xlsm'

'Go to ----> (+) -- > Investment'
CustomKeywords.'da.common.methods.CommonActionsInDA.createInvestment'()

'Select \'Create New Investment Option\' and Proceed by creating the investment with the values as mentioned in the BSW file and the test Data \'New Engagement\''
CustomKeywords.'da.investment.investmentCommonAction.createNewInvestment'(findTestData('NewEngagements').getValue(1, 1), 
    findTestData('NewEngagements').getValue(2, 1), engagementName, findTestData('NewEngagements').getValue(4, 1), findTestData(
        'NewEngagements').getValue(5, 1), findTestData('NewEngagements').getValue(6, 1), filePath)

'Enter Background Verification and Justification'
CustomKeywords.'da.investment.investmentCommonAction.enterJustificationAndBackGround'()

String woid = WebUI.getText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WOID'))

WebUI.comment(woid)

'Approve Investment Request as GSOPS'
CustomKeywords.'da.investment.investmentCommonAction.gsopsApproval'(woid)

'Approve Investment Request as Regional Director'
CustomKeywords.'da.investment.investmentCommonAction.rdApproval'(woid)

'Approve Investment Request as Regional Leader'
CustomKeywords.'da.investment.investmentCommonAction.rlApproval'(woid)

'Approve Investment Request as Approve Investment Request as SVP'
CustomKeywords.'da.investment.investmentCommonAction.svpApproval'(woid)

'Investment Work Object and Details.\r\nVerification to see if it is properly linked to Projector'
CustomKeywords.'da.investment.investmentCommonAction.verifyProjectInfoOnInv'(woid)

return woid

WebUI.closeBrowser()
