package com.example.trustingsocialdemo.network

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


/**
 * Created by khangpv on 2019-07-06.
 * FinOs
 */


data class BankDTO(
    @SerializedName("name") var name: String?,
    @SerializedName("logo") var logo: String?
)

data class OfferDTO(
    @SerializedName("min_amount")
    @Expose
    var minAmount: Int? = null,
    @SerializedName("max_amount")
    @Expose
    var maxAmount: Int? = null,
    @SerializedName("min_tenor")
    @Expose
    var minTenor: Int? = null,
    @SerializedName("max_tenor")
    @Expose
    var maxTenor: Int? = null,
    @SerializedName("interest_rate")
    @Expose
    var interestRate: Double? = null,
    @SerializedName("bank")
    @Expose
    var bank: BankDTO? = null
)

data class ProvinceDTO(
    @SerializedName("total")
    @Expose
    var total: Int? = null,
    @SerializedName("provinces_list")
    @Expose
    var provincesList: List<String>? = null
)

data class LoanRequestDTO(
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String? = null,
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null,
    @SerializedName("national_id_number")
    @Expose
    var nationalIdNumber: String? = null,
    @SerializedName("monthly_income")
    @Expose
    var monthlyIncome: Int? = null,
    @SerializedName("province")
    @Expose
    var province: String? = null
)

data class LoadResponseDTO(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String? = null,
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null,
    @SerializedName("national_id_number")
    @Expose
    var nationalIdNumber: String? = null,
    @SerializedName("monthly_income")
    @Expose
    var monthlyIncome: Int? = null,
    @SerializedName("province")
    @Expose
    var province: String? = null
)