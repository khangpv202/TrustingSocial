package com.example.trustingsocialdemo.repository

import com.example.trustingsocialdemo.network.BankDTO
import com.example.trustingsocialdemo.network.OfferDTO
import com.example.trustingsocialdemo.network.ProvinceDTO
import io.reactivex.Single
import java.math.BigDecimal

/**
 * Created by khangpv on 2019-07-07.
 * FinOs
 */

class FakeData {
    companion object {
        fun createProvince(): Single<ProvinceDTO> {
            val provinceDTO = ProvinceDTO()
            provinceDTO.total = 10
            provinceDTO.provincesList = listOf(
                "An Giang",
                "Bắc Giang",
                "Bắc Kạn",
                "Bạc Liêu",
                "Bắc Ninh",
                "Bà Rịa - Vũng Tàu",
                "Bến Tre",
                "Bình Định",
                "Bình Dương",
                "Bình Phước"
            )
            return Single.just(provinceDTO)

        }

        fun createOfferDTO(): Single<OfferDTO> {
            val offerDTO = OfferDTO()
            offerDTO.minAmount = BigDecimal(3000000)
            offerDTO.maxAmount = BigDecimal(100000000)
            offerDTO.minTenor = 6
            offerDTO.maxTenor = 18
            offerDTO.interestRate = 19.99
            val bankDTO = BankDTO()
            bankDTO.logo = "https://www.vietcombank.com.vn/images/logo30.png"
            bankDTO.name = "Vietcombank"
            offerDTO.bank = bankDTO
            return Single.just(offerDTO)
        }
    }
}