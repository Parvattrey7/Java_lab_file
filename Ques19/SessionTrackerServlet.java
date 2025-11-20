package Ques19;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tracker")
public class SessionTrackerServlet extends HttpServlet {

    private static final String VISIT_COUNT_COOKIE_NAME = "visitCount";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int visitCount = 0;
        Cookie visitCookie = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(VISIT_COUNT_COOKIE_NAME)) {
                    visitCookie = cookie;
                    try {
                        visitCount = Integer.parseInt(visitCookie.getValue());
                    } catch (NumberFormatException e) {
                        System.err.println("Cookie value corrupted: " + cookie.getValue());
                        visitCount = 0;
                    }
                    break;
                }
            }
        }

        visitCount++;

        if (visitCookie == null) {
            visitCookie = new Cookie(VISIT_COUNT_COOKIE_NAME, String.valueOf(visitCount));
        } else {
            visitCookie.setValue(String.valueOf(visitCount));
        }

        visitCookie.setMaxAge(60 * 60 * 24); 
        
        response.addCookie(visitCookie);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracker</title>");
        out.println("<script src='https://cdn.tailwindcss.com'></script>");
        out.println("<style>");
        out.println("body { font-family: 'Inter', sans-serif; background-color: #f7fafc; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body class='flex items-center justify-center min-h-screen'>");
        
        out.println("<div class='bg-white p-8 rounded-xl shadow-2xl text-center max-w-sm w-full'>");
        out.println("<h1 class='text-3xl font-bold text-gray-800 mb-4'>Welcome Back!</h1>");
        
        out.println("<p class='text-6xl font-extrabold text-blue-600 mb-6'>" + visitCount + "</p>");
        
        out.println("<p class='text-xl text-gray-600 mb-2'>You have visited this site</p>");
        out.println("<p class='text-2xl font-semibold text-gray-700 mb-4'>" + visitCount + " time" + (visitCount == 1 ? "" : "s") + "!</p>");
        
        out.println("<p class='text-sm text-gray-400'>This count is stored in a cookie on your browser and persists for 24 hours.</p>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}