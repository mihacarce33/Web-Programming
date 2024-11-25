//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//    private final ArtistService artistService;
//    private final SpringTemplateEngine templateEngine;
//    private final SongService songService;
//
//    public ArtistServlet(ArtistService artistService, SpringTemplateEngine templateEngine, SongService songService) {
//        this.artistService = artistService;
//        this.templateEngine = templateEngine;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        String trackId = req.getParameter("trackId");
//        List<Artist> artists = artistService.listArtists();
//        context.setVariable("artists", artists);
//        context.setVariable("trackId", trackId);
//
//        templateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long artistId = Long.parseLong(req.getParameter("artistId"));
//        String trackId = req.getParameter("trackId");
//        Song song = songService.findByTrackId(trackId);
//        Artist artist = artistService.findById(artistId);
//        songService.addArtistToSong(artist, song);
//        resp.sendRedirect("/songDetails?trackId=" + trackId);
//    }
//}
