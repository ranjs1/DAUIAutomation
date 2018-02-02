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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://vtcpfusionqa.rpega.com:9030/tcpfusionqa/PRServlet/WRr0lyMCuypQncoWBWzmItjouokRpn0jivm_loYZWDI9KRrZ8xRc6A%5B%5B*/!STANDARD')
WebUI.delay(45)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Pega 7/input_UserIdentifier'), 'pogoa@pegasystems.com')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Pega 7/input_Password'), 'install')

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Pega 7/button_pyActivityCode-Security'))

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/a_appview-nav-toggle-one'))

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/span_Rate Card'))

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/a_RateCardList_RC_45'))

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepOrganization'), 
    'HITACHI')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepOrganization'), 
    Keys.chord(Keys.TAB))

WebUI.delay(3)

//WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/span_Hitachi'))
WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepAccountID'), 
    'HITACH')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepAccountID'), 
    Keys.chord(Keys.TAB))

WebUI.delay(3)

//not_run: WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/span_HITACH'))
WebUI.sendKeys(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/select_PpyWorkPagepPracticeLea'), 
    Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/select_PpyWorkPagepPracticeLea'), 
    'flems@pegasystems.com', true)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepTier'), 
    'Tier 2')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/textarea_PpyWorkPagepTierDescr'), 
    'Tier 2 Description')

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepIncludedInMS'))

WebUI.selectOptionByValue(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/select_PpyWorkPagepRateSource'), 
    'MSA', true)

WebUI.delay(3)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepContractID'), 
    'CR-4321')

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/select_PpyWorkPagepRateType'), 
    'Daily', true)

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/select_PpyWorkPagepExpenses'), 
    'Inclusive', true)

WebUI.delay(3)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepCurrency'), 
    'USD')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepCurrency'), 
    Keys.chord(Keys.TAB))

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesExpireD'), 
    '1/9/2019')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepNextIncrease'), 
    '1/14/2019')

WebUI.delay(3)

/*WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/div_oflowDiv'))

WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/img_inactvIcon icnHvr'))

WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/button_spin-button spin-down'))

WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/button_spin-button spin-up'))
WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/button_spin-button spin-up'))

WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/a_7'))
WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/img_inactvIcon icnHvr (1)'))
WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/button_spin-button spin-up'))
WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/a_14'))
WebUI.delay(3)
*/
WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepNoOfHours'), 
    '8')

WebUI.delay(3)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPASAOF'), 
    '200')

WebUI.delay(3)

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgSBApRa'), 
    '130')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLASA'), 
    '250')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLLSA'), 
    '450')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgSDApRa'), 
    '300')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLSAO'), 
    '325')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPSSAOF'), 
    '425')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPSApRa'), 
    '300')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgLBApRa'), 
    '250')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgLDApRa'), 
    '540')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgUEApRa'), 
    '120')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPLSAOF'), 
    '130')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgASApRa'), 
    '150')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgBMCpRa'), 
    '160')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgTApRat'), 
    '170')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPELOFF'), 
    '180')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPLSAOF (1)'), 
    '190')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPSAOFF'), 
    '200')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgDCpRat'), 
    '210')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLASA (1)'), 
    '220')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgSSApRa'), 
    '230')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgDApRat'), 
    '240')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgBApRat'), 
    '250')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLSAp'), 
    '260')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPLpRat'), 
    '270')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPSBAOF'), 
    '280')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgUIDpRa'), 
    '290')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLLSA (1)'), 
    '300')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPDApRa'), 
    '310')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPBApRa'), 
    '320')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgELpRat'), 
    '330')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLSSA'), 
    '340')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPApRat'), 
    '350')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgPOLSSA (1)'), 
    '360')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgSApRat'), 
    '370')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/input_PpyWorkPagepRatesgLSApRa'), 
    '380')

WebUI.setText(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/textarea_PpyWorkPageppyNote'), 
    'Comments')

WebUI.delay(3)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/button_Save  Close'))

WebUI.delay(10)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/div_Adriana Pogoda'))

WebUI.delay(10)

WebUI.click(findTestObject('Rate Card Automation Test Case 3 Obj Repo/Page_Delivery Automation/span_Log Out'))

WebUI.closeBrowser()

