package com.helper.commonfunct

import org.junit.After
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.StaleElementReferenceException
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
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementPresentKeyword
import com.sun.org.apache.xalan.internal.xsltc.compiler.Number
import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.WebElement
import internal.GlobalVariable as GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebDriver as WebDriver
import WebElement as WebElement
import java.text.SimpleDateFormat
import java.text.NumberFormat
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.remote.RemoteWebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor




public class commonutilities
{
	
	@Keyword
	def clickUsingJS(TestObject to, int timeout)
	{
	WebDriver driver = DriverFactory.getWebDriver()
	WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
	JavascriptExecutor executor = ((driver) as JavascriptExecutor)
	executor.executeScript('arguments[0].click()', element)
	}
	

@Keyword
def CreateECR(String Filelocation, String ORG, String ACC,String PL, String RD, String RL, String PLTL,Boolean DataDriven, String TestCaseNo,String TestDataFile, String APP)
{
					Filelocation=System.getProperty("user.dir")+Filelocation
					TestDataFile=System.getProperty("user.dir")+TestDataFile
					println Filelocation
					println TestDataFile
					
					
					if (APP=='SA')
					{
						search()
						begin()
						WebUI.delay(5)
						WebUI.click(findTestObject('Generic/Import_SA'))
						WebUI.uploadFile(findTestObject('Generic/FilePath'), Filelocation)
						WebUI.delay(5)
						WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),2)
						WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
						WebUI.waitForPageLoad(5)
					}
					
					else{
								
						
						WebUI.maximizeWindow()
						WebUI.delay(2)
						WebUI.click(findTestObject('Generic/New'))
						WebUI.delay(4)
						WebUI.click(findTestObject('Generic/span_Bid Process'))
						WebUI.delay(4)
						WebUI.click(findTestObject('ECR/Generic/WOTAB'))
						WebUI.delay(2)
						WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 2)
						WebUI.delay(4)
						WebUI.click(findTestObject('ECR/Generic/BID_TYPE'))
						Import(Filelocation)
						WebUI.delay(2)
					}
					
					
					
					WebUI.setText(findTestObject('Generic/ORG'), ORG)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Generic/ORG'), Keys.chord(Keys.TAB))
					WebUI.delay(5)
					WebUI.setText(findTestObject('Generic/ACC'), ACC)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Generic/ACC'), Keys.chord(Keys.TAB))
					WebUI.delay(7)
					WebUI.waitForPageLoad(30)
					def EngNew = false
					
					if(WebUI.verifyTextPresent("The engagement you entered doesn't match", false, FailureHandling.OPTIONAL))
					{
						WebUI.setText(findTestObject('Generic/ENG_DESC'), 'AUTOTEST1')
						WebUI.delay(3)
						EngNew = true
					}
					else					
					WebUI.delay(5)
					
					clickUsingJS(findTestObject('Generic/SUBMIT'),30)
					/*staleElement('Generic/SUBMIT','','click')
					WebUI.scrollToElement(findTestObject('Generic/SUBMIT'), 5)
					WebUI.waitForPageLoad(3)
					WebUI.click(findTestObject('Generic/SUBMIT'))
					WebUI.delay(1)
					WebUI.click(findTestObject('Generic/SUBMIT'))*/
					WebUI.delay(2)
					String LedBy=WebUI.getText(findTestObject("ECR/Generic/LedBy"))
					WebUI.delay(2)
					println LedBy
					String ProjectType=WebUI.getText(findTestObject("ECR/Generic/ProjectType"))
					WebUI.delay(2)
					println ProjectType
					String Licence=WebUI.getText(findTestObject("ECR/Generic/LicenceNew"))
					println Licence
					WebUI.setText(findTestObject('Object Repository/EngInfo/COID'), 'CO-12')
					WebUI.delay(2)
								
					if(LedBy=='Pega Led' && ProjectType=='Full Implementation')
					{
					/*
						WebUI.delay(5)
					WebUI.click(findTestObject('Object Repository/Generic/RapidDelivery'))
					WebUI.delay(5)
					WebUI.click(findTestObject('Object Repository/Generic/MorethanOneRLS'))
					WebUI.delay(5)
					WebUI.click(findTestObject('Generic/gapDrivenMethodology'))
					WebUI.delay(2)
					WebUI.click(findTestObject('Object Repository/Generic/RapidDelivery'))*/
					clickUsingJS(findTestObject('Object Repository/Generic/RapidDelivery'),30)
					WebUI.delay(2)
					clickUsingJS(findTestObject('Object Repository/Generic/MorethanOneRLS'),30)
					WebUI.delay(2)
					clickUsingJS(findTestObject('Object Repository/Generic/gapDrivenMethodology'),30)
					WebUI.delay(2)
					
					}
					else
					{
					WebUI.click(findTestObject('Object Repository/Generic/MorethanOneRLS'))
					WebUI.delay(2)
					WebUI.click(findTestObject('Object Repository/Generic/MorethanOneRLS'))
					WebUI.delay(2)			
					}
					
					if(Licence=='Yes')
					{	
						WebUI.delay(1)
						WebUI.setText(findTestObject('ECR/Generic/Licence'), '85000')
						WebUI.delay(1)
						println 'licence value entered'
					}
					else
					
					println 'no licence value'
					
					
					if(EngNew)
					{
					WebUI.delay(5)
					WebUI.waitForElementVisible(findTestObject('Object Repository/Generic/platform'), 10)
					WebUI.delay(5)
					WebUI.selectOptionByValue(findTestObject('Object Repository/Generic/PlatformID'), 'PRD-87', false)
					WebUI.delay(5)
					WebUI.selectOptionByValue(findTestObject('Object Repository/Generic/PlatformVersion'),'RLS-2699',false)
					WebUI.delay(5)
					WebUI.click(findTestObject('Object Repository/Generic/PlatformTrue'))
					WebUI.delay(2)
					WebUI.click(findTestObject('Object Repository/Generic/PlatformTrue'))
					WebUI.delay(2)
					WebUI.sendKeys(findTestObject('ECR/Generic/Location'), 'Cambridge')
					
					
					if(WebUI.verifyTextPresent("PL Team Leader", false, FailureHandling.OPTIONAL))
					{
					WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/PLTL'),PLTL,false)
					WebUI.delay(5)	}					
					else
					WebUI.delay(5)
					
					
					WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/PL'), PL, false)
					WebUI.delay(5)	
					WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/RL'),RL,false)
					WebUI.delay(5)
					WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/RD'),RD,false)
					
					
					
					}
					
					
					else
					WebUI.sendKeys(findTestObject('ECR/Generic/Location'), 'Cambridge')
					
					WebUI.delay(5)
					
					woid()
					
					if(DataDriven)
					WriteWO(TestCaseNo, TestDataFile)
									
					
					WebUI.delay(5)
					WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
					WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
					WebUI.waitForPageLoad(5)
				
					
					if(WebUI.verifyElementPresent(findTestObject('ECR/Meeting/ClinicMeeting'), 3, FailureHandling.OPTIONAL))
					{
						
						GlobalVariable.Meeting=true
						WebUI.setText(findTestObject('EngInfo/MeetingDate'), MeetingDT())
						WebUI.delay(5)
						WebUI.setText(findTestObject('EngInfo/instruction'), GlobalVariable.LongNotes)
						GlobalVariable.LongNotes
						WebUI.delay(5)
						staleElement('EngInfo/AE','','setText')
						staleElement('EngInfo/AE','Nagaveni Nipinale','setText')
						WebUI.sendKeys(findTestObject('EngInfo/AE'), Keys.chord(Keys.DOWN))
						WebUI.delay(2)
						WebUI.click(findTestObject('ECR/Meeting/SelectHighlighted'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/IsPegaMarketingYes'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/IsPegaMobileYes'))
						WebUI.delay(5)
						
						/*Services & Sales Team*/
						
						WebUI.delay(5)
						WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
						WebUI.delay(5)
						WebUI.click(findTestObject('Object Repository/EngInfo/isCloudInitiativeYes'))
						WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
						WebUI.delay(5)
						WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/Continue'))
						WebUI.delay(5)
						attachDocs()
						
					}
					
				
					else
					{
					WebUI.click(findTestObject('Object Repository/EngInfo/isCloudInitiativeYes'))
					WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
					WebUI.delay(7)
					WebUI.waitForPageLoad(3)
					WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
					WebUI.waitForPageLoad(30)
					WebUI.delay(5)
						}
}
		
		
@Keyword
def OpenECR(String Filelocation, String ORG, String ACC,String PL, String RD, String RL, String PLTL, String WOID)
{
					search()
					begin()
					WebUI.click(findTestObject('Generic/Import_SA'))
					WebUI.uploadFile(findTestObject('Generic/FilePath'), Filelocation)
					WebUI.delay(5)
					WebUI.scrollToElement(findTestObject('Generic/button_Submit'), 5)
					WebUI.click(findTestObject('Generic/button_Submit'))
					WebUI.delay(5)
					WebUI.setText(findTestObject('Generic/ORG'), ORG)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Generic/ORG'), Keys.chord(Keys.TAB))
					WebUI.delay(5)
					WebUI.setText(findTestObject('Generic/ACC'), ACC)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Generic/ACC'), Keys.chord(Keys.TAB))
					WebUI.delay(5)
					
					if(WebUI.verifyTextPresent("The engagement you entered doesn't match", false, FailureHandling.OPTIONAL))
				
					WebUI.setText(findTestObject('Generic/ENG_DESC'), 'AUTOTEST1')
					
					else
					WebUI.delay(5)
								
					
					String LedBy=WebUI.getText(findTestObject("ECR/Generic/LedBy"))
					WebUI.delay(2)
					println LedBy
					String ProjectType=WebUI.getText(findTestObject("ECR/Generic/ProjectType"))
					WebUI.delay(2)
					println ProjectType
					String Licence=WebUI.getText(findTestObject("ECR/Generic/LicenceNew"))
					println Licence					
					WebUI.delay(2)
								
					if(LedBy=='Pega Led' && ProjectType=='Full Implementation')
					{
					
						WebUI.delay(7)
					WebUI.click(findTestObject('Object Repository/Generic/RapidDelivery'))
					WebUI.delay(7)
					WebUI.click(findTestObject('Object Repository/Generic/MorethanOneRLS'))
					WebUI.delay(7)
					WebUI.click(findTestObject('Generic/gapDrivenMethodology'))
					WebUI.delay(2)
					WebUI.click(findTestObject('Object Repository/Generic/RapidDelivery'))
					}
					else
					{
					WebUI.click(findTestObject('Object Repository/Generic/MorethanOneRLS'))
					WebUI.delay(2)
					}
					
			
					
					
					WebUI
					WebUI.delay(5)
					WebUI.waitForElementVisible(findTestObject('Object Repository/Generic/platform'), 10)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Object Repository/Generic/PlatformID'),'Pega Platform(PRPC)')
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Object Repository/Generic/PlatformVersion'),'7')
					WebUI.delay(5)
					WebUI.click(findTestObject('Object Repository/Generic/PlatformTrue'))
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('ECR/Generic/Location'), 'Cambridge')
								
					
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/Generic/product_Delete'), 3, FailureHandling.OPTIONAL))
					WebUI.click(findTestObject('Object Repository/Generic/product_Delete'))
					
					else
								
					
					/*WebUI.sendKeys(findTestObject('Object Repository/EngInfo/PL'),PL)*/
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Object Repository/EngInfo/PLTL'),PLTL)
					WebUI.delay(5)
					/*WebUI.sendKeys(findTestObject('Object Repository/EngInfo/RL'),RL)
					WebUI.delay(5)
					WebUI.sendKeys(findTestObject('Object Repository/EngInfo/RD'),RD)
					WebUI.delay(5)*/
					
					
					WebUI.delay(5)
					WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
					WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
					WebUI.waitForPageLoad(10)
				
					
					if(WebUI.verifyElementPresent(findTestObject('ECR/Meeting/ClinicMeeting'), 3, FailureHandling.OPTIONAL))
					{
						
						GlobalVariable.Meeting=true
						WebUI.setText(findTestObject('EngInfo/MeetingDate'), MeetingDT())
						WebUI.delay(5)
						WebUI.setText(findTestObject('EngInfo/instruction'), GlobalVariable.LongNotes)
						WebUI.delay(5)
						staleElement('EngInfo/AE','','setText')
						staleElement('EngInfo/AE','Nagaveni Nipinale','setText')
						WebUI.sendKeys(findTestObject('EngInfo/AE'), Keys.chord(Keys.DOWN))
						WebUI.delay(2)
						WebUI.click(findTestObject('ECR/Meeting/SelectHighlighted'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/IsPegaMarketingYes'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/IsPegaMobileYes'))
						WebUI.delay(5)
						
						/*Services & Sales Team*/
						
						WebUI.delay(5)
						WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
						WebUI.delay(5)
						WebUI.click(findTestObject('Object Repository/EngInfo/isCloudInitiativeYes'))
						WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
						WebUI.delay(5)
						WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'), 2)
						WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
						WebUI.delay(5)
						WebUI.click(findTestObject('EngInfo/Continue'))
						WebUI.delay(5)
						attachDocs()
						
					}
					
				
					else
					{
					WebUI.click(findTestObject('Object Repository/EngInfo/isCloudInitiativeYes'))
					WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
					WebUI.delay(7)
					WebUI.waitForPageLoad(10)
					WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
					WebUI.waitForPageLoad(12)
					WebUI.delay(5)
						}
}




		
@Keyword		
def Import(String Filelocation)

		{
		WebUI.verifyElementPresent(findTestObject('Generic/button_Import'),2)
		WebUI.delay(5)
		WebUI.click(findTestObject('Generic/button_Import'))
		WebUI.uploadFile(findTestObject('Generic/FilePath'), Filelocation)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/button_Submit'), 5)
		WebUI.click(findTestObject('Generic/button_Submit'))
		WebUI.delay(5)
		}

	
		
