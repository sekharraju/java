package com.dev.jk.design.patterns.builder;

public enum SUVComponent {

    FIAT_ENGINE("FIAT"),
    TATA_ENGINE("TATA"),
    MRF_WHEELS("MRF"),
    BRIDGESTONE_WHEELS("BRIDGESTONE"),
    CUSTOM_STEERING("CUSTOM"),
    FIAT_STEERING("FIAT"),
    SONY_MUSIC_SYSTEM("SONY"),
    BOSE_MUSIC_SYSTEM("BOSE");

    private String manufacturerName;

    SUVComponent(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

}
