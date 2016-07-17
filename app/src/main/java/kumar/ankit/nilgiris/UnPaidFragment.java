package kumar.ankit.nilgiris;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Ankit on 17-07-2016.
 */
public class UnPaidFragment extends Fragment {
    RecyclerView rv;

    FeedAdapter adapter;
    ArrayList<Feeds> feeds=new ArrayList<>();


    public UnPaidFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_unpaid, container, false);

        rv= (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);

        progressDialog= new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Refreshing Data...");

        progressDialog.setCancelable(false);
        progressDialog.show();


        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        rv.setItemAnimator(new DefaultItemAnimator());
        getUpdates();
        FloatingActionButton filterfab = (FloatingActionButton)rootView.findViewById(R.id.fab_filter);
        filterfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // rv.scrollToPosition(0);
            }
        });


        return rootView;
    }


    public void getUpdates()
    {
        feeds.clear();

        Feeds f = new Feeds();
        f.setamount("$25");
        f.setdate("25-Jul-2015");
        f.setemail("2012ankitkmr@gmail.com");
        f.setreminder("25-July-2015 15:30:22");
        f.setName("Ankit Kumar");
        f.setPaystatus("Paid");
        f.setphone("944948488");


        for(int i = 0;i<10;i++)
            feeds.add(f);

        adapter = new FeedAdapter(getContext(),feeds);

        rv.setAdapter(adapter);

        progressDialog.dismiss();

        if (feeds.size() > 0) {
            Log.e("Here","size>0");
        }
        else {
            Snackbar.make(getView(),"No Results to Display",Snackbar.LENGTH_LONG).show();
            Log.e("Here",String.valueOf(feeds.size()==0));
        }
    }



}
