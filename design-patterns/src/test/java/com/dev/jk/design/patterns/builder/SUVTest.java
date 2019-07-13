package com.dev.jk.design.patterns.builder;

import com.dev.jk.design.patterns.builder.SUV.SUVBuilder;
import org.junit.Test;

import static com.dev.jk.design.patterns.builder.SUVComponent.CUSTOM_STEERING;
import static com.dev.jk.design.patterns.builder.SUVComponent.FIAT_ENGINE;
import static com.dev.jk.design.patterns.builder.SUVComponent.MRF_WHEELS;
import static com.dev.jk.design.patterns.builder.SUVComponent.SONY_MUSIC_SYSTEM;
import static org.assertj.core.api.Assertions.assertThat;

public class SUVTest {

    @Test
    public void createSUV() {
        SUVBuilder suvBuilder = new
                SUVBuilder();
        suvBuilder.addEngine(FIAT_ENGINE);
        suvBuilder.addSteering(CUSTOM_STEERING);
        suvBuilder.addMusicSystem(SONY_MUSIC_SYSTEM);
        suvBuilder.addWheels(MRF_WHEELS);
        SUV suv = suvBuilder.build();
        assertThat(suv.getEngine()).isEqualTo(FIAT_ENGINE);
        assertThat(suv.getMusicSystem()).isEqualTo(SONY_MUSIC_SYSTEM);
        assertThat(suv.getSteering()).isEqualTo(CUSTOM_STEERING);
        assertThat(suv.getWheels()).isEqualTo(MRF_WHEELS);
    }
}
