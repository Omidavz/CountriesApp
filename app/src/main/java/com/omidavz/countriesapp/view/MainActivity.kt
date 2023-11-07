package com.omidavz.countriesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.omidavz.countriesapp.R
import com.omidavz.countriesapp.databinding.ActivityMainBinding
import com.omidavz.countriesapp.databinding.ItemCountryBinding
import com.omidavz.countriesapp.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ListViewModel

    private val adapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.apply {
            countriesListRV.layoutManager = LinearLayoutManager(this@MainActivity)
            countriesListRV.adapter = adapter

            swipeRefreshLayout.setOnRefreshListener {
                swipeRefreshLayout.isRefreshing = false
                viewModel.refresh()

            }
        }


        observeViewModel()


    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { list ->
            list?.let {
                binding.countriesListRV.visibility = View.VISIBLE
                adapter.updateCountries(it)

            }
        })

        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let {
                binding.listError.visibility = if (it) View.VISIBLE else View.INVISIBLE
            }

        })

        viewModel.loading.observe(this, Observer { loading ->
            loading?.let {
                binding.apply {
                    loadingView.visibility = if (it) View.VISIBLE else View.INVISIBLE
                    if (it) {
                        listError.visibility = View.GONE
                        countriesListRV.visibility = View.GONE
                    }
                }
            }
        })

    }
}