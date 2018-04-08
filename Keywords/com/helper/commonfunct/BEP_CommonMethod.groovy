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
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.org.apache.xalan.internal.xsltc.compiler.Number
import org.apache.commons.lang.RandomStringUtils
//import org.apache.james.mime4j.codec.CodecUtil
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.sun.jna.platform.win32.WinDef.WORD
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import com.helper.commonfunct.commonutilities as CUTILS


public class BEP_CommonMethod {

@Keyword
	
def BEPImport(String filename){
	WebUI.delay(5)
	WebUI.waitForElementVisible(findTestObject('BEP/Generic/import'), 0)
	WebUI.click(findTestObject('BEP/Generic/import'))
	WebUI.delay(5)
	WebUI.uploadFile(findTestObject('Generic/FilePath'), filename)
	WebUI.delay(5)
	WebUI.click(findTestObject('Generic/button_Submit'))
	}
	
@Keyword
def Estimate(
	String Filelocation, 
	String ORG, String ACC,
	String PL, 
	String RD, 
	String RL, 
	String PLTL,
	String Output, 
	String TestCaseNo, 
	String TestDataFile,
	Boolean DataDriven)
	{
		Filelocation=System.getProperty("user.dir")+Filelocation
		TestDataFile=System.getProperty("user.dir")+TestDataFile
		WebUI.maximizeWindow()
		WebUI.delay(2)
		WebUI.click(findTestObject('Generic/New'))
		WebUI.delay(4)
		WebUI.click(findTestObject('BEP/Generic/EstimateLink'))
		WebUI.delay(4)
		WebUI.click(findTestObject('ECR/Generic/WOTAB'))
		WebUI.waitForPageLoad(10)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 30)
		BEPImport(Filelocation)
		WebUI.delay(10)
		WebUI.setText(findTestObject('Generic/ORG'), ORG)
		WebUI.delay(7)
		WebUI.sendKeys(findTestObject('Generic/ORG'), Keys.chord(Keys.TAB))
		WebUI.delay(7)
		WebUI.setText(findTestObject('Generic/ACC'), ACC)
		WebUI.delay(7)
		WebUI.sendKeys(findTestObject('Generic/ACC'), Keys.chord(Keys.TAB))
		WebUI.delay(5)
	
		if(WebUI.verifyTextPresent("The engagement you entered doesn't match", false, FailureHandling.OPTIONAL))
			{
			EngInfo(PL,PLTL,RD,RL)
			ValueEst()	
			}
		else
		println 'It is existing engagement'
		
		
		OutputType(Output)
		CUTILS.woid()
		if(DataDriven)
		CUTILS.WriteWO(TestCaseNo, TestDataFile,1,GlobalVariable.WOID)
		}
	
@Keyword
def EngInfo(String PL,String PLTL, String RD, String RL){
	WebUI.setText(findTestObject('Generic/ENG_DESC'), 'AUTOTEST1')
	WebUI.delay(5)
	if(GlobalVariable.morethanOneRLS==true)
	{
	WebUI.click(findTestObject('BEP/Generic/MorethanOneRLSYES'))
	CUTILS.clickUsingJS(findTestObject('BEP/Generic/MorethanOneRLSYES'), 10)

	}
	else
	WebUI.click(findTestObject('BEP/Generic/MorethanOneRLSNO'))
	WebUI.delay(5)
	WebUI.selectOptionByValue(findTestObject('Object Repository/Generic/PlatformID'), 'PRD-87', false)
	WebUI.delay(5)
	WebUI.selectOptionByValue(findTestObject('Object Repository/Generic/PlatformVersion'),'RLS-2699',false)
	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/Generic/PlatformTrue'))
	WebUI.delay(5)
	
	WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/PL'), PL, false)
	WebUI.delay(5)
	if(WebUI.verifyTextPresent("PL Team Leader", false, FailureHandling.OPTIONAL))
	{
	WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/PLTL'),PLTL,false)
	WebUI.delay(5)	}
	else
	WebUI.delay(5)
	WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/RD'),RD,false)
	WebUI.delay(5)
	WebUI.selectOptionByValue(findTestObject('Object Repository/EngInfo/RL'), RL, false)
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
	WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
	WebUI.delay(5)
	WebUI.waitForPageLoad(20)
	
	

	
	}
