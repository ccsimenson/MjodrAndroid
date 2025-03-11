package com.ccsimenson.mjodr.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccsimenson.mjodr.data.BatchRepository
import com.ccsimenson.mjodr.data.BatchStatistics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatchStatisticsViewModel @Inject constructor(
    private val repository: BatchRepository
) : ViewModel() {

    private val _statistics = MutableStateFlow(BatchStatistics())
    val statistics: StateFlow<BatchStatistics> get() = _statistics

    fun loadStatistics(batchId: String) {
        viewModelScope.launch {
            _statistics.value = repository.getBatchStatistics(batchId)
        }
    }
}
