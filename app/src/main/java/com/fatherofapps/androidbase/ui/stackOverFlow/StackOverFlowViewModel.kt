package com.fatherofapps.androidbase.ui.stackOverFlow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fatherofapps.androidbase.base.viewmodel.BaseViewModel
import com.fatherofapps.androidbase.data.models.Question
import com.fatherofapps.androidbase.data.repositories.StackOverFlowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StackOverFlowViewModel @Inject constructor(private val stackOverFlowRepository: StackOverFlowRepository) : BaseViewModel() {

    private var   _listQuestions = MutableLiveData<List<Question>?>()
     val listQuestions:LiveData<List<Question>?>
    get() = _listQuestions

    private var page = 1
    private var pageSize = 2

    override fun fetchData() {
        showLoading(true)
        parentJob = viewModelScope.launch(handler) {
            val questions = stackOverFlowRepository.getQuestion(page, pageSize)
            _listQuestions.postValue(questions.items)
        }
        registerJobFinish()
    }
}