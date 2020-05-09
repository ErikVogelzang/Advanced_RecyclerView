package com.example.advancedrecyclerview.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advancedrecyclerview.database.ColorRepository

class MainActivityViewModel : ViewModel() {
    private val colorRepository = ColorRepository()

    val colorItems = MutableLiveData<List<ColorItem>>().apply {
        value = colorRepository.getColorItems()
    }
}