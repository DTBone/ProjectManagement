package Util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

public class CSRFTokenUtil implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(true);
        if (session.getAttribute("csrf_token") == null) {
            byte[] tokenBytes = new byte[32];
            new SecureRandom().nextBytes(tokenBytes);
            String token = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
            session.setAttribute("csrf_token", token);
        }
        chain.doFilter(request, response);
    }


    public static String generateCSRFToken(HttpServletRequest request)
    {
        HttpSession session =request.getSession(true);
        byte[] tokenBytes=new byte[32];
        new SecureRandom().nextBytes(tokenBytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
        session.setAttribute("csrf_token", token);
        return token;
    }

    public static boolean validateCSRFToken(HttpServletRequest request)
    {
        HttpSession session =request.getSession(false);
        if(session!=null)
        {
            String csrfToken = request.getParameter("csrf_token");
            if(csrfToken!=null&&csrfToken.equals(session.getAttribute("csrf_token")))
            {
                session.removeAttribute("csrf_token");
                generateCSRFToken(request);
                return true;

            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // Filter.super.init(filterConfig);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
