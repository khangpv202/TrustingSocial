package com.example.trustingsocialdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.basemodule.BaseFragment
import com.example.trustingsocialdemo.R
import com.example.trustingsocialdemo.util.attachToFragDisposable
import com.jakewharton.rxbinding3.widget.afterTextChangeEvents
import kotlinx.android.synthetic.main.user_form_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserFormFragment : BaseFragment() {
    private val loadPlanViewModel: LoanPlanViewModel by sharedViewModel()
    private val userFormViewModel: UserFormViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_form_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userFormViewModel.enableSubmitButtonLiveData.observe(this, Observer {
            loadPlanViewModel.userFormLiveData.value = it
        })
        userFormViewModel.getProvinceRemote()
        userFormViewModel.provinceListLiveData.observe(this, Observer { list ->
            list?.let {
                provinceSpinner.setItems(it)
            }
        })

        bindUI()

    }

    private fun bindUI() {
        etPhone.afterTextChangeEvents().subscribe {
            userFormViewModel.setPhoneValue(it?.editable?.toString() ?: run { "" })
        }.attachToFragDisposable(this)

        etIdentity.afterTextChangeEvents().subscribe {
            userFormViewModel.setIdentifyValue(it?.editable?.toString() ?: run { "" })
        }.attachToFragDisposable(this)

        etIncome.afterTextChangeEvents().subscribe {
            userFormViewModel.setIncomeValue(it?.editable?.toString() ?: run { "" })
        }.attachToFragDisposable(this)

        etFullName.afterTextChangeEvents().subscribe {
            userFormViewModel.setFullNameValue(it?.editable?.toString() ?: run { "" })
        }.attachToFragDisposable(this)



        provinceSpinner.setOnItemSelectedListener { view, position, id, item ->
            Toast.makeText(activity, "clicked: $item", Toast.LENGTH_SHORT).show()
            userFormViewModel.setProvinceValue(item.toString())
        }
    }
}
