package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @PostMapping("add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam Integer releaseYear,
                           @RequestParam Long albumId) {
        System.out.println("HERE");
        Song song = new Song(trackId, title, genre, releaseYear, albumService.findOne(albumId), new ArrayList<>());
        songService.saveSong(song);
        return "redirect:/songs";
    }

    @GetMapping
    public String getSongsPage(Model model){
        model.addAttribute("songs", this.songService.listSongs());
        model.addAttribute("albums", this.albumService.findAll());
        return "listSongs";
    }

    @PostMapping
    public String goToArtistPage (@RequestParam String trackId){
        return "redirect:/artist?trackId=" + trackId;
    }

    @PostMapping("delete/{songId}")
    public String deleteSong(@PathVariable Long songId, Model model) {
        songService.deleteSongById(songId);
        return "redirect:/songs";
    }

    @GetMapping("/add")
    public String saveSong(Model model) {
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);

        return "addSong";
    }

    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song currentSong = songService.findById(songId);
        model.addAttribute("song", currentSong);
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums", albums);
        return "editSong";
    }

    @PostMapping("/edit")
    public String editSong(@RequestParam String title, @RequestParam String trackId, @RequestParam String genre, @RequestParam int releaseYear, @RequestParam Long albumId, @RequestParam Long songID, Model model) {
        Song song = new Song(trackId, title, genre, releaseYear, albumService.findOne(albumId), new ArrayList<>());
        song.setId(songID);
        songService.saveSong(song);
        return "redirect:/songs";
    }
}
