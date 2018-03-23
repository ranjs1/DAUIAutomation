package commonmethods

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

import org.junit.After
import org.openqa.selenium.Keys as Keys

public class TCPmethods {
	
@Keyword

def login(){
	
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('LoginProfile/Page_Pega 7/input_UserIdentifier'), GlobalVariable.User)

WebUI.setText(findTestObject('LoginProfile/Page_Pega 7/input_Password'), GlobalVariable.Password)

WebUI.click(findTestObject('LoginProfile/Login_Pega 7/span_Log in'))
	}

@Keyword
def logoff(){
WebUI.click(findTestObject('LoginProfile/Login_Pega 7/Logout_operator'))
WebUI.delay(3)
WebUI.click(findTestObject('LoginProfile/Login_Pega 7/Logoff'))
}

}