package org.example.tp_devinettes_avec_tests.repository;

import org.example.tp_devinettes_avec_tests.entity.Riddle;
import org.hibernate.Session;

import java.util.List;

public class RiddleRepository extends Repository<Riddle> {
    @Override
    Riddle findById(int id) {
        return session.get(Riddle.class, id);
    }

    @Override
    List<Riddle> findAll() {
        return session.createQuery("from Riddle", Riddle.class).list();
    }
}
