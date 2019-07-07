package com.example.trustingsocialdemo.repository

import com.example.trustingsocialdemo.network.OfferDTO
import com.example.trustingsocialdemo.network.ProvinceDTO
import com.example.trustingsocialdemo.network.URLService
import io.reactivex.Single

/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */
class LoanRepository(val urlService: URLService) {
    fun getProvinces(): Single<ProvinceDTO> {
//        return urlService.getProvinces()
        return FakeData.createProvince()
    }

    fun getOffer():Single<OfferDTO>{
//        return  urlService.getOffer()
        return  FakeData.createOfferDTO()
    }

}