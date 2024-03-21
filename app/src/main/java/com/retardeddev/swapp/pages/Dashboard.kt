package com.retardeddev.swapp.pages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardeddev.swapp.api.NasaApiClient
import com.retardeddev.swapp.dataModel.CME
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _cmeList = MutableLiveData<List<CME>>()
    val cmeList: LiveData<List<CME>> = _cmeList

    fun fetchCMEs(startDate: String, endDate: String) {
        viewModelScope.launch {
            try {
                val result = NasaApiClient.service.fetchCMEs(startDate, endDate)
                _cmeList.value = result
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
