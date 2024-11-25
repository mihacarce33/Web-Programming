package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {
    List<Album> albums;

    @PostConstruct
    public void init() {
        albums = new ArrayList<>();
        albums.add(new Album("Thriller", "Pop", "1982", new ArrayList<>()));
        albums.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973", new ArrayList<>()));
        albums.add(new Album("Back in Black", "Hard Rock", "1980", new ArrayList<>()));
        albums.add(new Album("21", "Soul/Pop", "2011", new ArrayList<>()));
        albums.add(new Album("Abbey Road", "Rock", "1969", new ArrayList<>()));
    }

    public List<Album> findAll(){
        return albums;
    }

    public Album findByName(String name) {
        return albums.stream().filter(album -> album.getName().equals(name)).findFirst().orElse(null);
    }

    public Album findOne(Long id) {
        return albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }
}
