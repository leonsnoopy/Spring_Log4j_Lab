package com.gss.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class userRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> findUserByIdUnsafe(String id) {
        String sql = "SELECT * FROM users WHERE id = '" + id + "'";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    public List<Object[]> findUserByNamePassword(String name, String pass) {
        String sql = "SELECT * FROM users WHERE name = '" + name + "' and password = '" + pass + "'";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
