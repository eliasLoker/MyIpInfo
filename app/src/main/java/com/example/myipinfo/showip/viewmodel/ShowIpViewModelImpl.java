package com.example.myipinfo.showip.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myipinfo.SingleLiveEvent;
import com.example.myipinfo.events.FragmentEvent;
import com.example.myipinfo.events.ShowIpEvent;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowIpViewModelImpl extends ViewModel implements ShowIpViewModel {

    public static final String TAG = "ShowIpViewModelImpl";

    private ObservableField<Boolean> mDetailsState;
    private ObservableField<Boolean> mProgressBarState;

    private ObservableField<String> mIp;

    private SingleLiveEvent<ShowIpEvent> mShowIpEvent;
    private SingleLiveEvent<FragmentEvent> mGoToShowDetails;

    public ShowIpViewModelImpl() {
        mDetailsState = new ObservableField<>(false);
        mProgressBarState = new ObservableField<>(false);
        mIp = new ObservableField<>();

        mShowIpEvent = new SingleLiveEvent<>();
        mGoToShowDetails = new SingleLiveEvent<>();
    }

    @Override
    public ObservableField<Boolean> getDetailsState() {
        return mDetailsState;
    }

    @Override
    public ObservableField<String> getIp() {
        return mIp;
    }

    @Override
    public ObservableField<Boolean> getProgressBarState() {
        return mProgressBarState;
    }

    @Override
    public SingleLiveEvent<ShowIpEvent> getShowIpEvent() {
        return mShowIpEvent;
    }

    @Override
    public SingleLiveEvent<FragmentEvent> getFragmentEvent() {
        return mGoToShowDetails;
    }

    @Override
    public void onClickShowIpButton() {
        mProgressBarState.set(true);
        mShowIpEvent.postValue(new ShowIpEvent());
    }

    @Override
    public void onClickShowDetailsButton() {
        mGoToShowDetails.postValue(new FragmentEvent(mIp.get()));
    }

    @Override
    public void onResponseCallback(String ip) {
        mProgressBarState.set(false);
        mDetailsState.set(true);
        mIp.set(ip);
    }
}
