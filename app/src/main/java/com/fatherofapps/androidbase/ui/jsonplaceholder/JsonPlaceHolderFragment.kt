package com.fatherofapps.androidbase.ui.jsonplaceholder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fatherofapps.androidbase.base.fragment.BaseFragment
import com.fatherofapps.androidbase.databinding.FragmentJsonPlaceHolderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JsonPlaceHolderFragment : BaseFragment() {

    private val viewModel by viewModels<JsonPlaceHolderViewModel>()
    private lateinit var dataBinding: FragmentJsonPlaceHolderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentJsonPlaceHolderBinding.inflate(inflater)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registerAllExceptionEvent(viewModel,viewLifecycleOwner)
        registerObserverLoadingEvent(viewModel,viewLifecycleOwner)

        viewModel.listPosts.observe(viewLifecycleOwner){
            post ->
            if(post?.isNotEmpty() == true){
                val listTitle = post.map { "${it.title} \n" }
                dataBinding.tvResult.text = listTitle.toString()
            }
        }

    }


}