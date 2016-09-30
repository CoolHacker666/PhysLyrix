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
import ru.mixa201.physlyrix.PackageView;
import ru.mixa201.physlyrix.R;

/**
 * Created by 79114 on 27.09.2016.
 */
public class QuestionnaryFragment extends Fragment {
    public QuestionnaryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.questionnary_fragment,container,false);
        Button start=(Button)view.findViewById(R.id.btStart_quest);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("MANIFEST", LauncherActivity.APP_PATH + "questionary.db");
                i.putExtra("ACTION","quests");
                i.setClass(getContext(), PackageView.class);
                startActivity(i);
            }
        });
        return view;
    }
}
