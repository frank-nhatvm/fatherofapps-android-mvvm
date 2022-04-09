package com.fatherofapps.androidbase.ui.stackOverFlow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fatherofapps.androidbase.base.fragment.BaseFragment
import com.fatherofapps.androidbase.databinding.FragmentStackOverFlowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StackOverFlowFragment : BaseFragment() {
    private val viewModel by viewModels<StackOverFlowViewModel> (
            )

    private lateinit var dataBinding: FragmentStackOverFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentStackOverFlowBinding.inflate(inflater)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registerAllExceptionEvent(viewModel,viewLifecycleOwner)
        registerObserverLoadingEvent(viewModel,viewLifecycleOwner)
        viewModel.listQuestions.observe(viewLifecycleOwner){
            questions ->
            if(questions?.isNotEmpty() == true){
                val titles = questions.map { "${it.title} \n" }
                dataBinding.tvResult.text = titles.toString()
            }
        }
    }


}