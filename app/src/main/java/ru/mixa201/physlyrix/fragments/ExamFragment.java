package ru.mixa201.physlyrix.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mixa201.physlyrix.R;

/**
 * Created by 79114 on 27.09.2016.
 */
public class ExamFragment extends Fragment {
    public ExamFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.exam_fragment,container,false);
        return view;
    }
}
