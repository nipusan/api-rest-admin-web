package com.avaya.proccess.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.avaya.proccess.entity.User;
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
            case "username":
                predicates.add(cb.equal(root.get(field), (String) value));
                break;
            case "password":
                predicates.add(cb.and(cb.equal(root.get(field), (String) value)));
                break;
            }

        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
