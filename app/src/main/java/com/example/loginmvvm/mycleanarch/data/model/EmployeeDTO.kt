package com.example.loginmvvm.mycleanarch.data.model

import com.google.gson.annotations.SerializedName

data class EmployeeDTO (
    @SerializedName("id"       ) var id       : Int?     = null,
    @SerializedName("name"     ) var name     : String?  = null,
    @SerializedName("username" ) var username : String?  = null,
    @SerializedName("email"    ) var email    : String?  = null,
    @SerializedName("address"  ) var address  : AddressDTO? = AddressDTO(),
    @SerializedName("phone"    ) var phone    : String?  = null,
    @SerializedName("website"  ) var website  : String?  = null,
    @SerializedName("company"  ) var company  : CompanyDTO? = CompanyDTO()
)

data class GeoDTO (
    @SerializedName("lat" ) var lat : String? = null,
    @SerializedName("lng" ) var lng : String? = null
)
data class AddressDTO (
    @SerializedName("street"  ) var street  : String? = null,
    @SerializedName("suite"   ) var suite   : String? = null,
    @SerializedName("city"    ) var city    : String? = null,
    @SerializedName("zipcode" ) var zipcode : String? = null,
    @SerializedName("geo"     ) var geo     : GeoDTO?    = GeoDTO()

)

data class CompanyDTO (
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("catchPhrase" ) var catchPhrase : String? = null,
    @SerializedName("bs"          ) var bs          : String? = null

)