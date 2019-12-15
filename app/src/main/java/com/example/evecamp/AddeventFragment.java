package com.example.evecamp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddeventFragment extends Fragment {
    private static final int RESULT_LOAD_IMAGE = 1;

    ImageView imageView;
    Button bUpload;
    Button bAddEvent;
    EditText nama_acara;
    EditText deskripsi_acara;

    public AddeventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_event, container, false);

        imageView= view.findViewById(R.id.imageView);
        bUpload= view.findViewById(R.id.bUpload);
        bAddEvent = (Button) view.findViewById(R.id.addEvent);
        nama_acara = (EditText)view.findViewById(R.id.nama_acara);
        deskripsi_acara =(EditText)view.findViewById(R.id.deskripsi_acara);

        bAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama_acara.length() == 0 && deskripsi_acara.length() == 0) {
                    Toast.makeText(getActivity(), "Nama dan Deskripsi acara wajib di isi", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Berhasil Menambah acara", Toast.LENGTH_LONG).show();
                    ProfilFragment profilFragment= new ProfilFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, profilFragment);
                    fragmentTransaction.commit();
                }
            }
        });


        bUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage= data.getData();
            imageView.setImageURI(selectedImage);
        }
    }
}
