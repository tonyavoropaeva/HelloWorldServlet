package ru.academits.voropaeva.helloWorldServlet.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                <meta charset="UTF-8">
                <title>Servlet 1</title>
                </head>
                <body>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Parameter Name</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>""");

        Enumeration<String> initParametersNames = getInitParameterNames();
        printWriter.println("<tr><td colspan=\"2\">init parameters:</td></tr>");

        while (initParametersNames.hasMoreElements()) {
            String parameterName = initParametersNames.nextElement();

            printWriter.println("<tr>");
            printWriter.println("<td>" + parameterName + "</td>");
            printWriter.println("<td>" + getInitParameter(parameterName) + "</td>");
            printWriter.println("</tr>");
        }

        Enumeration<String> ContextParametersNames = getServletContext().getInitParameterNames();
        printWriter.println("<tr><td colspan=\"2\">context parameters:</td></tr>");

        while (ContextParametersNames.hasMoreElements()) {
            String contextName = ContextParametersNames.nextElement();

            printWriter.println("<tr>");
            printWriter.println("<td>" + contextName + "</td>");
            printWriter.println("<td>" + getServletContext().getInitParameter(contextName) + "</td>");
            printWriter.println("</tr>");
        }

        printWriter.println("</tbody>");
        printWriter.println("</table>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("OK");
    }
}
