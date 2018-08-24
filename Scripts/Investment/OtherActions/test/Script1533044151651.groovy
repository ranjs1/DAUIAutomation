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
import com.sun.xml.internal.org.jvnet.mimepull.DataFile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.InternalData


int rowNo = 1

InternalData data = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K')

WebUI.openBrowser(findTestData('URL').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.delay(2)



'Fetching Work Object ID, OPS id, RD id, RL id, SVP id....'
//String woid = WebUI.getText(findTestObject('CommonDAObjectRepository/Page_Pega 7/WOID'))
String gsops_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(22, rowNo)
String rd_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(18, rowNo)
String rl_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(19, rowNo)
String pltl_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(20, rowNo)
String svp_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(21, rowNo)

String woid = 'INV-27Jul2018-17'
'Approve Investment Request as GSOPS'
CustomKeywords.'da.investment.investmentCommonAction.gsopsRecall'(woid,gsops_email)


rowNo++

WebUI.closeBrowser()


