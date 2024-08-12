package ru.academits.voropaeva.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet(
        value = "/servlet1",
        initParams = {
                @WebInitParam(name = "init1", value = "init1_value"),
                @WebInitParam(name = "init2", value = "init2_value")
        }
)
public class FirstServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] initNames = {"init1", "init2"};
        String[] contextNames = {"context1", "context2"};

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<table border=\"1\">");

        for (String currentName : initNames) {
            printWriter.println("<tr>");
            printWriter.println("<th>");
            printWriter.println(currentName);
            printWriter.println("</th>");
            printWriter.println("<th>");
            printWriter.println(getInitParameter(currentName));
            printWriter.println("</th>");
            printWriter.println("</tr>");
        }

        for (String currentName : contextNames) {
            printWriter.println("<tr>");
            printWriter.println("<th>");
            printWriter.println(currentName);
            printWriter.println("</th>");
            printWriter.println("<th>");
            printWriter.println(getServletContext().getInitParameter(currentName));
            printWriter.println("</th>");
            printWriter.println("</tr>");
        }

        printWriter.println("</table>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("OK");
    }
}
