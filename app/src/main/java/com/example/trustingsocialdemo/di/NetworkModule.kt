package com.example.trustingsocialdemo.di

import android.content.Context
import com.example.trustingsocialdemo.R
import com.example.trustingsocialdemo.network.URLService
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
val networkModule = module {
    single { provideDefaultOkhttpClient() }
    single { provideRetrofit(androidContext(), get()) }
    single { provideUrlService(get()) }
}


private fun provideDefaultOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
//            .addInterceptor(ApiKeyInterceptor())
        .build()
}

private fun provideRetrofit(context: Context, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(context.getString(R.string.baseURL))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideUrlService(retrofit: Retrofit): URLService = retrofit.create(URLService::class.java)

