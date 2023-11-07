package com.omidavz.countriesapp.service

import com.omidavz.countriesapp.di.DaggerApiComponent
import com.omidavz.countriesapp.model.Country
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesApi

    init {
        DaggerApiComponent.create().injectService(this)
    }
    fun getCountries(): Single<List<Country>>{
        return api.getCountries()
    }

}