package com.nasr;

public class Track {
    final TrackType trackType;
    final String storagePath;
    final String artist;
    final String releaseDay;

    public Track(com.nasr.TrackType trackType, String storagePath, String artist, String releaseDay) {
        this.trackType = trackType;
        this.storagePath = storagePath;
        this.artist = artist;
        this.releaseDay = releaseDay;
    }
}