@Keyword

def ValueEst()
{
	
	CUTILS.staleElement('BEP/Generic/DurationLow','12','setText')
	WebUI.delay(7)
	CUTILS.staleElement('BEP/Generic/DurationHigh','12','setText')
	WebUI.delay(7)
	CUTILS.staleElement('BEP/Generic/PartnerHoursLow','12','setText')
	WebUI.delay(5)
	CUTILS.staleElement('BEP/Generic/PartnerHoursHigh','12','setText')
	WebUI.delay(5)
	
	if(GlobalVariable.morethanOneRLS==true)
	{
	CUTILS.staleElement('BEP/Generic/PhaseDate',CUTILS.MeetingDT(),'setText')
	
	WebUI.delay(2)
	}
	else
	WebUI.delay(5)
	WebUI.click(findTestObject('BEP/Generic/EstimationMethod'))
	WebUI.delay(5)
	WebUI.sendKeys(findTestObject('BEP/Generic/EstimationMethod'), 'BSW', FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
	WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
	WebUI.delay(5)
}
	

@Keyword

def OutputType(String Output)

	{
	if(Output=='email')
	
		{
		WebUI.click(findTestObject('BEP/Generic/BEPOutputEmail'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/RECEIPIENT'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/AddEmailID'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('BEP/Generic/MAILID_XPATH'), 'nagaveni.nipinale@in.pega.com')
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/modal_submit'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('BEP/Generic/Email_Subject'), 'Test Automation')
		}
		else
		{
		WebUI.click(findTestObject('BEP/Generic/BEPoutput'))
		WebUI.delay(5)
		WebUI.selectOptionByValue(findTestObject('BEP/Generic/ReasonCode'), 'RFP in process', false)
		}
			
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.scrollToElement(findTestObject('Generic/FINISH_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/FINISH_BUTTON'))
		WebUI.waitForPageLoad(20)
	}
	

	


@Keyword
def RDapprove()
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RLApprove'),0)
		WebUI.click(findTestObject('BEP/Generic/RD_RLApprove'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(20)
		
		}
@Keyword
def noToRL()
		{
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/routeNoTORL'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/RD_RLApprove'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(20)
		}
@Keyword
def RDReject()
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RL_REJECT'),0)
		WebUI.click(findTestObject('BEP/Generic/RD_RL_REJECT'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(20)
		}
@Keyword
def GSOpsReview(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.delay(3)
		GlobalVariable.AssignmentList = WebUI.findWebElements(findTestObject('Object Repository/Generic/begin'), 10)
		println GlobalVariable.AssignmentList.size()
		if(GlobalVariable.AssignmentList.size()>1)
		{
		
		GlobalVariable.AssignmentList[1].click()
		WebUI.waitForPageLoad(20)
		}
		else 
		print 'test'
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 2)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		/*WebUI.refresh()*/
		
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(10)
		}
@Keyword
def RLapprove()
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		if (GlobalVariable.Meeting==true)
		{
			WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RLApprove'),0)
			WebUI.verifyTextPresent('A meeting for this estimate has been requested/scheduled', false)
		WebUI.delay(5)
		}
		else{
		WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RLApprove'),0)
		WebUI.click(findTestObject('BEP/Generic/RD_RLApprove'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(10)
		}
		}
		
@Keyword
def ScheduleMeeting()
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
	
		GlobalVariable.AssignmentList = WebUI.findWebElements(findTestObject('Object Repository/Generic/begin'), 10)
		
		
					if(GlobalVariable.AssignmentList[0].isEnabled())
						{
							GlobalVariable.AssignmentList[0].click()
							
						}
						else
							GlobalVariable.AssignmentList[1].click()
			
			
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.delay(3)
		WebUI.setText(findTestObject('ECR/Meeting/location'), 'Cambridge')
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('Object Repository/Generic/FINISH_ASSIGNMENT'))

		WebUI.waitForPageLoad(10)
		}
	
@Keyword
def Cancelmeeting()
	
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		GlobalVariable.AssignmentList = WebUI.findWebElements(findTestObject('Object Repository/Generic/begin'), 10)
		if(GlobalVariable.AssignmentList[0].isEnabled())
		{
			GlobalVariable.AssignmentList[0].click()
		}
		
		
		else if(GlobalVariable.AssignmentList[1].isEnabled())
		{
			GlobalVariable.AssignmentList[1].click()
		}
		
		else
		GlobalVariable.AssignmentList[2].click()
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Object Repository/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('Object Repository/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(10)
		}
@Keyword
	
def RLRequestMeeting(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RLApprove'),0)
		WebUI.click(findTestObject('BEP/Generic/RD_RLApprove'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Meeting/Meeting_Required'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Meeting/MeetingDate'), CUTILS.MeetingDT())
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.waitForPageLoad(10)
		}
	
	
@Keyword
	
def RLreject(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/RD_RL_REJECT'),0)
		WebUI.click(findTestObject('BEP/Generic/RD_RL_REJECT'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.delay(5)
		}
@Keyword
def withdraw(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.click(findTestObject('Generic/otherAction'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/withdraw_link'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/withdraw_notes'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('BEP/Generic/withdraw_notes'), Keys.chord(Keys.TAB))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/withdraw_submit'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Generic/CLOSE_WORK_OBJECT'))
		}


@Keyword 
def recall(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.click(findTestObject('Generic/otherAction'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/recall'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/recall_reason'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('BEP/Generic/recall_reason'), Keys.chord(Keys.TAB))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/recall_submit'))
		WebUI.waitForPageLoad(20)
		}

@Keyword
def Update(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.delay(5)
		}

@Keyword
def EmailCustomer(){
		if (GlobalVariable.CreateECR==true)
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		/*
		WebUI.click(findTestObject('BEP/Generic/emailPreview'))
		WebUI.delay(5)
		WebUI.switchToWindowTitle('Preview Bid Email', FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		WebUI.verifyTextPresent("This budgetary estimate", false)
		WebUI.delay(5)
		WebUI.click(findTestObject('ObjectRepository/BEP/emailModalClose'))*/
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/ECR_CHECKBOX'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/SEND_EMAIL'))
		WebUI.delay(5)
		}
	else{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.click(findTestObject('BEP/Generic/SEND_EMAIL'))
		WebUI.delay(5)
		}
	}
@Keyword
def SkipEmail(){
		if (GlobalVariable.CreateECR==true)
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.click(findTestObject('BEP/Generic/ECR_CHECKBOX'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/SKIP_EMAIL_XPATH'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('BEP/Generic/DispositionReason'), GlobalVariable.LongNotes)
		WebUI.delay(2)	
		WebUI.selectOptionByValue(findTestObject('BEP/Generic/ReasonCode'), 'RFP in process', false)
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/test'))
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/Modal_OK'))
		WebUI.delay(5)
				}
	else
		{
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.delay(2)
		WebUI.click(findTestObject('BEP/Generic/SKIP_EMAIL_XPATH'))
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('BEP/Generic/DispositionReason'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.selectOptionByValue(findTestObject('BEP/Generic/ReasonCode'), 'RFP in process', false)
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/test'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Generic/Modal_OK'))
		WebUI.delay(5)
			}
		}

@Keyword

def UpdateAfterRecall(){
		WebUI.delay(5)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		CUTILS.begin()
		WebUI.waitForPageLoad(20)
		WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('BEP/Generic/BEP_CASENOTES'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Generic/NEXT_BUTTON'), 2)
		WebUI.click(findTestObject('Generic/NEXT_BUTTON'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'),0)
		WebUI.click(findTestObject('BEP/Generic/FINISH_ASSIGNMENT'))
		WebUI.delay(5)
		
		}


@Keyword
def RequestCancelMeeting(){
		/*WebUI.switchToFrame(findTestObject('Generic/FRAME1'), 0)*/
		WebUI.click(findTestObject('OtherAction'))
		WebUI.delay(5)
		WebUI.click(findTestObject('BEP/Meeting/CancelMeeting'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('ECR/Generic/Reason'), GlobalVariable.LongNotes)
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('ECR/Generic/Reason'), Keys.chord(Keys.TAB))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/BEP/Meeting/Submit_otheraction'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Generic/CLOSE_WORK_OBJECT'))
		}





} /* End of the Program*/
