package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String trackId;
    String title;
    String genre;
    int releaseYear ;
    @ManyToOne
    private Album album;
    @ManyToMany
    List<Artist> performers;

    public Song(String trackId, String title, String genre, int releaseYear, Album album, List<Artist> performers) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = performers;
    }
}
