package com.anavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _allServices= MutableLiveData<List<LifestyleServicesTypes>>().apply { value = getAllServices() }
    val allServices: LiveData<List<LifestyleServicesTypes>> = _allServices

    private fun getAllServices(): List<LifestyleServicesTypes> = LifestyleServicesTypes.getAllServices()

    fun removeService(type: String) {
        _allServices.value = _allServices.value!!.filter { it.type != type }
    }
}