package com.nasr;

import java.util.ArrayList;

public class MusicCollection {
    public MusicCollection(TrackType trackType) {
        this.trackType = trackType;
    }

    final TrackType trackType;

    ArrayList<Track> tracks = new ArrayList<>();
    ArrayList<Track> favoriteTracks = new ArrayList<>();

    void addTrack(Track track) {
        tracks.add(track);
    }

    void addFavorite(Track track) {
        favoriteTracks.add(track);
    }

    void removeFavorite(int index) {
        favoriteTracks.remove(index);
    }

    int trackSize() {
        return tracks.size();
    }

    Track getTrack(int index) {
        return tracks.get(index);
    }

    void removeTrack(int index) {
        tracks.remove(index);
    }


    /*
     *search in track file and artist name
     */
    ArrayList<Track> search(String query) {
        ArrayList<Track> queriedTracks = new ArrayList<>();
        for (Track track : tracks) {
            if (track.storagePath.contains(query)) {
                queriedTracks.add(track);
            } else if (track.artist.contains(query)) {
                queriedTracks.add(track);
            }
        }
        return queriedTracks;
    }


}