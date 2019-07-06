package com.example.trustingsocialdemo.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
interface URLService {
    @GET("/offer")
    fun getOffer(): Single<OfferDTO>

    @GET("/provinces")
    fun getProvinces(): Single<ProvinceDTO>

    @POST("/loans")
    fun requestLoan(@Body loan: LoanRequestDTO): Single<LoadResponseDTO>
}