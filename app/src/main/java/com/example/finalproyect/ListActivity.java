package com.example.finalproyect;

import android.os.Bundle;

import com.example.finalproyect.adapters.CellAdapter;
import com.example.finalproyect.models.CellModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends BaseActivity {

    private FloatingActionButton fab_list_create;
    private ListView lv_list_cellphones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();
        fab_list_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreate();
            }
        });

        lv_list_cellphones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model = modelArrayList.get(i);
                makeSimpleAlertDialog("Opening", "Cell: " + model.getSerial());
            }
        });

    }

    protected void init(){
        fab_list_create = findViewById(R.id.fab_list_create);
        lv_list_cellphones = findViewById(R.id.lv_list_cellphones);
    }

    protected void getCellphones(){
        if (collectionReference != null){
            collectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        if (task.getResult() != null){
                            modelArrayList = new ArrayList<>();
                            for (QueryDocumentSnapshot snapshot : task.getResult()){
                                model = snapshot.toObject(CellModel.class);
                                modelArrayList.add(model);
                            }

                            if (modelArrayList.size() > 0){
                                painCellphone(modelArrayList);
                            }else{
                                makeSimpleAlertDialog("Alert", "Cellphone doesn't found");
                            }
                        }else{
                            makeSimpleAlertDialog("Warning", "Cellphones doesn't found");
                        }
                    }else{
                        makeSimpleAlertDialog("Error" , task.getException().getMessage());
                    }
                }
            });
        }else{
            makeSimpleToast("Database error", 1);
        }
    }

    protected void painCellphone(ArrayList<CellModel> modelArrayList){
        adapter = new CellAdapter(this, modelArrayList);
        lv_list_cellphones.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCellphones();
    }
}