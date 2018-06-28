package dan.com.marketplace.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dan.com.marketplace.R;
import dan.com.marketplace.services.MarketService;

public class WhatToBuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_buy);

        //Initialize the butterknife
        ButterKnife.bind(this);

        //Here is where the text is gotten from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        getItems(name);
    }
    //Now this method is for getting the items and showing if there is anything passed
    public void getItems(String item){
        final MarketService marketService = new MarketService();
        MarketService.findItem(item, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
}
