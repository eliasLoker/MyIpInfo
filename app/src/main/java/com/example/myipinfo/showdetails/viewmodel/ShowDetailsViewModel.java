package com.example.myipinfo.showdetails.viewmodel;

import androidx.databinding.ObservableField;

import com.example.myipinfo.SingleLiveEvent;
import com.example.myipinfo.events.ShowDetailsEvent;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ShowDetailsViewModel {

    ObservableField<String> getIp();

    ObservableField<String> getLocationInfo();

    void setLocationInfo(String latitude, String longitude);

    ObservableField<String> getCountryName();

    void setCountryName(String name);

    //states
    ObservableField<Boolean> getLocationVisible();

    ObservableField<Boolean> getCountryNameVisible();

    SingleLiveEvent<ShowDetailsEvent> getShowDetailsEvent();

    void onResponseCallback();

    void onShowDetailsClick();
}
