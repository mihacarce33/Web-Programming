package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService{
      List<Song> listSongs();
      Artist addArtistToSong(Artist artist, Song song);
      public Song findByTrackId(String trackId);
      boolean deleteSongById(Long id);
      Song findById(Long id);
      void editSong(Song song);
      void saveSong(Song song);

}