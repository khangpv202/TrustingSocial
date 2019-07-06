package com.example.basemodule

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class BaseFragment : Fragment() {
    private var compositeDisposable = CompositeDisposable()
    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}
