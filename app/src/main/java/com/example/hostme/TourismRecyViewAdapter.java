package com.example.hostme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class TourismRecyViewAdapter extends RecyclerView.Adapter<TourismRecyViewAdapter.TourismViewHolder> {
    Context context;
    ArrayList<TourismPlaces> tourPlacList;
    private int last = -1;

    public TourismRecyViewAdapter(Context context, ArrayList<TourismPlaces> tourPlaceList, int tourism_images_text) {

    }

    public TourismRecyViewAdapter(Context context, ArrayList<TourismPlaces> tourPlacList) {
        this.context = context;
        this.tourPlacList = tourPlacList;
    }

    @NonNull
    @Override
    public TourismViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tourism_images_text,parent,false);
        return new TourismViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourismViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.tvTourismName.setText(tourPlacList.get(position).getPlaceName());
            holder.ivtourism.setImageResource(tourPlacList.get(position).getImgURl());
        if (position>last){
            animationSetter(context,holder.itemView);
            last = position;
        }
        holder.tourLayout.setOnClickListener(view -> {
//            New Intent Activity will be started here
            Toast.makeText(context, tourPlacList.get(position).getPlaceName(), Toast.LENGTH_SHORT).show();
        });
    }

    private void animationSetter(Context context, View itemView) {
        Animation anim = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        itemView.startAnimation(anim);
    }
    @Override
    public int getItemCount() {
        return tourPlacList.size();
    }

    public static class TourismViewHolder extends RecyclerView.ViewHolder {
        ImageView ivtourism;
        TextView tvTourismName;
        LinearLayout tourLayout;
        public TourismViewHolder(@NonNull View itemView) {
            super(itemView);
            ivtourism = itemView.findViewById(R.id.ivtourism);
            tvTourismName = itemView.findViewById(R.id.tvtourism);
            tourLayout = itemView.findViewById(R.id.tourLinLay);
        }
    }
}
