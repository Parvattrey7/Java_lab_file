package tagHandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class UserInputDisplayTag extends SimpleTagSupport {
    private String userName;
    private int userAge;

    // Setter for 'name' attribute - JSP container calls this
    public void setName(String userName) {
        this.userName = userName;
    }

    // Setter for 'age' attribute - JSP container calls this
    public void setAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        // Dynamically display the input in different sections/formats

        // Section 1: Heading/Title
        out.println("<h2><span style='color: #4CAF50;'>User Profile Summary</span></h2>");

        // Section 2: Detailed Information (e.g., in a paragraph)
        out.println("<p>Hello, **" + userName + "**! According to your input, you are **" + userAge + "** years old.</p>");

        // Section 3: Separate list item format
        out.println("<ul>");
        out.println("<li>**Name:** " + userName + "</li>");
        out.println("<li>**Age:** " + userAge + " years</li>");
        out.println("</ul>");
    }
}