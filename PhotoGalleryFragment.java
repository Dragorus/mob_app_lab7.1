package com.example.mob_app_lab71;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import api.FlickrApi;
import api.FlickrFetchr;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView photoRecyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LiveData<String> flickrLiveData = new FlickrFetchr().fetchPhotos();
        flickrLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String responseString) {
                Log.d("PhotoGalleryFragment", "Response received: " + responseString);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        photoRecyclerView = view.findViewById(R.id.photo_recycler_view);
        photoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }
    public static PhotoGalleryFragment newInstance() {
        return new PhotoGalleryFragment();
    }
}
