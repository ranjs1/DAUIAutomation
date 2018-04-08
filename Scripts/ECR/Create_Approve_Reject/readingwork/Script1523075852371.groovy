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
import com.helper.commonfunct.commonutilities as commonutilities

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.OPS, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.OPS, GlobalVariable.pwd)

GlobalVariable.WOID = WOID

not_run: WebUI.delay(5)

not_run: WebUI.setText(findTestObject('Object Repository/EngInfo/search'), GlobalVariable.WOID)

not_run: WebUI.delay(3)

not_run: WebUI.sendKeys(findTestObject('Object Repository/EngInfo/search'), Keys.chord(Keys.ENTER))

not_run: WebUI.waitForPageLoad(5)

CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)

CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.OPS, GlobalVariable.pwd)

TestDataFile = (System.getProperty('user.dir') + TestDataFile)

println(TestDataFile)

WebUI.click(findTestObject('Object Repository/ECR/WO/CRTab'))

WebUI.delay(5)

String CRID = WebUI.getText(findTestObject('ECR/Generic/CRLink'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ECR/WO/EngTab'))

String ENGID = WebUI.getText(findTestObject('ECR/Generic/ENGID'))

WebUI.delay(2)

String PROJID = WebUI.getText(findTestObject('ECR/Generic/PROJID'))

WebUI.delay(2)

WriteWO(1, TestDataFile, 2, CRID)

not_run: CustomKeywords.'com.helper.commonfunct.commonutilities.WriteWO'('', '')

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.BEPImport'('')

not_run: CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

