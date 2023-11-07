package com.omidavz.countriesapp.di

import com.omidavz.countriesapp.service.CountriesService
import com.omidavz.countriesapp.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class ])
interface ApiComponent {


    fun injectService(service : CountriesService)

    fun injectToViewModel(listViewModel: ListViewModel)


}