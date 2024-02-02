package org.example.tp_devinettes_avec_tests.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tp_devinettes_avec_tests.exception.RepositoryException;
import org.example.tp_devinettes_avec_tests.repository.RiddleRepository;
import org.example.tp_devinettes_avec_tests.service.RiddleService;
import org.example.tp_devinettes_avec_tests.util.HibernateSession;

import java.io.IOException;


@WebServlet("/submitRiddle")
public class RiddleSubmissionServlet extends HttpServlet {

    private final RiddleService riddleService;

    public RiddleSubmissionServlet() {
        this.riddleService = new RiddleService(HibernateSession.getSessionFactory(), new RiddleRepository());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String expectedAnswer = req.getParameter("expectedAnswer");

        try {
            boolean result = riddleService.createRiddle(text, expectedAnswer, null);
            req.setAttribute("submissionResult", result);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (RepositoryException e) {
            // Handle repository exception
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Internal Server Error");
        }
    }
}


