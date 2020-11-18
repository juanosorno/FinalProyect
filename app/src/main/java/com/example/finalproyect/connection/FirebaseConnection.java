package com.example.finalproyect.connection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseConnection {

    private static FirebaseAuth mAuth;
    private static FirebaseFirestore db;
    private static FirebaseStorage mFirebaseStorage;

    public  static FirebaseAuth ConnectionAuth() {
        mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public static FirebaseStorage ConnectionStorage(){
        mFirebaseStorage = FirebaseStorage.getInstance();
        return mFirebaseStorage;
    }

    public static FirebaseFirestore ConnectionFirestore(){
        db = FirebaseFirestore.getInstance();
        return db;
    }
}
