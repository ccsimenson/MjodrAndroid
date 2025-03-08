package com.ccsimenson.mjodr.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for creating ViewModels that require an Application context
 */
class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TraditionalRecipesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TraditionalRecipesViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
