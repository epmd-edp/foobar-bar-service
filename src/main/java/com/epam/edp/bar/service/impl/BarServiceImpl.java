package com.epam.edp.bar.service.impl;

import com.epam.edp.bar.service.BarService;
import org.springframework.stereotype.Service;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class BarServiceImpl implements BarService {

    private String fooConfig = "default";

    public void updateFooConfig(String fooConfig) {
        this.fooConfig = fooConfig;
    }

    public String getFooConfig() {
        return fooConfig;
    }
}
