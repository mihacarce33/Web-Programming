package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        List<Artist> artists = song.getPerformers();
        if (artists.contains(artist)) {
            return artist;
        }
        artists.add(artist);
        song.setPerformers(artists);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.findById(id).ifPresent(songRepository::delete);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
//        songRepository.editSong(song);
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        Album album = albumRepository.findById(albumId).orElse(null);
        if (album != null) {
            return songRepository.findAll().stream().filter(x->x.getAlbum().equals(album)).toList();
        }
        else throw new RuntimeException("No such album");
//        return songRepository.findAllByAlbum_Id(albumId);
    }
}
