package com.example.trustingsocialdemo.util

import com.example.basemodule.BaseFragment
import com.example.basemodule.BaseViewModel
import io.reactivex.disposables.Disposable

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
fun Disposable.attachToFragDisposable(baseFragment: BaseFragment) {
    baseFragment.addDisposable(this)
}

fun Disposable.attachToModelDisposable(viewModel: BaseViewModel) {
    viewModel.addDisposable(this)
}