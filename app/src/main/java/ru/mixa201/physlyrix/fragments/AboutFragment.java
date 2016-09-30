package ru.mixa201.physlyrix.fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ru.mixa201.physlyrix.R;

/**
 * Created by 79114 on 27.09.2016.
 */
public class AboutFragment extends Fragment {
    private ImageView phys;
    private SoundPool sp;
    private int purring;
    public AboutFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.about_fragment,container,false);
        phys=(ImageView)view.findViewById(R.id.imageView);
        sp=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        purring=sp.load(getContext(),R.raw.purring,1);
        phys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(purring,1,1,0,0,1);
            }
        });
        return view;
    }
}
