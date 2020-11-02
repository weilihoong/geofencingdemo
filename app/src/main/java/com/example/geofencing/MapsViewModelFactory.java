package com.example.geofencing;

import androidx.lifecycle.ViewModelProvider;

public class MapsViewModelFactory implements ViewModelProvider.Factory {
    @Override
    public MapsViewModel create(Class modelClass) {
        return new MapsViewModel();
    }
}