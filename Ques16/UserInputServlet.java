import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Add this line
package com.example.web;

@WebServlet("/process-user-input")
public class UserInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        String name = request.getParameter("userName");
        String ageStr = request.getParameter("userAge");
        
        int age = -1;
        
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            age = 0; 
        }

        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>Display User Information</title>");
        out.println("    <script src=\"https://cdn.tailwindcss.com\"></script>");
        out.println("    <style>");
        out.println("        body { font-family: 'Inter', sans-serif; background-color: #e2e8f0; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body class=\"min-h-screen flex items-center justify-center p-4\">");
        out.println("    <div class=\"w-full max-w-md bg-white p-10 rounded-xl shadow-2xl text-center\">");
        
        if (name != null && !name.trim().isEmpty() && age > 0) {
            out.println("        <svg class=\"mx-auto h-16 w-16 text-green-500\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\" aria-hidden=\"true\">");
            out.println("            <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z\" />");
            out.println("        </svg>");
            out.println("        <h1 class=\"text-3xl font-extrabold text-gray-900 mt-4 mb-2\">Information Received!</h1>");
            out.println("        <p class=\"text-xl text-gray-700\">Hello, <span class=\"font-bold text-blue-600\">" + name + "</span>!</p>");
            out.println("        <p class=\"text-xl text-gray-700\">Your age is: <span class=\"font-bold text-blue-600\">" + age + "</span> years old.</p>");
        } else {
            out.println("        <svg class=\"mx-auto h-16 w-16 text-red-500\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\" aria-hidden=\"true\">");
            out.println("            <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z\" />");
            out.println("        </svg>");
            out.println("        <h1 class=\"text-3xl font-extrabold text-gray-900 mt-4 mb-2\">Error: Missing Input</h1>");
            out.println("        <p class=\"text-md text-gray-600\">Please ensure both name and age are provided.</p>");
        }
        
        out.println("        <a href=\"index.html\" class=\"mt-6 inline-block bg-gray-200 text-gray-800 py-2 px-4 rounded-xl font-medium hover:bg-gray-300 transition duration-150 ease-in-out\">Go Back</a>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        doPost(request, response);
    }
}