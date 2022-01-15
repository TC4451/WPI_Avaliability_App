package com.example.myapplication.ui.gallery;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Data.Location;
import Data.LocationEntity;
import Data.LocationRepository;

public class GalleryViewModel extends ViewModel {

    private LocationRepository mRepository;

    private final MutableLiveData<List<Location>> mAllLocation = null;

    public GalleryViewModel (Application application) {
        super(application);
        mRepository = new LocationRepository(application);
        mAllLocation.setValue(mRepository.getAllLocations());
    }


    public MutableLiveData<List<Location>> getAllLocations() { return mAllLocation; }

    public void insert(Location word) { mRepository.insert(word); }
}

class LocationViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;

    private LocationViewHolder(View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        wordItemView.setText(text);
    }

    static LocationViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gallery, parent, false);
        return new LocationViewHolder(view);
    }
}

class LocationListAdapter extends ListAdapter<Location, LocationViewHolder> {

    public LocationListAdapter(@NonNull DiffUtil.ItemCallback<Location> diffCallback) {
        super(diffCallback);
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return LocationViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        Location current = getItem(position);
        holder.bind(current.getLocationName());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Location> {

        @Override
        public boolean areItemsTheSame(@NonNull Location oldItem, @NonNull Location newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Location oldItem, @NonNull Location newItem) {
            return oldItem.getLocationName().equals(newItem.getLocationName());
        }
    }
}

