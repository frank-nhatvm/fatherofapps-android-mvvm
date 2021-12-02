package com.fatherofapps.androidbase.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fatherofapps.androidbase.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule


@ExperimentalCoroutinesApi
class CustomerRepositoryTest{
    @get:Rule
    var mainCoroutinesApi = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

//    @Before
//    fun init() {
//        cartService = Mockito.mock(CartService::class.java)
//        appSharePreference = Mockito.mock(AppSharePreference::class.java)
//        productService = Mockito.mock(ProductService::class.java)
//
//        cartRepository =
//            CartRepository(cartService, appSharePreference, productService, Dispatchers.Main)
//    }
//
//
//    @Test
//    fun createEmptyCart_loggedIn_calls_createEmptyCartForCustomerOfCartService() =
//        mainCoroutinesApi.dispatcher.runBlockingTest {
//            DataLocal.IS_LOGGED_IN = true
//            Mockito.`when`(cartService.createEmptyCartForCustomer())
//                .thenReturn(NetworkResult.Success("0235"))
//            cartRepository.createEmptyCart()
//            Mockito.verify(cartService).createEmptyCartForCustomer()
//        }
//@Test
//fun createEmptyCart_forCustomerFail_throwsAnException() =
//    mainCoroutinesApi.dispatcher.runBlockingTest {
//        DataLocal.IS_LOGGED_IN = true
//        val exception = BaseNetworkException()
//        Mockito.`when`(cartService.createEmptyCartForCustomer())
//            .thenReturn(NetworkResult.Error(exception))
//        try {
//            cartRepository.createEmptyCart()
//        } catch (e: Exception) {
//            Truth.assertThat(e).isNotNull()
//        }
//    }


}