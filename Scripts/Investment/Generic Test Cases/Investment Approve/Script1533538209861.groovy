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
import com.sun.xml.internal.org.jvnet.mimepull.DataFile as DataFile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.InternalData as InternalData


WebUI.openBrowser(findTestData('URL').getValue(1, 1))

WebUI.maximizeWindow()

'Login as Practice Leader'
CustomKeywords.'da.common.methods.CommonActionsInDA.loginDA'(findTestData('Role-UserName-Password').getValue(2, 2), findTestData(
        'Role-UserName-Password').getValue(3, 2))

String woid = 'INV-03Jul2018-4'

CustomKeywords.'da.common.methods.CommonActionsInDA.searchWO'(woid)

String wostatus = WebUI.getText(findTestObject('Object Repository/InvestmentObjectRepository/status'))

WebUI.comment('Investment Work Object Status is = ' + wostatus)

InternalData data = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K')
String rowNo = 1
String gsops_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(22, rowNo)
String rd_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(18, rowNo)
String rl_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(19, rowNo)
String pltl_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(20, rowNo)
String svp_email = findTestData('Investment/Test-Data-For-Inv-Value-More-Than-100K').getValue(21, rowNo)

while (wostatus != 'RESOLVED-APPROVED') {
    if (wostatus == 'Pending-OPSApproval') {
        WebUI.comment('I AM IN OPS APPROVAL LOOP')
        CustomKeywords.'da.investment.investmentCommonAction.gsopsApproval'(woid,rowNo )
		} 
	else if (wostatus == 'Pending-RDApproval') {
        WebUI.comment('I AM IN RD APPROVAL Stage')
        CustomKeywords.'da.investment.investmentCommonAction.rdApproval'(woid,rowNo )
        }
	
	else if (wostatus == 'Pending-RLApproval') {
		WebUI.comment('I AM IN RL APPROVAL Stage')
		CustomKeywords.'da.investment.investmentCommonAction.rlApproval'(woid,rowNo )
	}
	
	else if (wostatus == 'Pending-PLTLApproval') {
		WebUI.comment('I AM IN RL APPROVAL Stage')
		CustomKeywords.'da.investment.investmentCommonAction.pltlApproval'(woid,rowNo )
	}
	
	else if (wostatus == 'Pending-SVPApproval') {
		WebUI.comment('I AM IN SVP APPROVAL Stage')
		CustomKeywords.'da.investment.investmentCommonAction.svpApproval'(woid,rowNo )
	}
		
}

