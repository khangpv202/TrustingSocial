package com.example.trustingsocialdemo.ui

import androidx.lifecycle.MutableLiveData
import com.example.basemodule.BaseViewModel
import com.example.trustingsocialdemo.network.OfferDTO
import com.example.trustingsocialdemo.repository.LoanRepository
import com.example.trustingsocialdemo.util.attachToModelDisposable

/**
 * Created by khangpv on 2019-07-07.
 * FinOs
 */
class LoanPlanViewModel(val loanRepository: LoanRepository) : BaseViewModel() {
    var userFormLiveData = MutableLiveData<Boolean>()
    val offerDTOLiveData = MutableLiveData<OfferDTO>()

    fun getOfferRemote() {
        loanRepository.getOffer()
            .compose(applySingleSchedulers())
            .subscribe({
                offerDTOLiveData.value = it
            }, {
                it.printStackTrace()
            }).attachToModelDisposable(this)
    }
}