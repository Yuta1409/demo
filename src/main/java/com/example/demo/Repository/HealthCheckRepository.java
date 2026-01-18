package com.example.demo.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HealthCheckRepository {
    
    @Autowired
    private EntityManager entityManager;

    public Long countApplicationConnections() {
        String sql = "SELECT COUNT(*) FROM pg_stat_activity WHERE datname = current_database()";
        Query query = entityManager.createNativeQuery(sql);
        Long countResult = (Long) query.getSingleResult();
        return countResult;
    }
}
