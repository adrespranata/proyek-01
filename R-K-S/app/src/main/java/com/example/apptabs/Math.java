package com.example.apptabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Math#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Math extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText r,t;
    private Button bt1,bt2;
    private TextView volume,luas;

    public Math() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Math.
     */
    // TODO: Rename and change types and number of parameters
    public static Math newInstance(String param1, String param2) {
        Math fragment = new Math();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_math, container, false);
            r = view.findViewById(R.id.jari);
            t = view.findViewById(R.id.tinggi);
            volume =view.findViewById(R.id.hv);
            luas = view.findViewById(R.id.hl);
            bt1 = view.findViewById(R.id.volume);
            bt2 = view.findViewById(R.id.luas);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (r.length() == 0 && t.length() == 0) {
                        Toast.makeText(getActivity(), "Jari-jari Dan Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else if(r.length() == 0){
                        Toast.makeText(getActivity(), "Jari-jari Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else if (t.length() == 0){
                        Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double jr = Double.parseDouble(r.getText().toString());
                        double ti = Double.parseDouble(t.getText().toString());
                        double rumus = 3.14*jr*jr*ti;
                        volume.setText(" " + rumus);
                    }
                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (r.length() == 0 && t.length() == 0) {
                        Toast.makeText(getActivity(), "Jari-jari Dan Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else if(r.length() == 0){
                        Toast.makeText(getActivity(), "Jari-jari Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else if (t.length() == 0){
                        Toast.makeText(getActivity(), "Tinggi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double jr = Double.parseDouble(r.getText().toString());
                        double ti = Double.parseDouble(t.getText().toString());
                        double rumus = 2*3.14*jr*(jr+ti);
                        luas.setText(" " + rumus);
                    }
                }
            });
            return view;
    }

}