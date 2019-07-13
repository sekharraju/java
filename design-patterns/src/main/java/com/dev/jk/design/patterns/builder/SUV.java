package com.dev.jk.design.patterns.builder;

public class SUV {

    private SUVComponent engine;

    private SUVComponent wheels;

    private SUVComponent musicSystem;

    private SUVComponent steering;

    private SUV() {

    }

    public SUVComponent getEngine() {
        return engine;
    }

    public SUVComponent getWheels() {
        return wheels;
    }

    public SUVComponent getMusicSystem() {
        return musicSystem;
    }

    public SUVComponent getSteering() {
        return steering;
    }

    public static class SUVBuilder {

        private SUVBuilder suvBuilder;

        private SUVComponent engine;

        private SUVComponent wheels;

        private SUVComponent musicSystem;

        private SUVComponent steering;

        private boolean built;

        public SUVBuilder() {

        }

        public SUVBuilder addEngine(SUVComponent engine) {
            this.engine = engine;
            return this;
        }

        public SUVBuilder addMusicSystem(SUVComponent musicSystem) {
            this.musicSystem = musicSystem;
            return this;
        }

        public SUVBuilder addSteering(SUVComponent steering) {
            this.steering = steering;
            return this;
        }

        public SUVBuilder addWheels(SUVComponent wheels) {
            this.wheels = wheels;
            return this;
        }

        public SUV build() {
            if(!built) {
                SUV suv = new SUV();
                suv.engine = this.engine;
                suv.musicSystem = this.musicSystem;
                suv.wheels = this.wheels;
                suv.steering = this.steering;
                built = true;
                return suv;
            }
            throw new RuntimeException("object already built");
        }
    }
}
