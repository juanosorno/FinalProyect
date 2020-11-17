package com.example.finalproyect;

import android.os.Bundle;

import com.example.finalproyect.models.CellModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();

        model = (CellModel) getIntent().getSerializableExtra("model");
        if (model != null){
            makeSimpleAlertDialog("Success", "Model: " + model.getSerial());
        }else{
            makeSimpleAlertDialog("Error", "Empty model");
        }
    }

    protected void init(){

    }
}