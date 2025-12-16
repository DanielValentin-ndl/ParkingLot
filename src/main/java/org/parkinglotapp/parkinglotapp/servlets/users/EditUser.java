package org.parkinglotapp.parkinglotapp.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.parkinglotapp.parkinglotapp.common.UserDto;
import org.parkinglotapp.parkinglotapp.ejb.UserBean;

import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAsString = request.getParameter("id");

        if (idAsString != null) {
            Long id = Long.parseLong(idAsString);
            UserDto user = userBean.findById(id);
            request.setAttribute("user", user);
        }

        request.getRequestDispatcher("/WEB-INF/pages/users/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAsString = request.getParameter("user_id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Long id = Long.parseLong(idAsString);

        userBean.updateUser(id, username, email, password);

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}