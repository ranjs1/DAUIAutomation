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

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Consultant_name'))

WebUI.delay(3)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/span_My Profile'))

//WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/PrivacyStatement'))
//WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Save_Exit'))
WebUI.delay(5)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Tab'))

println(WebUI.takeScreenshot())

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Edit_profile'))

WebUI.delay(10)

WebUI.acceptAlert()

WebUI.delay(10)

println(WebUI.takeScreenshot())

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Certifications'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Travel And Security'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Pega Experience'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Training'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Skills'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Languages'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Education'))

WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Other Experience'))

