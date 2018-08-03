/*
 * Copyright 2018 EPAM Systems.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.edp.bar.service.impl;

import com.epam.edp.bar.service.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class BarServiceImpl implements BarService {

    private static final Logger LOG = LoggerFactory.getLogger(BarServiceImpl.class);

    private String setting;

    public BarServiceImpl(@Value("${bar.setting}") String setting) {
        this.setting = setting;
    }

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
            LOG.error("Unknown host", e);
            return "unknown host";
        }
    }

}
