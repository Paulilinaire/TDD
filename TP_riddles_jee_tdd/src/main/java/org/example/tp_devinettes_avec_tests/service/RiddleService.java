package org.example.tp_devinettes_avec_tests.service;

import org.example.tp_devinettes_avec_tests.entity.Riddle;
import org.example.tp_devinettes_avec_tests.exception.RepositoryException;
import org.example.tp_devinettes_avec_tests.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RiddleService {
    Repository<Riddle> riddleRepository;
    SessionFactory sessionFactory;

    public RiddleService(SessionFactory sessionFactory, Repository<Riddle> riddleRepository) {
        this.riddleRepository = riddleRepository;
        this.sessionFactory = sessionFactory;
    }


    public boolean createRiddle(String text, String expectedAnswer, String userAnswer) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        riddleRepository.setSession(session);
        Riddle riddle = Riddle.builder()
                .text(text)
                .expectedAnswer(expectedAnswer)
                .userAnswer(userAnswer)
                .build();
        session.beginTransaction();
        try {
            riddleRepository.create(riddle);
            session.getTransaction().commit();
            result = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }

        return result;
    }


    public boolean validateUserAnswer(String text, String expectedAnswer, String userAnswer) {
        return expectedAnswer.equalsIgnoreCase(userAnswer);
    }
}
