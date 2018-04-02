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

WebUI.callTestCase(findTestCase('BEP/Create_Approve_Reject/Create_BEP_NoOutput'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.RD, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RDapprove'()

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.RL, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLRequestMeeting'()

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.CLINIC, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.ScheduleMeeting'()

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.RL, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

GlobalVariable.Meeting = true

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLapprove'()

not_run: WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)

not_run: WebUI.click(findTestObject('Generic/CLOSE_WORK_OBJECT'))

not_run: CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

GlobalVariable.Meeting = false

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RequestCancelMeeting'()

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.CLINIC, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.Cancelmeeting'()

CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

GlobalVariable.Meeting = false

WebUI.callTestCase(findTestCase('BEP/Create_Approve_Reject/All_Approval_Reject'), [:], FailureHandling.STOP_ON_FAILURE)

