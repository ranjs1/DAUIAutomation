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

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.CLINIC)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

not_run: WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)

not_run: String TestDataFile = System.getProperty('user.dir') + location

CustomKeywords.'com.helper.commonfunct.commonutilities.scheduleMeeting'()

not_run: println(TestDataFile)

not_run: WebUI.delay(5)

not_run: String CRID = WebUI.getText(findTestObject('ECR/Generic/WO/CRID'))

not_run: println(CRID)

not_run: WebUI.delay(5)

not_run: WebUI.click(findTestObject('ECR/Generic/WO/EngTab'))

not_run: WebUI.delay(2)

not_run: String ENGID = WebUI.getText(findTestObject('ECR/Generic/WO/ENGID'))

not_run: WebUI.delay(2)

not_run: println(ENGID)

not_run: String PROJID = WebUI.getText(findTestObject('ECR/Generic/WO/PROJID'))

not_run: WebUI.delay(2)

not_run: println(PROJID)

not_run: CustomKeywords.'com.helper.commonfunct.commonutilities.WriteWO'('1', 'C:\\DAUIAutomation\\Data Files\\ECR\\TestDataECR.xlsx', 
    1, '')

not_run: WebUI.verifyAlertPresent(0)

