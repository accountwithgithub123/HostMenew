package com.example.hostme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class TourismActivityAdapter extends RecyclerView.Adapter<TourismActivityAdapter.TourismViewHolder> {

    Context context;
    ArrayList<TourismPlaces> tourPlacList;
    private int last = -1;

    public TourismActivityAdapter(Context context, ArrayList<TourismPlaces> tourPlacList) {
        this.context = context;
        this.tourPlacList = tourPlacList;
    }   

    @NonNull
    @Override
    public TourismViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tourism_imgs_text_activity,parent,false);
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
        holder.btnmap.setOnClickListener(view -> {
            Intent mapintent = new Intent(context,MapsActivity.class);
            try{
                mapintent.putExtra("Latitude",tourPlacList.get(position).getLatitude());
                mapintent.putExtra("Longitude",tourPlacList.get(position).getLongitude());
                context.startActivity(mapintent);
            }
            catch (Exception e){
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void animationSetter(Context context, View itemView) {
        Animation anim = AnimationUtils.loadAnimation(context, android.R.anim.fade_in|android.R.anim.slide_in_left);
        itemView.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return tourPlacList.size();
    }

    public void setFilteredList(ArrayList<TourismPlaces> filteredlist) {
        tourPlacList = filteredlist;
        notifyDataSetChanged();
    }

    public class TourismViewHolder extends RecyclerView.ViewHolder {
        ImageView ivtourism;
        TextView tvTourismName;
        LinearLayout tourLayout;
        Button btnmap;

        public TourismViewHolder(@NonNull View itemView) {
            super(itemView);
            ivtourism = itemView.findViewById(R.id.ivtourism);
            tvTourismName = itemView.findViewById(R.id.tvtourismTitle);
            tourLayout = itemView.findViewById(R.id.tourLinLay);
            btnmap = itemView.findViewById(R.id.tourActimapbtn);
        }
    }
}
