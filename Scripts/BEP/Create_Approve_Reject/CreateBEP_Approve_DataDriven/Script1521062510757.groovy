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
import com.helper.commonfunct.commonutilities as CUTILS

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.Estimate'(Filepath, Org, Acc, PL, RD, RL, PLTL, OutputType, TestCaseno, 
    TestDataFileLocation, true)

CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

while (GlobalVariable.WOSTATUS.contains('PENDING')) {
    for (int j = 0; j < GlobalVariable.AssignmentList.size(); j++) {
        GlobalVariable.Status = GlobalVariable.AssignmentList[j].text

        println(GlobalVariable.Status)

        if (GlobalVariable.Status == 'Pending-RDApproval') {
            if (GlobalVariable.RDReject == false) {
                if (GlobalVariable.RouteToRL == true) {
                    CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                    CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                    CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RDapprove'()

                    CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
                } else {
                    CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                    CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                    CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.noToRL'()

                    CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
                }
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RDReject'()

                GlobalVariable.RDReject = false

                print(GlobalVariable.RDReject)

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-RLApproval') {
            if (GlobalVariable.RLReject == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLapprove'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLreject'()

                GlobalVariable.RLReject = false

                print(GlobalVariable.RLReject)

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-Update') {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.Update'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        } else if (GlobalVariable.Status == 'Completed') {
            println('check for apprpval')
        } else if (GlobalVariable.Status == 'Pending-Meeting') {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RL, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.RLapprove'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        } else if (GlobalVariable.Status == 'Pending-EmailCustomer') {
            if (GlobalVariable.SendEmail == true) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.EmailCustomer'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.SkipEmail'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, OPS, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.BEP_CommonMethod.GSOpsReview'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        }
    }
}

