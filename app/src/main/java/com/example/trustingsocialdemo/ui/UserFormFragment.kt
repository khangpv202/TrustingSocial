package com.example.trustingsocialdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.basemodule.BaseFragment
import com.example.trustingsocialdemo.R

class UserFormFragment : BaseFragment() {

    companion object {
        fun newInstance() = UserFormFragment()
    }

    private lateinit var viewModel: UserFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserFormViewModel::class.java)
    }

}
