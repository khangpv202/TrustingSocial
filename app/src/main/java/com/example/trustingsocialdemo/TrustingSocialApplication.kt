package com.example.trustingsocialdemo

import android.app.Application
import com.example.trustingsocialdemo.di.networkModule
import com.example.trustingsocialdemo.di.viewModelModule
import com.example.trustingsocialdemo.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
class TrustingSocialApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TrustingSocialApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}