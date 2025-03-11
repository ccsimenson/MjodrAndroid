package com.ccsimenson.mjodr.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ccsimenson.mjodr.data.BatchRepository
import com.ccsimenson.mjodr.data.BatchStatistics
import com.ccsimenson.mjodr.ui.viewmodels.BatchStatisticsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class BatchStatisticsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BatchStatisticsViewModel
    private lateinit var repository: BatchRepository
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = Mockito.mock(BatchRepository::class.java)
        viewModel = BatchStatisticsViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test loadStatistics updates statistics correctly`() = runBlocking {
        val batchId = "testBatchId"
        val expectedStatistics = BatchStatistics(totalMeasurements = 5, daysFermenting = 10)
        whenever(repository.getBatchStatistics(batchId)).thenReturn(expectedStatistics)

        viewModel.loadStatistics(batchId)

        assertEquals(expectedStatistics, viewModel.statistics.value)
    }
}
