package com.example.myipinfo.showdetails;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myipinfo.R;
import com.example.myipinfo.databinding.FragmentShowDetailsBinding;
import com.example.myipinfo.retrofit.Controller;
import com.example.myipinfo.retrofit.detailedinfo.MessageDetailed;
import com.example.myipinfo.showdetails.viewmodel.ShowDetailsFactory;
import com.example.myipinfo.showdetails.viewmodel.ShowDetailsViewModel;
import com.example.myipinfo.showdetails.viewmodel.ShowDetailsViewModelImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowDetailsFragment extends Fragment {

    public static final String TAG = "ShowDetailsFragment";

    private ShowDetailsViewModel mShowDetailsViewModel;
    private final static String KEY_SHOW_DETAILS = "KEY_SHOW_DETAILS";
    private String mIp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIp = getArguments().getString(KEY_SHOW_DETAILS);
        mShowDetailsViewModel = ViewModelProviders.of(this, new ShowDetailsFactory(mIp)).get(ShowDetailsViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentShowDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_details, container, false);
        binding.setViewModel(mShowDetailsViewModel);
        init();
        return binding.getRoot();
    }

    private void init() {
        mShowDetailsViewModel.getShowDetailsEvent().observe(this, showDetailsEvent -> getDetailedInfo());
    }

    private void getDetailedInfo() {
        Call<MessageDetailed> messageDetailedCall = Controller.getMessageDetailed().messageDetailed(mIp);

        messageDetailedCall.enqueue(new Callback<MessageDetailed>() {
            @Override
            public void onResponse(Call<MessageDetailed> call, Response<MessageDetailed> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body().getCity() + " " + response.body().getCountry());
                } else {
                    Toast.makeText(getContext(), "Not successful", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MessageDetailed> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static ShowDetailsFragment newInstance(String ip) {
        Bundle args = new Bundle();
        args.putString(KEY_SHOW_DETAILS, ip);
        ShowDetailsFragment fragment = new ShowDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
