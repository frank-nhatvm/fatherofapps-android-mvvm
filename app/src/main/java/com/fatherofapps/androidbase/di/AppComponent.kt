package com.fatherofapps.androidbase.di

import android.content.Context
import com.fatherofapps.androidbase.activities.MainActivity
import com.fatherofapps.androidbase.ui.cart.CartFragment
import com.fatherofapps.androidbase.ui.catalog.category.CategoryFragment
import com.fatherofapps.androidbase.ui.catalog.product.detail.ProductDetailFragment
import com.fatherofapps.androidbase.ui.catalog.product.listing.ProductListingFragment
import com.fatherofapps.androidbase.ui.checkout.CheckoutFragment
import com.fatherofapps.androidbase.ui.customer.address.AddressBookFragment
import com.fatherofapps.androidbase.ui.customer.changepassword.ChangePasswordFragment
import com.fatherofapps.androidbase.ui.customer.login.LoginFragment
import com.fatherofapps.androidbase.ui.customer.myaccount.MyAccountFragment
import com.fatherofapps.androidbase.ui.customer.myorders.MyOrdersFragment
import com.fatherofapps.androidbase.ui.customer.register.RegisterFragment
import com.fatherofapps.androidbase.ui.home.HomeFragment
import com.fatherofapps.androidbase.ui.search.SearchFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun injectSplashActivity(splashActivity: com.fatherofapps.androidbase.activities.SplashActivity)

    fun injectMainActivity(mainActivity: MainActivity)

    fun injectHomeFragment(fragment: HomeFragment)

    fun injectCartFragment(fragment: CartFragment)

    fun injectCategoryFragment(fragment: CategoryFragment)

    fun injectProductDetailFragment(fragment: ProductDetailFragment)

    fun injectProductListingFragment(fragment: ProductListingFragment)

    fun injectCheckoutFragment(fragment: CheckoutFragment)

    fun injectSearchFragment(fragment: SearchFragment)

    fun injectAddressBookFragment(fragment: AddressBookFragment)

    fun injectChangePasswordFragment(fragment: ChangePasswordFragment)

    fun injectLoginFragment(fragment: LoginFragment)

    fun injectMyAccountFragment(fragment: MyAccountFragment)

    fun injectMyOrdersFragment(fragment: MyOrdersFragment)

    fun injectRegisterFragment(fragment: RegisterFragment)


}