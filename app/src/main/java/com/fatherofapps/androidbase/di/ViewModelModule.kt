package com.fatherofapps.androidbase.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.fatherofapps.androidbase.ui.home.HomeViewModel
import com.fatherofapps.androidbase.ui.customer.address.AddressBookViewModel
import com.fatherofapps.androidbase.ui.customer.changepassword.ChangePasswordViewModel
import com.fatherofapps.androidbase.ui.customer.login.LoginViewModel
import com.fatherofapps.androidbase.ui.customer.myaccount.MyAccountViewModel
import com.fatherofapps.androidbase.ui.customer.myorders.MyOrdersViewModel
import com.fatherofapps.androidbase.ui.customer.register.RegisterViewModel
import com.fatherofapps.androidbase.ui.search.SearchViewModel


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddressBookViewModel::class)
    abstract fun bindAddressBookViewModel(viewModel: AddressBookViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChangePasswordViewModel::class)
    abstract fun bindChangePasswordViewModel(viewModel: ChangePasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyAccountViewModel::class)
    abstract fun bindMyAccountViewModel(viewModel: MyAccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyOrdersViewModel::class)
    abstract fun bindMyOrdersViewModel(viewModel: MyOrdersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

}