package ru.mixa201.physlyrix.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mixa201.physlyrix.LauncherActivity;
import ru.mixa201.physlyrix.R;
import ru.mixa201.physlyrix.StatisticActivity;

/**
 * Created by 79114 on 27.09.2016.
 */
public class StatisticsFragment extends Fragment {
    public StatisticsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.statistics_fragment,container,false);
        Button start=(Button)view.findViewById(R.id.btStart_statistics);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("APP_PATH", LauncherActivity.APP_PATH);
                i.setClass(getContext(), StatisticActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
