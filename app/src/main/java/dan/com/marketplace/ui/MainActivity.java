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

                Intent intent = new Intent(MainActivity.this, WhatToBuy.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
}
