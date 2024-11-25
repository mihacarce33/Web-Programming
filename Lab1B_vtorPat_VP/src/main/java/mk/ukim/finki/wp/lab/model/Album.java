package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Album {
    @Id
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @ManyToOne
    List<Song> songs;

    public Album(String name, String genre, String releaseYear, List<Song> songs) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }
}
