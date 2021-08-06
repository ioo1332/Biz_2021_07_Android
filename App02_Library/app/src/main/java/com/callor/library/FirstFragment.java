package com.callor.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.callor.library.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    // fragment_first.xml 을 Binding 하라는 의미가 된다
    // *.xml 파일이 마치 java class 가 된것처럼 코딩을 할수 있다
private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }




@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}