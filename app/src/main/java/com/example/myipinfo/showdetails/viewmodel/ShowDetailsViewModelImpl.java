package com.example.myipinfo.showdetails.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myipinfo.SingleLiveEvent;
import com.example.myipinfo.events.ShowDetailsEvent;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowDetailsViewModelImpl extends ViewModel implements ShowDetailsViewModel {

    private String mIp;
    private ObservableField<String> mIpObservableField;
    private ObservableField<String> mLocation;
    private ObservableField<String> mCountryName;

    private ObservableField<Boolean> mLocationVisible;
    private ObservableField<Boolean> mCountryNameVisible;

    private SingleLiveEvent<ShowDetailsEvent> mShowDetailsEvent;

    public ShowDetailsViewModelImpl(String ip) {
        mIp = ip;
        mIpObservableField = new ObservableField<>(mIp);
        mLocation = new ObservableField<>();
        mCountryName = new ObservableField<>();

        mLocationVisible = new ObservableField<>(false);
        mCountryNameVisible = new ObservableField<>(false);
        mShowDetailsEvent = new SingleLiveEvent<>();
    }

    @Override
    public ObservableField<String> getIp() {
        return mIpObservableField;
    }

    @Override
    public ObservableField<String> getLocationInfo() {
        return mLocation;
    }

    @Override
    public void setLocationInfo(String latitude, String longitude) {
        mLocation.set(latitude + ", " + longitude);
    }

    @Override
    public ObservableField<String> getCountryName() {
        return mCountryName;
    }

    @Override
    public void setCountryName(String name) {
        mCountryName.set(name);
    }

    @Override
    public ObservableField<Boolean> getLocationVisible() {
        return mLocationVisible;
    }

    @Override
    public ObservableField<Boolean> getCountryNameVisible() {
        return mCountryNameVisible;
    }

    @Override
    public SingleLiveEvent<ShowDetailsEvent> getShowDetailsEvent() {
        return mShowDetailsEvent;
    }

    @Override
    public void onResponseCallback() {
        mLocationVisible.set(true);
        mCountryNameVisible.set(true);
    }

    @Override
    public void onShowDetailsClick() {
        mShowDetailsEvent.postValue(new ShowDetailsEvent());
    }
}
