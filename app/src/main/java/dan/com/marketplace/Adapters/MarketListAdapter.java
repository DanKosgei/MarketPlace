package dan.com.marketplace.Adapters;

import android.content.Context;

import java.util.ArrayList;

public class MarketListAdapter extends RecyclerView.Adapter<MarketListAdapter.MarketViewHolder>  {
    private ArrayList<Market> mMarket = new ArrayList<>();
    private Context mContext;

    //Now lets create a constructor
    public MarketListAdapter (Context context, ArrayList<Market> markets){
        mContext = context;
        mMarket = markets;
    }

    public static class MarketPagerAdapter {
    }