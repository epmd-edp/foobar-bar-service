package com.epam.edp.bar.service.impl;

import com.epam.edp.bar.service.BarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author Roman_Martseniuk
 */
@RunWith(SpringRunner.class)
public class BarServiceImplTest {

    private BarService barService;

    @Before
    public void setUp() throws Exception {
        this.barService = new BarServiceImpl("Angie");
    }

    @Test
    public void testGetSetting() throws Exception {
        String setting = barService.getSetting();
        assertThat(setting, containsString("Angie"));
    }

    @Test
    public void testUpdateSetting() throws Exception {
        barService.updateSetting("test");
        String setting = barService.getSetting();
        assertThat(setting, containsString("test"));
    }
}