package com.example.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "additionServlet", value = "/sum")
public class AdditionServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      int a = Integer.parseInt(request.getParameter("a"));
      int b = Integer.parseInt(request.getParameter("b"));
      int sum1 = a + b;
      response.sendRedirect("result.jsp?sum1=" + sum1);
  }
}
