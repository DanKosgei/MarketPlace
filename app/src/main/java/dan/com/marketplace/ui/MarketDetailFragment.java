package dan.com.marketplace.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MarketDetailFRagment extends Fragment implements View.OnClickListener{
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    @Bind(R.id.ImageView) ImageView mImageLabel;
    @Bind(R.id.NameTextView) TextView mNameLabel;
    @Bind(R.id.PriceTextView) TextView mPrice;
    @Bind(R.id.StockTextView) TextView mStockLabel;
    @Bind(R.id.saveItemButton) Button myButton;


    private Market mMarket;


    public static MarketDetailFRagment newInstance(Market market) {
        MarketDetailFRagment marketDetailFragment = new MarketDetailFRagment();
        Bundle args = new Bundle();
        args.putParcelable("market", Parcels.wrap(market));
        marketDetailFragment.setArguments(args);
        return marketDetailFragment;
    }