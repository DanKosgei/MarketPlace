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

    @Override
    public MarketListAdapter.MarketViewHlder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false);
       MarketViewHolder viewHolder = new MarketViewHolder(view);
       return  viewHolder;
    }

   @Override
   public void onBindViewHolder(MarketListAdapter.MarketViewHolder holder, int position) {
    holder.bindMarket(mMarket.get(position));
    }
}



    public static class MarketPagerAdapter {
    }