@Keyword

def isChecked(WebElement UIElement)
{
	for(int i=0;i<2;i++)
	{
		if(!UIElement.isSelected())
		{	
		println 'element is not selected'
		break
		}
		
		/*else
		{
			WebUI.delay(3)
			UIElement.click()
			println 'element is clicked'
			WebUI.delay(3)
		}*/
	}
}
		
@Keyword
def approve()
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'),4)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),2)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.waitForPageLoad(5)
		}
		
		
@Keyword
		
		
def EXPReview()
		{
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			
			begin()
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		}
@Keyword
def gsopsApprove(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		beginGSOPS()	
		WebUI.waitForPageLoad(3)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'),3)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		
		}
		
		
	
@Keyword
	def gsopsReject(){
		
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		beginGSOPS()
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/ReturnToRequestor'),5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/ReturnToRequestor'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		if (GlobalVariable.Meeting==true)
		{
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
		WebUI.delay(5)
		WebUI.click(findTestObject('EngInfo/Continue'))
	
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('ECR/Meeting/BSW_TEXT'), GlobalVariable.LongNotes)
		WebUI.delay(5)
			
		def List= []
		List = WebUI.findWebElements(findTestObject('ECR/Meeting/TextArea_Meeting'), 10)
		for (int i = 0; i < List.size(); i++)
		List[i].sendKeys(GlobalVariable.LongNotes)
		
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		}
		else  
		{
		println "no meeting"
		
		WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
		WebUI.delay(5)
		}
		
	}
			
