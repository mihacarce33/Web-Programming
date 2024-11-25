//package mk.ukim.finki.wp.lab.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.annotation.WebInitParam;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "RedirectFilter", urlPatterns = "/*",
//        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
//        initParams = {
//                @WebInitParam(name = "ignore-path", value = "/listSongs"),
//        }
//)
//public class RedirectFilter implements Filter {
//    private String ignorePath;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        ignorePath = filterConfig.getInitParameter("ignore-path");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String path = req.getServletPath();
//        String referer = req.getHeader("Referer");
//
//        if (path.startsWith(ignorePath) || (referer != null && referer.contains("trackId=null"))) {
//            String trackId = req.getParameter("trackId");
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            resp.sendRedirect("/listSongs");
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
