package com.example.geofencing;

import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapsViewModel extends ViewModel {

    private final MutableLiveData<Boolean> isInsideGeofence = new MutableLiveData<Boolean>();
    private boolean isInsideGeofenceLocation = false;
    private String connectedSSID ;
    private String userEnteredSSID = "";

    public MapsViewModel() {
        isInsideGeofence.setValue(false);
    }

    public LiveData<Boolean> getIsInsideGeofence() {
        return isInsideGeofence;
    }

    public void setIsInsideGeofenceLocation(boolean isInside){
        this.isInsideGeofenceLocation = isInside;
        calcGeofenceStatus();
    }

    public void setConnectedSSID(String connectedSSID){
        this.connectedSSID = connectedSSID;
        calcGeofenceStatus();
    }

    public void setUserEnteredSSID(String userEnteredSSID){
        this.userEnteredSSID = userEnteredSSID;
        calcGeofenceStatus();
    }

    private void calcGeofenceStatus() {
        boolean isInsideGeofence;
        if (!userEnteredSSID.isEmpty() && userEnteredSSID.equals(connectedSSID)) {
            isInsideGeofence = true;
        } else {
            isInsideGeofence = isInsideGeofenceLocation;
        }

        this.isInsideGeofence.setValue(isInsideGeofence);
    }

}
