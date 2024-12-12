//package mk.ukim.finki.wp.lab.repository;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SongRepository {
//    List<Song> songs = new ArrayList<>();
//    private final ArtistRepository artistRepository;
//    private final AlbumRepository albumRepository;
//
//    public SongRepository(ArtistRepository artistRepository, AlbumRepository albumRepository) {
//        this.artistRepository = artistRepository;
//        this.albumRepository = albumRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//        songs.add(new Song("T001", "Cubist Dreams", "Jazz", 2020, albumRepository.findByName("Thriller"), new ArrayList<>()));
//        songs.add(new Song("T002", "Starry Night Blues", "Blues", 2019, albumRepository.findByName("Thriller"), new ArrayList<>()));
//        songs.add(new Song("T003", "Mona Lisa's Smile", "Classical", 2018, albumRepository.findByName("The Dark Side of the Moon"), new ArrayList<>()));
//        songs.add(new Song("T004", "Impressionist Sunrise", "Ambient", 2021, albumRepository.findByName("21"), new ArrayList<>()));
//        songs.add(new Song("T005", "Memory Persistence", "Surreal Pop", 2022, albumRepository.findByName("21"), new ArrayList<>()));
//    }
//
//    public List<Song> findAll(){
//        return songs;
//    }
//
//    public Song findByTrackId(String trackId){
//        return songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst().orElse(null);
//    }
//
//    public Artist addArtistToSong(Artist artist, Song song){
//        List<Artist> songPerformers = song.getPerformers();
//        if(songPerformers.contains(artist)) return artist;
//        songPerformers.add(artist);
//        song.setPerformers(songPerformers);
//        return artist;
//    }
//
//    public boolean deleteSongById(Long id) {
//        return songs.removeIf(s -> s.getId().equals(id));
//    }
//
//    public Song findById(Long id) {
//        return songs.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public void editSong(Song song) {
//        Song foundSong = songs.stream().filter(s -> s.getId().equals(song.getId())).findFirst().orElse(null);
//        if(foundSong != null) {
//            foundSong.setTrackId(song.getTrackId());
//            foundSong.setGenre(song.getGenre());
//            foundSong.setTitle(song.getTitle());
//            foundSong.setPerformers(song.getPerformers());
//            foundSong.setAlbum(song.getAlbum());
//            foundSong.setReleaseYear(song.getReleaseYear());
//        }
//    }
//
//    public void saveSong(Song song) {
//        Song songTmp1 = songs.stream().filter(s -> s.getId().equals(song.getId())).findFirst().orElse(null);
//        Song songTmp2 = songs.stream().filter(s -> s.getTrackId().equals(song.getTrackId())).findFirst().orElse(null);
//        if(songTmp1==null && songTmp2==null)
//            songs.add(song);
//    }
//}
