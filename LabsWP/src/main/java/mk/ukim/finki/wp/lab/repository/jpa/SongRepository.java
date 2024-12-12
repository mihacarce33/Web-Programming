package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAll();
    Song findByTrackId(String trackId);
//    Artist addArtistToSong(Artist artist, Song song);
//    boolean deleteSongById(Long id);
    Optional<Song> findById(Long id);
//    void editSong(Song song);
//    void saveSong(Song song);
    List<Song> findAllByAlbum_Id(Long albumId);
}
