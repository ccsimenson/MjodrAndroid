package com.ccsimenson.mjodr.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ccsimenson.mjodr.ui.components.BatchStatisticsScreen
import com.ccsimenson.mjodr.data.BatchStatistics
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BatchStatisticsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBatchStatisticsScreenDisplaysCorrectData() {
        val statistics = BatchStatistics(totalMeasurements = 5, daysFermenting = 10, abvTrend = listOf(5.0, 6.0, 7.0), temperatureTrend = listOf(20.0, 21.0, 22.0))

        composeTestRule.setContent {
            BatchStatisticsScreen(batchId = "testBatchId")
        }

        // Check if the total measurements are displayed correctly
        composeTestRule.onNodeWithText("Total Measurements: 5").assertIsDisplayed()

        // Check if the days fermenting are displayed correctly
        composeTestRule.onNodeWithText("Days Fermenting: 10").assertIsDisplayed()

        // Check if the ABV trend chart is displayed
        composeTestRule.onNodeWithText("ABV Trend").assertIsDisplayed()

        // Check if the Temperature trend chart is displayed
        composeTestRule.onNodeWithText("Temperature Trend").assertIsDisplayed()
    }
}
