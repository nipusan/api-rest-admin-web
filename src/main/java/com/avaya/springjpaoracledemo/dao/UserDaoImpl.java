package com.avaya.springjpaoracledemo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.avaya.springjpaoracledemo.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getData(HashMap<String, Object> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {
            switch (field) {
            case "name":
                predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                break;
            case "password":
                predicates.add(cb.like(root.get(field), "%" + (String) value + "%"));
                break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
