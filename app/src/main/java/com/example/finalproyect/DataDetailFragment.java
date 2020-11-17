package com.example.finalproyect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalproyect.models.CellModel;

import org.w3c.dom.Text;

public class DataDetailFragment extends Fragment {

    private static String serial, description, brand;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_data_detail_serial, tv_data_detail_brand, tv_data_detail_description;

        tv_data_detail_serial= view.findViewById(R.id.tv_data_detail_serial);
        tv_data_detail_brand= view.findViewById(R.id.tv_data_detail_brand);
        tv_data_detail_description= view.findViewById(R.id.tv_data_detail_description);

        tv_data_detail_serial.setText(serial);
        tv_data_detail_brand.setText(brand);
        tv_data_detail_description.setText(description);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DataDetailFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public static  void getDataDet(Bundle bundle){
        CellModel model = (CellModel) bundle.getSerializable("model");
        if (model != null){
            serial = model.getSerial();
            brand = model.getBrand();
            description = model.getDescription();
        }
    }
}