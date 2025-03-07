package com.ccsimenson.mjodr

import com.ccsimenson.mjodr.navigation.NavDestinationTest
import com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModelTest
import com.ccsimenson.mjodr.ui.viewmodels.MeadHallViewModelTest
import com.ccsimenson.mjodr.ui.viewmodels.RecipesViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Test suite that runs all unit tests for the Mjöðr application
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    AbvCalculatorViewModelTest::class,
    NavDestinationTest::class,
    RecipesViewModelTest::class,
    MeadHallViewModelTest::class
)
class TestSuite