@Keyword
def reject()
			{
				WebUI.delay(5)
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				begin()				
				WebUI.delay(5)
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/ReturnToRequestor'),0)
				WebUI.click(findTestObject('Object Repository/Approve-Reject/ReturnToRequestor'))
				WebUI.delay(5)
				WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
				WebUI.delay(5)
				WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
				WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
				WebUI.delay(5)
			}

	
@Keyword
def attachDocs(){
			WebUI.delay(5)
			begin()
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			WebUI.sendKeys(findTestObject('ECR/Meeting/BSW_TEXT'), GlobalVariable.LongNotes)
			WebUI.delay(5)
			def List= []
			List = WebUI.findWebElements(findTestObject('ECR/Meeting/TextArea_Meeting'), 10)
			for (int i = 0; i < List.size(); i++)
			List[i].sendKeys(GlobalVariable.LongNotes)
			WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
			WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
			WebUI.delay(5)
			GlobalVariable.Meeting=1
			}
		
			

@Keyword
def ContractDisposition()
		{
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.click(findTestObject('Approve-Reject/createContract'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Approve-Reject/createContract'))
		WebUI.setText(findTestObject('Object Repository/Approve-Reject/contractNotes'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		begin()
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/dispositionOption'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('Object Repository/Approve-Reject/disposition_comments'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		}

@Keyword

def routeToRL()
		{
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'),5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		if (GlobalVariable.Meeting==false)
		{
		WebUI.click(findTestObject('Object Repository/Approve-Reject/routetoRL'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		}
		else {
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		}
		}


@Keyword

def noRL()
		{
	
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'),5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/routetoRLNO'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		}

@Keyword
		
def RDApprove_Meeting()
				{
	
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'),5)
		WebUI.click(findTestObject('Object Repository/Approve-Reject/APPROVE_BUTTON'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
		WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		}
				

			
	
	


		
@Keyword

def docUpdate()
		{
		
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'),5)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'),5)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'),3)
		WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(4)
		}
		
		
@Keyword
		
def docUpdateMeeting()
				{
			
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				begin()
				WebUI.delay(5)
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'),5)
				WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
				WebUI.waitForPageLoad(4)
				WebUI.delay(5)
				WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'),5)
				WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
				WebUI.delay(5)
				
				WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'),5)
				WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
				WebUI.delay(5)
				WebUI.waitForPageLoad(4)
				WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'),3)
				WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
				WebUI.delay(5)
				WebUI.click(findTestObject('EngInfo/Continue'))
				WebUI.waitForPageLoad(3)
				begin()				
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				WebUI.sendKeys(findTestObject('ECR/Meeting/BSW_TEXT'), GlobalVariable.LongNotes)
				WebUI.delay(5)
				
				
				def List= []
				List = WebUI.findWebElements(findTestObject('ECR/Meeting/TextArea_Meeting'), 10)
				for (int i = 0; i < List.size(); i++)
				List[i].sendKeys(GlobalVariable.LongNotes)

				
				WebUI.sendKeys(findTestObject('Approve-Reject/APPROVE_REJECT_NOTES'), GlobalVariable.LongNotes)
				WebUI.delay(5)
				WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
				WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
				WebUI.delay(5)
			
				}
		
				


@Keyword

def setprop(String Flow){
		
if (Flow =='Approve')


		{
		GlobalVariable.RLReject=false
		GlobalVariable.RDReject=false
		GlobalVariable.OpsReject=false
		GlobalVariable.RouteToRL=true
		GlobalVariable.RDD_Reject=false
		GlobalVariable.EXP_SVC_Reject=false
		}

		else if(Flow =='Reject')

		{
			GlobalVariable.RLReject=true
			GlobalVariable.RDReject=true
			GlobalVariable.OpsReject=true
			GlobalVariable.RouteToRL=true
			GlobalVariable.RDD_Reject=true
			GlobalVariable.EXP_SVC_Reject=true
			}
		
		else
		
		{
			GlobalVariable.RLRecall=true
			GlobalVariable.RDRecall=true
			GlobalVariable.OpsRecall=true
			GlobalVariable.RouteToRL=true
			GlobalVariable.EXP_SVC_Recall=true
			}
}

@Keyword
def scheduleMeeting(){
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			begin()
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			WebUI.setText(findTestObject('ECR/Meeting/location'), 'Cambridge')
			WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
			WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
			WebUI.delay(5)
		}
				

@Keyword

def pendingClinic()
		{
		
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			begin()
			WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
			
			WebUI.click(findTestObject('ECR/Meeting/CLINIC_OUTCOME'))
			WebUI.delay(5)
			WebUI.setText(findTestObject('ECR/Meeting/OUTCOME_NOTES'), GlobalVariable.LongNotes)
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('Object Repository/Generic/SUBMIT'),5)
			WebUI.click(findTestObject('Object Repository/Generic/SUBMIT'))
			WebUI.delay(5)
		}
			
		@Keyword
		def static String MeetingDT()
			{
				def MeetingDate = new Date()
				MeetingDate=MeetingDate+2
				return  MeetingDate.format("MM/dd/YYYY")
			
			}
			
@Keyword
def searchStatus(){
			WebUI.delay(5)
			
			def WOStatusList = []
			WOStatusList = WebUI.findWebElements(findTestObject('Generic/SearchStatus'), 10)
			
			for (int i = 0; i < WOStatusList.size(); i++)
			{
			if(WOStatusList[i].text !=''){
			GlobalVariable.WOSTATUS=WOStatusList[i].text
			println GlobalVariable.WOSTATUS
			println "Test has value"
			}
			else
			println "Text is null"
			}
			WebUI.delay(5)
			GlobalVariable.AssignmentList = WebUI.findWebElements(findTestObject('Generic/AssignmentStatus'), 30)
			for (int i = 0; i < GlobalVariable.AssignmentList.size(); i++)
			{
			 println GlobalVariable.AssignmentList[i].text
				WebUI.delay(3)
	
			}
			
			}
				
		
		
				
@Keyword
def search()
			{
			WebUI.maximizeWindow()
			WebUI.delay(5)
			WebUI.setText(findTestObject('Object Repository/EngInfo/search'), GlobalVariable.WOID)
			WebUI.delay(3)
			WebUI.sendKeys(findTestObject('Object Repository/EngInfo/search'), Keys.chord(Keys.ENTER))
			WebUI.waitForPageLoad(5)
			/*WebUI.click(findTestObject('ECR/Generic/SwitchWO'))*/
			println GlobalVariable.WOID
			}
			
			
			
@Keyword

def RC()
{

	
	WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
	WebUI.delay(5)
	def rateCards = []
	rateCards = WebUI.findWebElements(findTestObject('Object Repository/RC'), 30)
	
		int num=200
	 for (int i = 0; i < rateCards.size(); i++)
	 {
		 rateCards[i].clear()
		 WebUI.delay(1)
		 rateCards[i].sendKeys(Integer.toString(num))
		 num=num+5
		 WebUI.delay(1)
	}
 
}
			
			
@Keyword
		
def static begin()


	{		
			WebUI.delay(5)
			def BeginList=[]
			BeginList= WebUI.findWebElements(findTestObject('Object Repository/Generic/BeginList'), 30)
			WebUI.delay(7)
			for (int j = 0; j < BeginList.size(); j++)
				{
				if (BeginList[j].isEnabled())
					{
						println 'element clickable'
						
						WebUI.delay(5)
						BeginList[j].click()
						WebUI.waitForPageLoad(5)
						break
					}
					else
					println 'element is not clickable'
				}
				
				WebUI.waitForPageLoad(20)
			}
		
@Keyword
def static WriteWO(String TestCaseNo, String TestDataFile)
			{
			java.lang.Integer seqNum = Integer.parseInt(TestCaseNo)
			println seqNum
			InputStream ExcelFileToRead = new FileInputStream(TestDataFile);
			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead)
			XSSFSheet  sheet=wb.getSheetAt(0)
			Row row = sheet.getRow(seqNum);
			Cell cell = row.getCell(1);
			if (cell == null) {
				cell = row.createCell(1);
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(GlobalVariable.WOID);
			ExcelFileToRead.close()
			FileOutputStream fos = new FileOutputStream(TestDataFile)
			wb.write(fos)
			}
		
		@Keyword
		
		def static beginGSOPS()
			{
				def BeginList = []
				def AssignmentList =[]
				AssignmentList= WebUI.findWebElements(findTestObject('Generic/AssignmentStatus'), 10)
				BeginList=WebUI.findWebElements(findTestObject('Object Repository/Generic/BeginList'), 1)
				WebUI.delay(3)
				for (int j = 0; j < AssignmentList.size(); j++)
						{
					if (BeginList[j].isEnabled() && AssignmentList[j].text=='Pending-OPSApproval')
						{
							println GlobalVariable.WOSTATUS=AssignmentList[j].text
							GlobalVariable.WOSTATUS=AssignmentList[j].text
							
							WebUI.delay(5)
							BeginList[j].click()
							WebUI.waitForPageLoad(5)
							break
						}
						else
					println 'element is not clickable'
					}
			}
		
		
		@Keyword
		def login(String URL, String username, String pwd)
				{
				WebUI.openBrowser('')
				WebUI.navigateToUrl(URL)
				WebUI.setText(findTestObject('Generic/input_UserIdentifier'), username)
				WebUI.setText(findTestObject('Generic/input_Password'), pwd)
				WebUI.sendKeys(findTestObject('Generic/input_Password'), Keys.chord(Keys.ENTER))
				}
@Keyword
def static  woid()
			{
			GlobalVariable.WOID=WebUI.getText(findTestObject('Generic/WOID'))
			print(GlobalVariable.WOID)
			}

			@Keyword
			
	def  priage()
	{
				WebUI.delay(5)
				WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 5)
				begin()				
				WebUI.delay(5)	}
	
	

@Keyword
		def static staleElement(String stale,String value, String option)
		{
				
				for(int i=0;i<2;i++)
				{
					if(option=='sendKeys')
					try {
							WebUI.sendKeys(findTestObject(stale),value)
							println "first try block"
							break
					}
					catch (StaleElementReferenceException)
						
					{
						println  i
					}
					
									
					else if (option=='setText')
					try {
							WebUI.setText(findTestObject(stale),value)
							println "first try block"
							break
					}
					catch (StaleElementReferenceException)
						
					{
						println  i
					}
					
					
					else (option=='click')
					try {
							WebUI.click(findTestObject(stale),value)
							println "first try block"
							break
					}
					catch (StaleElementReferenceException)
						
					{
						println  i
					}
					
		
				}
		}
		
			
		

		
}		
		
		
			
		

// end of class
