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

    private SingleLiveEvent<ShowDetailsEvent> mShowDetailsEvent;

    public ShowDetailsViewModelImpl(String ip) {
        mIp = ip;
        mIpObservableField = new ObservableField<>(mIp);

        mShowDetailsEvent = new SingleLiveEvent<>();
    }

    @Override
    public ObservableField<String> getIp() {
        return mIpObservableField;
    }

    @Override
    public SingleLiveEvent<ShowDetailsEvent> getShowDetailsEvent() {
        return mShowDetailsEvent;
    }

    @Override
    public void onShowDetailsClick() {
        mShowDetailsEvent.postValue(new ShowDetailsEvent());
    }
}
