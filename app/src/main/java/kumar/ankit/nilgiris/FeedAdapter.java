package kumar.ankit.nilgiris;

/**
 * Created by Ankit on 22-06-2016.
 */

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedHolder> {
    Context c;
    ArrayList<Feeds> feeds;
    public FeedAdapter(Context c, ArrayList<Feeds> feed) {
        this.c = c;
        this.feeds = feed;
    }
    @Override
    public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        FeedHolder holder=new FeedHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(FeedHolder holder, int position) {
        holder.nameTxt.setText(feeds.get(position).getName());
        holder.emailTxt.setText(feeds.get(position).getemail());
        holder.phoneTxt.setText(feeds.get(position).getphone());
        holder.reminderTxt.setText(feeds.get(position).getreminder());
        holder.amountTxt.setText(feeds.get(position).getamount());
        holder.dateTxt.setText(feeds.get(position).getdate());

        Log.e("Feed ",String.valueOf(position));
    }
    @Override
    public int getItemCount() {
        return feeds.size();
    }

}