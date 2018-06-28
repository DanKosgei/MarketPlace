package dan.com.marketplace.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import dan.com.marketplace.R;

public class MarketDetailActivity extends AppCompatActivity {
    //Lets implement some binds on the view placeholder
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private MarketPagerAdapter adapterViewPager;
    ArrayList<Market> mMarket = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);
    }
}
