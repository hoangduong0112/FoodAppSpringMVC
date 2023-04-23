/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hd.repository.impl;

import com.hd.pojo.Store;
import com.hd.pojo.User;
import com.hd.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Duong Hoang
 */
@Repository
@Transactional
public class StoreRepositoryImpl implements StoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Store> getStores(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Store> q = b.createQuery(Store.class);
        Root root = q.from(Store.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String cateId = params.get("categoryId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }
            Predicate[] predicateArray = new Predicate[predicates.size()];
            predicateArray = predicates.toArray(predicateArray);
            q.where(predicateArray);

        }
        Query query = s.createQuery(q);
        List<Store> stores = query.getResultList();
        return stores;
    }

    @Override
    public Store getStoreById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Store.class, id);
    }

    @Override
    public boolean addOrUpdate(Store p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if( p.getId() != null ){
                Store store = this.getStoreById(p.getId());

                store.setName(p.getName());
                store.setAddress(p.getAddress());
                store.setSdt(p.getSdt());
                store.setCategoryId(p.getCategoryId());
                store.setMenuSet(p.getMenuSet());
                store.setImage(p.getImage());
                store.setUserId(p.getUserId());
                s.save(store);
            } else {
                s.save(p);
            }
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public Store getStoreByUserId(int id) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Store> q = b.createQuery(Store.class);
        Root root = q.from(Store.class);
        q.select(root).where(b.equal(root.get("userId"), id));
        Query query = s.createQuery(q);
        return (Store) query.getSingleResult();
    }

    @Override
    public boolean deteleStore(int id) {
        Store store = this.getStoreById(id);
        Session s = factory.getObject().getCurrentSession();
        try {
            s.delete(store);
            return true;
        } catch (HibernateException ex) {
            return false;
        }

    }

}
