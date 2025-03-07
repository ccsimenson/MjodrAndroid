package com.ccsimenson.mjodr

import com.ccsimenson.mjodr.navigation.NavGraphTest
import com.ccsimenson.mjodr.ui.components.VikingComponentsTest
import com.ccsimenson.mjodr.ui.screens.AbvCalculatorScreenTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Test suite that runs all Android instrumented tests for the Mjöðr application
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    NavGraphTest::class,
    VikingComponentsTest::class,
    AbvCalculatorScreenTest::class
)
class AndroidTestSuite
