package com.example.myipinfo.showdetails.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowDetailsFactory extends ViewModelProvider.NewInstanceFactory {
    private final String mIp;

    public ShowDetailsFactory(String ip) {
        super();
        mIp = ip;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ShowDetailsViewModelImpl.class) {
            return (T) new ShowDetailsViewModelImpl(mIp);
        }
        return null;
    }
}
