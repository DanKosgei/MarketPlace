package dan.com.marketplace.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dan.com.marketplace.R;

public class SavedItemListActivity extends AppCompatActivity implements OnStartDragListener {

    @Bind(R.id.recclerView)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whattobuy_activity);

        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();


        mMarketReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_ITEM)
                .child(uid);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query= FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_ITEM)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);



        mFirebaseAdapter = new FirebaseItemListAdapter(Market.class, R.layout.item_list_item_drag, FirebaseItemViewHolder.class,
                query, this, this) {

            @Override
            protected void populateViewHolder(FirebaseItemViewHolder viewHolder,
                                              Market model, int position) {
                viewHolder.bindItems(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}

    }
}
