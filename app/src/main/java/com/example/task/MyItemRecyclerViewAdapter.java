package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {} and makes a call to the
 * specified {@link}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Folder> mValues;
    //private OnEntryClickListener mOnEntryClickListener;
    Context context;
    RecyclerView recyclerView;
    private Bundle mBundle;
    private ItemFragment mFragment;
    private SharedPreferences sharedPrefs;
  //  private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<Folder> items) {
        //this.context = ct;
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.set_id.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getName());

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                Fragment myFragment = new ItemFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_list, myFragment).addToBackStack(null).commit();
//
//           //     fragmentJump(holder.mItem);
//            }
//
//
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View mView;
        private final TextView set_id;
        private final TextView mContentView;

        public Folder mItem;


        public ViewHolder(View view1) {
            super(view1);
            mView = view1;
            set_id = (TextView) view1.findViewById(R.id.item_number);
            mContentView = (TextView) view1.findViewById(R.id.content);
//           this.onListener = onListener;
//            AppCompatActivity activity = (AppCompatActivity) view1.getContext();
//                Fragment myFragment = new ItemFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_list, myFragment).addToBackStack(null).commit();
//            //List Listener
          //view1.setOnClickListener(this);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }


        @Override
        public void onClick(View view) {

            if(mOnEntryClickListener != null){
                view = mView;
                    mOnEntryClickListener.onEntryClick(view,getLayoutPosition());
            }

        }
    }


    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }
//    private void fragmentJump(Folder mItemSelected) {
//        mFragment = new ItemFragment();
//        mBundle = new Bundle();
//        mBundle.putParcelable("item_selected_key", mItemSelected);
//        mFragment.setArguments(mBundle);
//        switchContent(R.id.textView, mFragment);
//    }
    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            Fragment frag = fragment;
            mainActivity.switchContent(id, frag);
        }

    }
}
