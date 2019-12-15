package com.example.evecamp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    View view;
    ImageButton imageButton;
    ImageView imgEvent4;
    TextView txtEvent4;
    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_event,container,false);

        imgEvent4= view.findViewById(R.id.imgEvent4);
        imgEvent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataPendaftarFragment dataPendaftar= new DataPendaftarFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, dataPendaftar );
                fragmentTransaction.commit();
            }
        });

        txtEvent4= view.findViewById(R.id.txtEvent4);
        txtEvent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataPendaftarFragment dataPendaftar1= new DataPendaftarFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, dataPendaftar1);
                fragmentTransaction.commit();
            }
        });

        imageButton= view.findViewById(R.id.img_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddeventFragment addEvent= new AddeventFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, addEvent);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
