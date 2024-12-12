//package mk.ukim.finki.wp.lab.repository;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Artist;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ArtistRepository {
//    List<Artist> artists;
//
//    @PostConstruct
//    public void init() {
//        artists = new ArrayList<>();
//        artists.add(new Artist("Freddie", "Mercury", "Lead vocalist of Queen, known for his powerful voice and stage presence."));
//        artists.add(new Artist("Elvis", "Presley", "The King of Rock and Roll, known for hits like 'Jailhouse Rock'."));
//        artists.add(new Artist("Whitney", "Houston", "Pop and R&B singer known for her vocal range and 'I Will Always Love You'."));
//        artists.add(new Artist("Michael", "Jackson", "King of Pop, famous for hits like 'Thriller' and 'Billie Jean'."));
//        artists.add(new Artist("Aretha", "Franklin", "Queen of Soul, known for 'Respect' and her powerful voice."));
//    }
//
//    public List<Artist> findAll(){
//        return artists;
//    }
//
//    public Optional<Artist> findById(Long id){
//        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
//    }
//}
