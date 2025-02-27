package com.spgroup.learnjava.dao;

import com.spgroup.learnjava.model.MeterReading;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;


@Repository
public class MeterReadingDao {

    @PersistenceContext
    private EntityManager entityManager;

    // @Transactional
    // public void insert(MeterReading meterReading) {
    //     entityManager.persist(meterReading);
    // }

    // public Double getReadingSum(String meterId) {
    //     TypedQuery<Double> query = entityManager.createQuery(
    //             "SELECT SUM(m.reading) FROM MeterReading m WHERE m.meterId = :meterId", Double.class);
    //     query.setParameter("meterId", meterId);
    //     return query.getSingleResult();
    // }

    @SuppressWarnings("deprecation")
    @Transactional
    public void insert(MeterReading meterReading) {
        Session session = entityManager.unwrap(Session.class);
        session.save(meterReading);
    }

    public Double getReadingSum(String meterId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Double> query = session.createQuery(
                "SELECT SUM(m.reading) FROM MeterReading m WHERE m.meterId = :meterId", Double.class);
        query.setParameter("meterId", meterId);
        return query.uniqueResult();
    }
}