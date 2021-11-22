package com.iamandiiana.newsreader.feature.newslist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.iamandiiana.newsreader.databinding.NewsListFragmentBinding;
import com.iamandiiana.newsreader.feature.newslist.model.NewsListViewModel;
import com.iamandiiana.newsreader.feature.newslist.model.factory.ViewModelFactory;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);

        getLifecycle().addObserver(mViewModel);
    }

}