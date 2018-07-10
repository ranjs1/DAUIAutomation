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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.openBrowser(findTestData('URL').getValue(1, 1))

WebUI.maximizeWindow()

'Login Delivery Automation portal as Project Office User'
CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 3), findTestData(
        'Role-UserName-Password').getValue(3, 3))

WebUI.delay(2)

'Create  a Priage Request'
CustomKeywords.'da.common.methods.CommonActionsInDA.createPriage'()

String woid = WebUI.getText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WOID'))

WebUI.comment(woid)

WebUI.delay(2)

/*Use test data Projector Billable Engagements */
'As Project Office user enter the details for the Priage - Engagement name etc.'
CustomKeywords.'da.priage.priageCommonActions.enterPriageEngagamentDetails'(findTestData('Projector Billable Engagements').getValue(
        1, 1), findTestData('Projector Billable Engagements').getValue(2, 1), findTestData('Projector Billable Engagements').getValue(
        3, 1))

WebUI.delay(2)

'As Practice Leader complete the questionnairre'
CustomKeywords.'da.priage.priageCommonActions.completePriageQuestionnaire'(woid)

'Decision if Its a priage or Not'
CustomKeywords.'da.priage.priageCommonActions.priageDecisionProcess'(woid)

'Scehdule Kickoff meeting'
CustomKeywords.'da.priage.priageCommonActions.scheduleKickOff'(woid)

'Conduct KickOff Meeting'
CustomKeywords.'da.priage.priageCommonActions.conDuctKickOffMeeting'(woid)

