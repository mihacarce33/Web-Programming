package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtist(Model model, @RequestParam(required = false) String trackId) {
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("artists", artists);
        model.addAttribute("trackId", trackId);

        return "artistsList";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String postArtist(@RequestParam Long artistId,
                             @RequestParam String trackId) {
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.findById(artistId);
        songService.addArtistToSong(artist, song);
        return "redirect:/songDetails?trackId=" + trackId;
    }
}
