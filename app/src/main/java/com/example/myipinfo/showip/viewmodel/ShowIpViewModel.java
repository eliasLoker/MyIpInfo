package com.example.myipinfo.showip.viewmodel;

import androidx.databinding.ObservableField;

import com.example.myipinfo.SingleLiveEvent;
import com.example.myipinfo.events.FragmentEvent;
import com.example.myipinfo.events.ShowIpEvent;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ShowIpViewModel {

    ObservableField<Boolean> getDetailsState();

    ObservableField<String> getIp();

    SingleLiveEvent<ShowIpEvent> getShowIpEvent();

    SingleLiveEvent<FragmentEvent> getFragmentEvent();

    void onClickShowIpButton();

    void onClickShowDetailsButton();

    void onResponseCallback(String ip);
}
