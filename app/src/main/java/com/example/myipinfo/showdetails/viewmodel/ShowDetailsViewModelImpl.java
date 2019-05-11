package com.example.myipinfo.showdetails.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowDetailsViewModelImpl extends ViewModel implements ShowDetailsViewModel {

    private String mIp;
    private ObservableField<String> mIpObservableField;

    public ShowDetailsViewModelImpl(String ip) {
        mIp = ip;
        mIpObservableField = new ObservableField<>(mIp);
    }

    @Override
    public ObservableField<String> getIp() {
        return mIpObservableField;
    }
}
