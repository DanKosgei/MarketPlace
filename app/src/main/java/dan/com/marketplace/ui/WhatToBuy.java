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

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //String jsonData = response.body().string();
                mMarket = marketService.processResults(response);

                //Now lets Define a thread
                WhatToBuy.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MarketListAdapter(getApplicationContext(), mMarket);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(WhatToBuy.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(WhatToBuy.this, LogIn.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}

