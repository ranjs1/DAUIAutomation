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
import com.helper.commonfunct.commonutilities as CUTILS

while (GlobalVariable.WOSTATUS.contains('PENDING') && (GlobalVariable.AssignmentList.size() > 0)) {
   /* for (int j = 0; j < GlobalVariable.AssignmentList.size(); j++) {*/
		GlobalVariable.Status = GlobalVariable.AssignmentList[0].text

		println(GlobalVariable.Status)

		if (GlobalVariable.Status == 'Pending-RDApproval') {
			if (GlobalVariable.RDReject == false) {
				if (GlobalVariable.RouteToRL == true) {
					CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RD)

					CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

					CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RDapprove'()

					
				} else {
					CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RD)

					CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

					CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.noToRL'()

					
				}
			} else {
				CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RD)

				CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

				CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RDReject'()

				GlobalVariable.RDReject = false

				print(GlobalVariable.RDReject)

				
			}
		} else if (GlobalVariable.Status == 'Pending-RLApproval') {
			if (GlobalVariable.RLReject == false) {
				CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RL)

				CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

				CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLapprove'()

				
			} else {
				CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RL)

				CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

				CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLreject'()

				GlobalVariable.RLReject = false

				print(GlobalVariable.RLReject)

				
			}
		} else if (GlobalVariable.Status == 'Pending-Update') {
			CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.PL)

			CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

			CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.Update'()

			
		} else if (GlobalVariable.Status == 'Completed') {
			println('check for apprpval')
		} else if (GlobalVariable.Status == 'Pending-Meeting') {
			CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.RL)

			CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

			CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLapprove'()

			
		} else if (GlobalVariable.Status == 'Pending-EmailCustomer') {
			if (GlobalVariable.SendEmail == true) {
				CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.PL)

				CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

				CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.EmailCustomer'()

				
			} else {
				CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.PL)

				CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

				CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.SkipEmail'()

				
			}
		} else {
			CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.OPS)

			CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

			CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.GSOpsReview'()

			
		}
   /* }for loop end braces */
	CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
}


