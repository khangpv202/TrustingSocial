package com.example.trustingsocialdemo.di

import com.example.trustingsocialdemo.ui.UserFormViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */

val viewModelModule = module {
    viewModel { UserFormViewModel() }
}