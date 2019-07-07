package com.example.trustingsocialdemo.ui

import androidx.lifecycle.MutableLiveData
import com.example.basemodule.BaseViewModel
import com.example.trustingsocialdemo.repository.LoanRepository
import com.example.trustingsocialdemo.util.*

class UserFormViewModel(val loandRepository: LoanRepository) : BaseViewModel() {
    var isOkPhoneNumber = false
    var isOkFullName = false
    var isOkProvince = true
    var isOkIncome = false
    var isOkIdentity = true
    var province: String? = null
    val enableSubmitButtonLiveData = MutableLiveData<Boolean>()
    val provinceListLiveData = MutableLiveData<List<String>>()

    fun setPhoneValue(value: String) {
        isOkPhoneNumber = validatePhone(value)
        checkEnableSubmit()
    }

    fun setProvinceValue(value: String) {
        isOkProvince = validateProvince(value)
        province = value
        checkEnableSubmit()
    }

    private fun checkEnableSubmit() {
        enableSubmitButtonLiveData.value = isOkPhoneNumber && isOkFullName && isOkIdentity && isOkIncome && isOkProvince
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

    fun getProvinceRemote() {
        loandRepository.getProvinces()
            .compose(applySingleSchedulers())
            .subscribe({
                provinceListLiveData.value = it.provincesList
            }, {
                it.printStackTrace()
            }).attachToModelDisposable(this)
    }

}
