package com.omidavz.countriesapp.service

import com.omidavz.countriesapp.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries() : Single<List<Country>>

}