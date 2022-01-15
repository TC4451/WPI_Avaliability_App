package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.db.LocationEntity;

import java.util.List;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.MyViewHolder> {

    private Context context;
    private List<LocationEntity> locList;

    public LocationListAdapter(Context con){
        this.context = con;
    }

    public void setLocationList(List<LocationEntity> locationList){
        this.locList = locationList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvLocName.setText(this.locList.get(position).locName);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvLocName;
        public MyViewHolder(View view){
            super(view);
            tvLocName = view.findViewById(R.id.tvLocName);

        }
    }
}
