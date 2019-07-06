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

import com.avaya.springjpaoracledemo.entity.ProjectsByUser;
import com.avaya.springjpaoracledemo.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectsByUserDaoImpl {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<ProjectsByUser> getDataByUser(HashMap<String, Object> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectsByUser> query = cb.createQuery(ProjectsByUser.class);
        Root<ProjectsByUser> root = query.from(ProjectsByUser.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {
            switch (field) {
            case "user":
                predicates.add(cb.equal(root.get(field), (User) value));
                break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
