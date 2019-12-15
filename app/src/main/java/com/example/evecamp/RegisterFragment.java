package com.example.evecamp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    Button regisEvent;
    EditText nama;
    EditText email;
    EditText no_hp;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        nama = (EditText)view.findViewById(R.id.nama);
        email = (EditText)view.findViewById(R.id.email) ;
        no_hp = (EditText)view.findViewById(R.id.no_hp) ;
        regisEvent = (Button)view.findViewById(R.id.registEvent);

        regisEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama.length() == 0 && email.length() == 0 && no_hp.length() == 0) {
                    Toast.makeText(getActivity(), "Semua form wajib di isi", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Berhasil mendaftar", Toast.LENGTH_LONG).show();
                    HomeFragment homeFragment= new HomeFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, homeFragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }

}
