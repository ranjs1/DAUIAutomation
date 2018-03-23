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

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Travel And Security'))

println(WebUI.takeScreenshot())

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/select_BirthCountry'), 'United States', true)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/select_country'), 'United States', true)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/input_GreenCard'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/input_SecurityClearance'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/input_ValidPassport'))

WebUI.delay(1)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/input_Passport'))

WebUI.delay(3)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Pega Experience'))

WebUI.delay(3)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/PegaExp_AddIcon'))

WebUI.delay(3)

println(WebUI.takeScreenshot())

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/PegaExp_OrgName'), 'AMAZON')

WebUI.delay(2)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/PegaExp_Role'), 'System Architect', true)

WebUI.delay(2)

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/PegaExp_StartDate'), '1/1/2017')

WebUI.delay(4)

WebUI.sendKeys(findTestObject('LoginProfile/Page_Profile_elements/PegaExp_EndDate'), '2/1/2018')

WebUI.delay(4)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Skills'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Skill_AddIcon'))

println(WebUI.takeScreenshot())

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/Skill_SubCat'), 'Healthcare', true)

WebUI.delay(2)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/Skill_Attribute'), 'Dental', true)

WebUI.delay(2)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/Skill_Experience'), '1 to 3 years', true)

WebUI.delay(2)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Certifications'))

println(WebUI.takeScreenshot())

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Training'))

println(WebUI.takeScreenshot())

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Languages'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Lang_AddIcon'))

println(WebUI.takeScreenshot())

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/lang_Fluency'), 'English', true)

WebUI.delay(2)

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/Lang_language'), 'Native', true)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Other Experience'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/OtherExp_AddIcon'))

println(WebUI.takeScreenshot())

WebUI.sendKeys(findTestObject('LoginProfile/Page_Profile_elements/OthrExp_Company'), 'JPMC')

WebUI.sendKeys(findTestObject('LoginProfile/Page_Profile_elements/OthrExp_StartDate'), '1/1/2017')

WebUI.delay(3)

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/OthrExp_EndDate'), '1/2/2018')

WebUI.delay(2)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/h3_Education'))

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/Edu_AddIcon'))

println(WebUI.takeScreenshot())

WebUI.delay(3)

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/Edu_Institution'), 'MIT')

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/Edu_Major'), 'AH')

WebUI.selectOptionByValue(findTestObject('LoginProfile/Page_Profile_elements/Edu_Degree'), 'Bachelors', true)

WebUI.sendKeys(findTestObject('LoginProfile/Page_Profile_elements/Edu_Year'), '2010')

WebUI.setText(findTestObject('LoginProfile/Page_Profile_elements/Edu_Notes'), 'Automation scripting')

WebUI.click(findTestObject('Dummy/Page_The Consulting Portal (TCP)/div_Save  Exit'))

WebUI.delay(5)

WebUI.click(findTestObject('LoginProfile/Page_Profile_elements/CloseWO'))

WebUI.delay(3)

CustomKeywords.'commonmethods.TCPmethods.logoff'()

WebUI.closeBrowser()

