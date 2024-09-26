package com.example.assignment9.flag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment9.network.Countries
import com.example.assignment9.network.CountriesContainer
import com.example.assignment9.network.FlagApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FlagViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _countries = MutableLiveData<CountriesContainer>()
    val countries : LiveData<CountriesContainer>
        get() = _countries

    init {
        getFromApi()
    }

    private fun getFromApi() {
        coroutineScope.launch {
            println("inside coroutine")
            val fromApi = FlagApi.retrofitService.getCountries()
            try {
                val temp = fromApi.await()
                _countries.value = temp
                println(_countries.value!!.data)
            } catch (e: Exception) {
                println("${e.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}