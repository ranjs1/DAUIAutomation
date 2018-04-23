package da.priage

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

import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class priageCommonActions {
	
	@Keyword
	def enterPriageEngagamentDetails(String org, String acc, String eng){
		WebUI.setText(findTestObject('PriageObjectRepository/Org_Name'), org)
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/Org_Name'), Keys.chord(Keys.TAB))
		WebUI.delay(4)
		WebUI.setText(findTestObject('PriageObjectRepository/Acc_Name'), acc)
		WebUI.delay(4)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/Acc_Name'), Keys.chord(Keys.TAB))
		WebUI.delay(4)
		WebUI.setText(findTestObject('PriageObjectRepository/Eng_Name'), eng)
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/Eng_Name'), Keys.chord(Keys.TAB))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/Engagement_Leader'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		//WebUI.click(findTestObject('PriageObjectRepository/PLTL_Dropdown'))
		WebUI.delay(2)
		//WebUI.click(findTestObject('PriageObjectRepository/PLTL_Select'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PriageObjectRepository/PegaMarketing_RadioButton_NO'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PriageObjectRepository/PegaMobile_RadioButton_NO'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PriageObjectRepository/Submit_Button'))
		WebUI.delay(2)
	}
	
	@Keyword
	def completePriageQuestionnaire() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))
		WebUI.delay(2)
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question1'), Keys.chord(Keys.ARROW_DOWN,
		Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question2'), Keys.chord(Keys.ARROW_DOWN,
		Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question3'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question4'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question5'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup1-Question6'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question1'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question2'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question3'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question4'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question5'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question6'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup2-Question7'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup3-Question1'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup3-Question2'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup3-Question3'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup4-Question1'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup4-Question2'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup5-Question1'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup5-Question2'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup5-Question3'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup6-Question1'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup6-Question2'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup6-Question3'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup6-Question4'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		
		WebUI.sendKeys(findTestObject('PriageObjectRepository/PriageQuestions/CategoryGroup6-Question5'), Keys.chord(Keys.ARROW_DOWN,
			Keys.ARROW_DOWN, Keys.ENTER))
		
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/Finishbutton'))
		WebUI.delay(2)
		
	}
	
	@Keyword
	def priageDecisionProcess() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/priageCandidate'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('PriageObjectRepository/reasonForPriage'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
		
		WebUI.setText(findTestObject('PriageObjectRepository/priageAssesementComments'), 'test Priage')
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/nextButton'))
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/Finishbutton'))
	} 
	
	@Keyword
	def scheduleKickOff() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PriageObjectRepository/priageMeetingStartDate'), '3/30/2028 2:57 AM')
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('Object Repository/PriageObjectRepository/priageMeetingStartDate'), Keys.chord(Keys.TAB))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PriageObjectRepository/priageMeetingEndDate'), '3/30/2028 2:59 AM')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/submitButton'))
		//WebUI.sendKeys(findTestObject('PriageObjectRepository/reasonForPriage'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
		WebUI.delay(2)
	}
	
	@Keyword
	def conDuctKickOffMeeting() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/riskLevelGreen'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/riskSummaryTrendingGreen'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PriageObjectRepository/gurdrailScore'), '2')
		
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/expandAll'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/governanceRisk'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/soulutionRisk'))
		WebUI.delay(2)		
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/deliveryRisk'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/performanceRisk'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/methodologyRisk'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/customerVisibility'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/continueAsPriage'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/continueAsPriage'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PriageObjectRepository/proposedMeetingDate'), '3/24/2028 11:10 AM')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/Submit_Button'))
		WebUI.delay(2)
		
	}
	
	@Keyword
	def schedulePriageMeeting() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/beginButtonOnAssignment'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PriageObjectRepository/Submit_Button'))
		WebUI.delay(2)
	}
	
	@Keyword
	def withdrawPriage() {
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/OtherActions'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CommonDAObjectRepository/Page_Pega 7/OtherAction-PriageWithdraw'))
	}
	
}


