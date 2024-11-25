//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.repository.SongRepository;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//    private final SongRepository songRepository;
//    private final SpringTemplateEngine templateEngine;
//
//    public SongListServlet(SongRepository songRepository, SpringTemplateEngine templateEngine) {
//        this.songRepository = songRepository;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        String filter = req.getParameter("filter");
//        List<Song> songs = new ArrayList<>();
//        if(filter!=null && !filter.isEmpty()) {
//            songs = songRepository.findAll().stream().filter(song -> song.getTitle().toLowerCase().contains(filter.toLowerCase())).toList();
//        }else songs = songRepository.findAll();
//
//        context.setVariable("songs", songs);
//
//        templateEngine.process("listSongs.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String trackId = req.getParameter("trackId");
//        resp.sendRedirect("/artist?trackId=" + trackId);
//    }
//}
