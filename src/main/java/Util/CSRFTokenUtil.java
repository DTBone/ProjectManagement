package Util;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;

public class CSRFTokenUtil {
    public static final String CSRF_TOKEN_SESSION_ATTR = "csrfToken";
    public static String generateCSRFToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void saveCSRFTokenToSession(HttpSession session) {
        String csrfToken = generateCSRFToken();
        session.setAttribute(CSRF_TOKEN_SESSION_ATTR, csrfToken);
    }

    public static String getCSRFTokenFromSession(HttpSession session) {
        return (String) session.getAttribute(CSRF_TOKEN_SESSION_ATTR);
    }
}
