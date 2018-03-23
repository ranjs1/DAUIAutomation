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


public class Profilecommonmethods {

@Keyword
	
	def MyProfile(){
		
		WebUI.switchToFrame(findTestObject('LoginProfile/Frames/iframe_PegaGadget1Ifr'), 0)
		
		WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Consultant_name'))
		
		WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/span_My Profile'))
		
		//WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/PrivacyStatement'))
		//WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Save_Exit'))
		WebUI.delay(5)
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Consultant Info'), FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Certifications'), FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Travel And Security'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Pega Experience'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Training'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Skills'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Languages'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Education'))
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Other Experience'))
		
		WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Edit_profile'))
		
		WebUI.delay(10)
		
		WebUI.acceptAlert()
		
		WebUI.delay(10)
		
		WebUI.verifyElementVisible(findTestObject('LoginProfile/Page_Profile_elements/h3_Professional Summary'))
		
		WebUI.verifyElementText(findTestObject('LoginProfile/Page_Profile_elements/WO_Status'), 'Open')
		
	}
	
@Keyword	

def Profilefunctions(){
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Travel And Security'))
	
	WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/select_BirthCountry'), 'United States',
		true)
	
	WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/select_country'), 'United States', true)
	
	WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/input_GreenCard'))
	
	WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/input_SecurityClearance'))
	
	WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/input_ValidPassport'))
	
	WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/input_Passport'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Pega Experience'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Skills'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Certifications'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Training'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Languages'))
	
	WebUI.selectOptionByValue(findTestObject('Dummy/Page_The Consulting Portal (TCP)/select_PpyWorkPagepProfileData (5)'), 'English',
		true)
	
	WebUI.selectOptionByValue(findTestObject('Dummy/Page_The Consulting Portal (TCP)/select_PpyWorkPagepProfileData (6)'), 'Native',
		true)
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Other Experience'))
	
	WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Education'))
	
	WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/div_Save  Exit'))
	
	}
}
