package com.example.trustingsocialdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.basemodule.BaseFragment
import com.example.trustingsocialdemo.R
import com.example.trustingsocialdemo.util.attachToDisposable
import com.jakewharton.rxbinding3.widget.afterTextChangeEvents
import kotlinx.android.synthetic.main.user_form_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFormFragment : BaseFragment() {
    val userFormViewModel:UserFormViewModel by  viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userFormViewModel.enableSubmitButtonLiveData.observe(this, Observer {
            if(it){

            }
        })

        bindUI()

    }

    private fun bindUI() {
        etPhone.afterTextChangeEvents().subscribe {
            userFormViewModel.setPhoneValue(it?.editable?.toString() ?: run { "" })
        }.attachToDisposable(this)

        etIdentity.afterTextChangeEvents().subscribe {
            userFormViewModel.setIdentifyValue(it?.editable?.toString() ?: run { "" })
        }.attachToDisposable(this)

        etIncome.afterTextChangeEvents().subscribe {
            userFormViewModel.setIncomeValue(it?.editable?.toString() ?: run { "" })
        }.attachToDisposable(this)

        etFullName.afterTextChangeEvents().subscribe {
            userFormViewModel.setFullNameValue(it?.editable?.toString() ?: run { "" })
        }.attachToDisposable(this)
    }
}
