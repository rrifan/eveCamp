package com.example.evecamp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataPendaftarFragment extends Fragment {
    Button downloadData;

    public DataPendaftarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_data_pendaftar, container, false);

        downloadData = view.findViewById(R.id.bDownloadDataPendaftar);

        downloadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Berhasil Download Data", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

}
