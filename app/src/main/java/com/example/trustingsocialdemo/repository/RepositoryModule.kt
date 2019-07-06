package com.example.trustingsocialdemo.repository

import org.koin.dsl.module

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */

val repositoryModule = module {
    single { LoanRepository(get()) }
}