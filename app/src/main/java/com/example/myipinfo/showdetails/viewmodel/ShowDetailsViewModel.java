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

    SingleLiveEvent<ShowDetailsEvent> getShowDetailsEvent();

    void onShowDetailsClick();
}
