package com.curso.comparar.compararapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.comparar.compararapp.model.Compare
import com.curso.comparar.compararapp.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Rule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun mainViewModel_valueResult() {

        val value = viewModel.compare.value?.result
        assertEquals(null, value)


    }

    @Test
    fun mainViewModel_compareTest() = runTest {
        launch {
            val cad1 = "Hola"
            val cad2 = "mundo"
            viewModel.compareStrings(cad1, cad2)
        }

        advanceUntilIdle()
        val res = viewModel.compare.value?.result
        assertEquals("Las cadenas son diferentes", res)
    }

}
