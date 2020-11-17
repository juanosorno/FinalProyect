package com.example.finalproyect.connection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseConnection {

    private static FirebaseAuth mAuth;
    private static StorageReference mStorageRef;
    private static FirebaseFirestore db;

    public  static FirebaseAuth ConnectionAuth() {
        mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public static StorageReference ConnectionStorage(){
        mStorageRef = FirebaseStorage.getInstance().getReference();
        return mStorageRef;
    }

    public static FirebaseFirestore ConnectionFirestore(){
        db = FirebaseFirestore.getInstance();
        return db;
    }
}
