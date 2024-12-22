package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.repository.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataHolder {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if(albumRepository.count()==0){
            albumRepository.save(new Album("Thriller", "Pop", "1982", new ArrayList<>()));
            albumRepository.save(new Album("The Dark Side of the Moon", "Progressive Rock", "1973", new ArrayList<>()));
            albumRepository.save(new Album("Back in Black", "Hard Rock", "1980", new ArrayList<>()));
            albumRepository.save(new Album("21", "Soul/Pop", "2011", new ArrayList<>()));
            albumRepository.save(new Album("Abbey Road", "Rock", "1969", new ArrayList<>()));
        }

        if(songRepository.count()==0){
            songRepository.save(new Song("T001", "Cubist Dreams", "Jazz", 2020, albumRepository.findByName("Thriller"), new ArrayList<>()));
            songRepository.save(new Song("T002", "Starry Night Blues", "Blues", 2019, albumRepository.findByName("Thriller"), new ArrayList<>()));
            songRepository.save(new Song("T003", "Mona Lisa's Smile", "Classical", 2018, albumRepository.findByName("The Dark Side of the Moon"), new ArrayList<>()));
            songRepository.save(new Song("T004", "Impressionist Sunrise", "Ambient", 2021, albumRepository.findByName("21"), new ArrayList<>()));
            songRepository.save(new Song("T005", "Memory Persistence", "Surreal Pop", 2022, albumRepository.findByName("21"), new ArrayList<>()));
        }

        if (artistRepository.count()==0){
            artistRepository.save(new Artist("Freddie", "Mercury", "Lead vocalist of Queen, known for his powerful voice and stage presence."));
            artistRepository.save(new Artist("Elvis", "Presley", "The King of Rock and Roll, known for hits like 'Jailhouse Rock'."));
            artistRepository.save(new Artist("Whitney", "Houston", "Pop and R&B singer known for her vocal range and 'I Will Always Love You'."));
            artistRepository.save(new Artist("Michael", "Jackson", "King of Pop, famous for hits like 'Thriller' and 'Billie Jean'."));
            artistRepository.save(new Artist("Aretha", "Franklin", "Queen of Soul, known for 'Respect' and her powerful voice."));
        }

        if (userRepository.count()==0){
            userRepository.save(new User("admin", passwordEncoder.encode("admin"), Role.ROLE_ADMIN));
            userRepository.save(new User("asd", passwordEncoder.encode("asd"), Role.ROLE_USER));
        }
    }
}
