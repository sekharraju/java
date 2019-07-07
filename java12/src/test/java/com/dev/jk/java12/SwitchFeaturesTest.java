package com.dev.jk.java12;

import com.dev.jk.java12.features.SwitchFeatures;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SwitchFeaturesTest {

    private SwitchFeatures switchFeatures;

    @Before
    public void setUp() {
        switchFeatures = new SwitchFeatures();
    }

    @Test
    public void oldSwitch() {
        String oldSwitch = switchFeatures.oldSwitch();
        Assert.assertEquals("greater than 3", oldSwitch);
    }

    @Test
    public void newSwitch() {
        String newSwitch = switchFeatures.newSwitch();
        Assert.assertEquals("greater than 3", newSwitch);
    }

}
