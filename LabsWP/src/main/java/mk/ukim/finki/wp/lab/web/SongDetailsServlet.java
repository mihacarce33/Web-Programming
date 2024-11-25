//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/songDetails")
//public class SongDetailsServlet extends HttpServlet {
//    private final SpringTemplateEngine templateEngine;
//    private final SongService songService;
//
//    public SongDetailsServlet(SpringTemplateEngine templateEngine, SongService songService) {
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
//        Song song = songService.findByTrackId(trackId);
//        context.setVariable("song", song);
//
//        templateEngine.process("songDetails.html", context, resp.getWriter());
//    }
//}
