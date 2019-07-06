package com.example.trustingsocialdemo.util

import com.example.basemodule.BaseFragment
import io.reactivex.disposables.Disposable

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
fun Disposable.attachToDisposable(baseFragment: BaseFragment) {
    baseFragment.addDisposable(this)
}