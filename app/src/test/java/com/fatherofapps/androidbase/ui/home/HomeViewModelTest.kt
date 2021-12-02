package com.fatherofapps.androidbase.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fatherofapps.androidbase.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Rule

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()



//    @Test
//    fun fetchData_loading() = mainCoroutineRule.dispatcher.runBlockingTest {
//        mainCoroutineRule.dispatcher.pauseDispatcher()
//        Mockito.`when`(cartRepository.getCartItems()).thenReturn(getListCartItems())
//        Mockito.`when`(cartRepository.getTotal()).thenReturn(getTotal())
//        cartViewModel.fetchData()
//        Truth.assertThat(cartViewModel.isLoading.getOrAwaitValue().getContentIfNotHandled())
//            .isTrue()
//        mainCoroutineRule.dispatcher.resumeDispatcher()
//        Truth.assertThat(cartViewModel.isLoading.getOrAwaitValue().getContentIfNotHandled())
//            .isFalse()
//    }

}