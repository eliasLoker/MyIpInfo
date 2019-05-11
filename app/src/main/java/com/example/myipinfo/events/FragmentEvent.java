package com.example.myipinfo.events;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FragmentEvent {
    private String mIp;

    public FragmentEvent(String ip) {
        mIp = ip;
    }

    public String getIp() {
        return mIp;
    }
}
