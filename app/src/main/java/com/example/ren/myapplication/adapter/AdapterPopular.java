package com.example.ren.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ren.myapplication.R;
import com.example.ren.myapplication.model.ModelPopular;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ren on 1/5/2018.
 */

public class AdapterPopular extends RecyclerView.Adapter<AdapterPopular.ViewHolder> {
    Context context;
    List<ModelPopular.Results> list;

    public AdapterPopular(Context context, List<ModelPopular.Results> list, AdapterCallback mAdapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = mAdapterCallback;
    }

    public interface AdapterCallback {
        void onMethodCallback(int id);
    }

    private AdapterCallback mAdapterCallback;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).
                load(list.get(position).getPoster_path())
                .crossFade(1000)
                .into(holder.poster);

        holder.title.setText(list.get(position).getTitle());
        holder.vote.setText(Double.toString(list.get(position).getVote_average()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Unbinder unbinder;

        @BindView(R.id.poster_path)
        ImageView poster;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.vote_average)
        TextView vote;
        public ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_popular, parent, false));
            unbinder = ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAdapterCallback.onMethodCallback(list.get(getAdapterPosition()).getId());
                }
            });
        }
    }
}
