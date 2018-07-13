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

CustomKeywords.'com.helper.commonfunct.commonutilities.login'(OPS)

CustomKeywords.'com.helper.commonfunct.commonutilities.CreateECR'(FileLocation, ORG, ACC, PL, RD, RL, PLTL, true, TestCaseno, 
    '\\Data Files\\ECR\\TestDataECR.xlsx', '')

CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()

while (GlobalVariable.WOSTATUS.contains('PENDING') && (GlobalVariable.AssignmentList.size() > 0)) {
    /*	for (int j = 0; j < GlobalVariable.AssignmentList.size(); j++) {*/
    GlobalVariable.Status = GlobalVariable.AssignmentList[0].text

    println(GlobalVariable.Status)

    /*
		CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
		
		int k=0
		while(GlobalVariable.AssignmentList[k].text!=GlobalVariable.Status)
		k++
		GlobalVariable.Status=GlobalVariable.AssignmentList[k].text*/
    if (GlobalVariable.Status == 'Pending-RDApproval') {
        if (GlobalVariable.RDReject == false) {
            if (GlobalVariable.Meeting == true) {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RD)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.routeToRL'()
            } else {
                CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RD)

                CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

                CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()
            }
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RD)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

            GlobalVariable.RDReject = false
        }
    } else if (GlobalVariable.Status == 'Pending-RLApproval') {
        if (GlobalVariable.RLReject == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RL)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RL)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

            GlobalVariable.RLReject = false
        }
    } else if (GlobalVariable.Status == 'Pending-RDDApproval') {
        if (GlobalVariable.RDD_Reject == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RDD)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RDD)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

            GlobalVariable.RDD_Reject = false
        }
    } else if (GlobalVariable.Status == 'Pending-OPSApproval') {
        if (GlobalVariable.OpsReject == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(OPS)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.gsopsApprove'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(OPS)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.gsopsReject'()

            GlobalVariable.OpsReject = false
        }
    } else if (GlobalVariable.Status == 'Pending-ExpSvcApproval') {
        if (GlobalVariable.EXP_SVC_Reject == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

            GlobalVariable.EXP_SVC_Reject = false
        }
    } else if (GlobalVariable.Status == 'Pending-SpApprApproval') {
        if (GlobalVariable.EXP_SVC_Reject == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.approve'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.reject'()

            GlobalVariable.EXP_SVC_Reject = false
        }
    } else if (GlobalVariable.Status == 'Pending-DocUpdate') {
        if (GlobalVariable.Meeting == false) {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(PL)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.docUpdate'()
        } else {
            CustomKeywords.'com.helper.commonfunct.commonutilities.login'(PL)

            CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

            CustomKeywords.'com.helper.commonfunct.commonutilities.docUpdateMeeting'()
        }
    } else if (GlobalVariable.Status == 'Pending-Contract') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(PL)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.ContractDisposition'()

        not_run: CustomKeywords.'com.helper.commonfunct.commonutilities.readWO'(TestCaseno, TestDataFile)

        GlobalVariable.WOSTATUS == 'Resolved-won'
    } else if (GlobalVariable.Status == 'Pending-MeetingSchedule') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(CLINIC)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.scheduleMeeting'()
    } else if (GlobalVariable.Status == 'Pending-RDDReview') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RDD)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.docUpdateMeeting'()
    } else if (GlobalVariable.Status == 'Pending-OPSReview') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(OPS)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.gsopsReview'()
    } else if (GlobalVariable.Status == 'Pending-ExpSvcReview') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.EXPReview_RDDReview_SPReview'()
    } else if (GlobalVariable.Status == 'Pending-SpRevReview') {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(GlobalVariable.EXP_SVC)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.EXPReview_RDDReview_SPReview'()
    } else {
        CustomKeywords.'com.helper.commonfunct.commonutilities.login'(RD)

        CustomKeywords.'com.helper.commonfunct.commonutilities.search'()

        CustomKeywords.'com.helper.commonfunct.commonutilities.pendingClinic'()
    }
    
    /* }for loop end braces */
    CustomKeywords.'com.helper.commonfunct.commonutilities.searchStatus'()
}

