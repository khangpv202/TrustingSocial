package com.example.trustingsocialdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.trustingsocialdemo.R
import kotlinx.android.synthetic.main.loan_detail_item.*
import kotlinx.android.synthetic.main.loan_plan_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoanPlanActivity : AppCompatActivity() {
    val loadPlanViewModel: LoanPlanViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loan_plan_activity)
        loadPlanViewModel.userFormLiveData.observe(this, Observer {
            btSubmit.isEnabled = it
        })
        loadPlanViewModel.getOfferRemote()
        loadPlanViewModel.offerDTOLiveData.observe(this, Observer { dto ->
            dto?.let { offerDTO ->
                tvMinMaxAmount.text = "${offerDTO.minAmount}/${offerDTO.maxAmount}"
                tvMinMaxTenor.text = "${offerDTO.minTenor}/${offerDTO.maxTenor}"
                tvInterestValue.text = "${offerDTO.interestRate}"
                offerDTO.bank?.let {
                    tvBankName.text = it.name
                    Glide.with(this).load(it.logo)
                        .into(ivBankLogo)
                }
            }
        })
    }
}
