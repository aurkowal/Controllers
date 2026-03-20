package pl.coderslab.controller.day4;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller
public class CookieController {

    @RequestMapping("/cookieSet/{value1}/{value2}")
    @ResponseBody
    public String setCookie(HttpServletResponse response, @PathVariable("value1") String value1, @PathVariable("value2") String value2) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "Set Cookies";
    }

    @RequestMapping("/cookieGet")
    @ResponseBody
    public String getCookies(HttpServletRequest request) {
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");
        return "cookies: " + cookie1.getName() + " value: " + cookie1.getValue() + " & " + cookie2.getName() + " value: " + cookie2.getValue() ;
    }

    @RequestMapping("/cookieGetValue")
    @ResponseBody
    public String home(@CookieValue("cookie1") String fooCookie1, @CookieValue("cookie2") String fooCookie2) {
        return "cookie: " + fooCookie1 + " & " + fooCookie2;
    }

}
