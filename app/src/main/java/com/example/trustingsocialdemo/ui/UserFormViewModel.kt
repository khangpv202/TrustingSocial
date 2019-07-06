package com.example.trustingsocialdemo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trustingsocialdemo.util.validateFullName
import com.example.trustingsocialdemo.util.validateIdentity
import com.example.trustingsocialdemo.util.validateIncome
import com.example.trustingsocialdemo.util.validatePhone

class UserFormViewModel() : ViewModel() {
    var isOkPhoneNumber = false
    var isOkFullName = false
    var isOkProvince = false
    var isOkIncome = false
    var isOkIdentity = true
    val enableSubmitButtonLiveData = MutableLiveData<Boolean>()


    fun setPhoneValue(value: String) {
        isOkPhoneNumber = validatePhone(value)
        checkEnableSubmit()
    }

    private fun checkEnableSubmit() {
        enableSubmitButtonLiveData.value = isOkPhoneNumber && isOkFullName && isOkProvince && isOkIncome
    }

    fun setFullNameValue(value: String) {
        isOkFullName = validateFullName(value)
        checkEnableSubmit()
    }


    fun setIdentifyValue(value: String) {
        isOkIdentity = validateIdentity(value)
        checkEnableSubmit()
    }

    fun setIncomeValue(value: String) {
        isOkIncome = validateIncome(value)
        checkEnableSubmit()
    }


}
