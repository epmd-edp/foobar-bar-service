package com.epam.edp.bar.service.impl;

import com.epam.edp.bar.service.BarService;
import org.springframework.stereotype.Service;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class BarServiceImpl implements BarService {

    private String setting = "default-bar";

    public void updateSetting(String setting) {
        this.setting = setting;
    }

    public String getSetting() {
        return setting;
    }
}
