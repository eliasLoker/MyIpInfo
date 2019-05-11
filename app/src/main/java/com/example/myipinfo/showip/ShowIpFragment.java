package com.example.myipinfo.showip;

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
import com.example.myipinfo.databinding.FragmentShowIpBinding;
import com.example.myipinfo.retrofit.MessageApi;
import com.example.myipinfo.retrofit.MessageIp;
import com.example.myipinfo.showdetails.ShowDetailsFragment;
import com.example.myipinfo.showip.viewmodel.ShowIpViewModel;
import com.example.myipinfo.showip.viewmodel.ShowIpViewModelImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ShowIpFragment extends Fragment {

    private static final String TAG = "MainActivity";
    private String mMyIp;

    private ShowIpViewModel mShowIpViewModel;
    private FragmentShowIpBinding mFragmentShowIpBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowIpViewModel = ViewModelProviders.of(this).get(ShowIpViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentShowIpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_ip, container, false);
        mFragmentShowIpBinding.setViewModel(mShowIpViewModel);
        init();
        return mFragmentShowIpBinding.getRoot();
    }

    private void init() {
        mShowIpViewModel.getShowIpEvent().observe(this, showIpEvent -> getMyIp());
        mShowIpViewModel.getFragmentEvent().observe(this, fragmentEvent -> {
            if (getFragmentManager() == null) return;
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, ShowDetailsFragment.newInstance(fragmentEvent.getIp()))
                    .commit();
        });
    }

    private void getMyIp() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.ipify.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        MessageApi messagesApi = retrofit.create(MessageApi.class);

        retrofit2.Call<MessageIp> messages = messagesApi.messages();

        messages.enqueue(new Callback<MessageIp>() {
            @Override
            public void onResponse(Call<MessageIp> call, Response<MessageIp> response) {
                //Log.d(TAG, "onResponse: " + response.message());
                if (response.isSuccessful()) {
                    mShowIpViewModel.onResponseCallback(response.body().getCode());
                } else {

                }
            }

            @Override
            public void onFailure(Call<MessageIp> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static ShowIpFragment newInstance() {
        Bundle args = new Bundle();
        ShowIpFragment fragment = new ShowIpFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
