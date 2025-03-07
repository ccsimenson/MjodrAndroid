package com.ccsimenson.mjodr.ui.viewmodels

import com.ccsimenson.mjodr.data.YoutubeRepository
import com.ccsimenson.mjodr.data.YoutubeVideo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class RecipesViewModelTest {
    
    private lateinit var viewModel: RecipesViewModel
    private lateinit var mockRepository: YoutubeRepository
    private val testDispatcher = StandardTestDispatcher()
    
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockRepository = mock()
        viewModel = RecipesViewModel(mockRepository)
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `loadDefaultRecipes should update search results`() = runTest {
        // Given
        val mockVideos = listOf(
            YoutubeVideo("1", "Traditional Mead Recipe", "Viking Brewer", "thumbnail1.jpg", "https://youtube.com/watch?v=1"),
            YoutubeVideo("2", "Sweet Mead Tutorial", "Meadery", "thumbnail2.jpg", "https://youtube.com/watch?v=2")
        )
        whenever(mockRepository.searchVideos(any(), any())).thenReturn(Result.success(mockVideos))
        
        // When
        viewModel.loadDefaultRecipes()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val results = viewModel.searchResults.first()
        assertEquals(2, results.size)
        assertEquals("Traditional Mead Recipe", results[0].title)
        assertEquals("Sweet Mead Tutorial", results[1].title)
    }
    
    @Test
    fun `searchRecipes should update search results with query`() = runTest {
        // Given
        val mockVideos = listOf(
            YoutubeVideo("3", "Viking Mead Recipe", "Norse Brewer", "thumbnail3.jpg", "https://youtube.com/watch?v=3")
        )
        viewModel.updateSearchQuery("Viking Mead")
        whenever(mockRepository.searchVideos(any(), any())).thenReturn(Result.success(mockVideos))
        
        // When
        viewModel.searchRecipes()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val results = viewModel.searchResults.first()
        assertEquals(1, results.size)
        assertEquals("Viking Mead Recipe", results[0].title)
    }
    
    @Test
    fun `searchRecipes should handle errors`() = runTest {
        // Given
        whenever(mockRepository.searchVideos(any(), any())).thenReturn(Result.failure(Exception("API Error")))
        
        // When
        viewModel.searchRecipes()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        assertTrue(viewModel.searchResults.first().isEmpty())
        assertEquals("Failed to load recipes: API Error", viewModel.errorMessage)
    }
    
    @Test
    fun `loadNextPage should append new results`() = runTest {
        // Given
        val initialVideos = listOf(
            YoutubeVideo("1", "Traditional Mead Recipe", "Viking Brewer", "thumbnail1.jpg", "https://youtube.com/watch?v=1")
        )
        val nextPageVideos = listOf(
            YoutubeVideo("2", "Sweet Mead Tutorial", "Meadery", "thumbnail2.jpg", "https://youtube.com/watch?v=2")
        )
        
        // Set up initial results
        whenever(mockRepository.searchVideos(any(), any())).thenReturn(Result.success(initialVideos))
        viewModel.searchRecipes()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Set up next page results
        whenever(mockRepository.searchVideos(any(), any())).thenReturn(Result.success(nextPageVideos))
        
        // When
        viewModel.loadNextPage()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val results = viewModel.searchResults.first()
        assertEquals(2, results.size)
        assertEquals("Traditional Mead Recipe", results[0].title)
        assertEquals("Sweet Mead Tutorial", results[1].title)
    }
}
