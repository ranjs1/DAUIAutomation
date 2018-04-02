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

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, GlobalVariable.OPS, GlobalVariable.pwd)

CustomKeywords.'com.helper.commonfunct.commonutilities.CreateECR'(FileLocation, ORG, ACC, PL, RD, RL, PLTL, true, TestCaseno, 
    '\\Data Files\\ECR\\TestDataECR.xlsx', '')

CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

while (GlobalVariable.WOSTATUS.contains('PENDING')) {
    for (int j = 0; j < GlobalVariable.AssignmentList.size(); j++) {
        GlobalVariable.Status = GlobalVariable.AssignmentList[j].text

        println(GlobalVariable.Status)

        if (GlobalVariable.Status == 'Pending-RDApproval') {
            if (GlobalVariable.RDReject == false) {
                if (GlobalVariable.Meeting == true) {
                    CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                    CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                    CustomKeywords.'com.helper.commonfunct.commonutilities.routeToRL'()

                    print(GlobalVariable.Status)

                    CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
                } else {
                    CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                    CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                    CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()

                    CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
                }
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

                GlobalVariable.RDReject = false

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-RLApproval') {
            if (GlobalVariable.RLReject == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

                GlobalVariable.RLReject = false

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-RDDApproval') {
            if (GlobalVariable.RDD_Reject == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RDD, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RDD, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

                GlobalVariable.RDD_Reject = false

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

                println(GlobalVariable.Status)
            }
        } else if (GlobalVariable.Status == 'Pending-OPSApproval') {
            if (GlobalVariable.OpsReject == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, OPS, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.gsopsApprove'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, OPS, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.gsopsReject'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

                GlobalVariable.OpsReject = false
            }
        } else if (GlobalVariable.Status == 'Pending-ExpSvcApproval') {
            if (GlobalVariable.EXP_SVC_Reject == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, EXP, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, EXP, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

                GlobalVariable.EXP_SVC_Reject = false

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-DocUpdate') {
            if (GlobalVariable.Meeting == false) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.docUpdate'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

                WebUI.delay(3)
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                WebUI.maximizeWindow()

                CustomKeywords.'com.helper.commonfunct.commonutilities.docUpdateMeeting'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
            }
        } else if (GlobalVariable.Status == 'Pending-Contract') {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, PL, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            WebUI.maximizeWindow()

            CustomKeywords.'com.helper.commonfunct.commonutilities.ContractDisposition'()

            WebUI.waitForPageLoad(4)

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        } else if (GlobalVariable.Status == 'Pending-MeetingSchedule') {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, CLINIC, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            WebUI.maximizeWindow()

            CustomKeywords.'com.helper.commonfunct.commonutilities.scheduleMeeting'()

            WebUI.waitForPageLoad(4)

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        } else if (GlobalVariable.Status == 'Pending-ExpSvcReview') {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, EXP, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            WebUI.maximizeWindow()

            CustomKeywords.'com.helper.commonfunct.commonutilities.EXPReview'()

            WebUI.waitForPageLoad(4)

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.URL, RD, GlobalVariable.pwd)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            WebUI.maximizeWindow()

            CustomKeywords.'com.helper.commonfunct.commonutilities.pendingClinic'()

            WebUI.waitForPageLoad(4)

            CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
        }
    }
}

