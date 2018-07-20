package com.epam.edp.bar.service.impl;

import com.epam.edp.bar.service.BarService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class BarServiceImpl implements BarService {

    private String setting = "Angie";

    public void updateSetting(String setting) {
        this.setting = setting;
    }

    public String getSetting() {
        return setting + " " + getLocalHost();
    }

    private String getLocalHost() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown host";
        }
    }

}
