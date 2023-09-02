package com.curso.comparar.compararapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.comparar.compararapp.model.Compare
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel : ViewModel() {

    private val _compare = MutableLiveData<Compare>()
    val compare: LiveData<Compare> get() = _compare


    fun compareStrings(cad1: String, cad2: String) {

        if (cad1 == cad2) {
            val result = "Las cadenas son iguales"
            updateCompare(result)
        } else {
            val result = "Las cadenas son diferentes"
            updateCompare(result)
        }


    }


    private fun updateCompare(result: String) {
        viewModelScope.launch {
            _compare.value = Compare(result)
        }
    }


}