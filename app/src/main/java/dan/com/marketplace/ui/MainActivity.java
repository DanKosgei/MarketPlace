package dan.com.marketplace.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dan.com.marketplace.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btn) Button myButton;
    @Bind(R.id.myname) EditText myEditText;
    @Bind(R.id.saved)Button saveButton;
    @Bind(R.id.logout)Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Parse the searched item as an argument
        mSearcheditemReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_ITEM);

    }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    mAuth = FirebaseAuth.getInstance();
    mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            //display welcome message
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                //getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
            } else {

            }
        }
    };

    //Now lets add the search value event listener
        mSearcheditemReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {//When something changes
            for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                String item = locationSnapshot.getValue().toString();
                Log.d("Items  updated", "item: " + item); //log
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });


    //Set an onclick listener
        myButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        logOut.setOnClickListener(this);
}

    //This is supposed to set the value in our firebase
    public void saveCommoditiesToFirebase(String name) {
        mSearcheditemReference.push().setValue(name);
    }


}
      mSearcheditemReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {//When something changes
            for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                String item = locationSnapshot.getValue().toString();
                Log.d("Items  updated", "item: " + item); //log
            }
        }

@Override
public void onClick(View view) {
        if (view == myButton){
        String name = myEditText.getText().toString();
        //This is supposed to save our stuff in the firebase
        saveCommoditiesToFirebase(name);
        Intent intent = new Intent(MainActivity.this, WhatToBuy.class);
        intent.putExtra("name", name);
        startActivity(intent);
        }
        if (view == saveButton){
        Intent intent = new Intent(MainActivity.this, SavedItemListActivity.class);
        startActivity(intent);
        }
        if(view == logOut){
        logout();
        }

        }