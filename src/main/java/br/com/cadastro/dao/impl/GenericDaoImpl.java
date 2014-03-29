/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastro.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.dao.GenericDao;

import java.util.Collection;

@Transactional
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private SessionFactory sessionFactory;

    private Session session;

    @SuppressWarnings("unchecked")
    private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public GenericDaoImpl() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        this.session = sessionFactory.getCurrentSession();
        return this.session;
    }

    
    @Transactional
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    
    @Transactional
    public void delete(T entity) {
        getSession().delete(entity);
    }

    
    @Transactional
    public Long count() {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.setProjection(Projections.rowCount());
        return (Long.valueOf(criteria.uniqueResult().toString()));

    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findAll(Order order) {
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.addOrder(order);
        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    
    @Transactional
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        return (List<T>) criteria.list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public T findById(Long id) {
        return (T) getSession().createCriteria(clazz).add(Restrictions.eq("id", id)).uniqueResult();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findAllById(Long id) {
        return (List<T>) getSession().createCriteria(clazz).add(Restrictions.eq("id", id)).list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public T findByPk(Object pk) {
        return (T) getSession().get(clazz, (Serializable) pk);
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion criterion) {
        Criteria criteria = getSession().createCriteria(clazz);
        if (criterion == null) {
            return null;
        } else {
            criteria.add(criterion);
        }
        return (List<T>) criteria.list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> selectWithHQL(String hql, Map<String, Object> params) {
        Query query = getSession().createQuery(hql);
        if (params != null) {
            Set<String> str = params.keySet();

            for (String string : str) {
                Object value = params.get(string);
                if ((value instanceof Collection))
                    query.setParameterList(string, (Collection)value);
                else {
                    query.setParameter(string, value);
                  }
            }
        }
        return (List<T>) query.list();
    }

    
    @Transactional()
    @SuppressWarnings("unchecked")
    public List<T> selectWithHQL(String hql, Map<String, Object> params, Integer maxResult) {
        Query query = getSession().createQuery(hql);
        if (params != null) {
            Set<String> str = params.keySet();

            for (String string : str) {
                Object value = params.get(string);
                if ((value instanceof Collection))
                    query.setParameterList(string, (Collection)value);
                else {
                    query.setParameter(string, value);
                  }
            }
        }
        query.setMaxResults(maxResult);
        return (List<T>) query.list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Object[]> selectGenericWithHQL(String hql, Map<String, Object> params) {
        Query query = getSession().createQuery(hql);

        Set<String> str = params.keySet();

        for (String string : str) {
            Object value = params.get(string);
            if ((value instanceof Collection))
                query.setParameterList(string, (Collection)value);
            else {
                query.setParameter(string, value);
              }
        }
        return query.list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findByCriteriaWithOrder(List<Criterion> criterion, Order order) {
        Criteria criteria = getSession().createCriteria(clazz);
        if (criterion == null) {
            return null;
        }
        List<Criterion> list = criterion;
        for (Criterion c : list) {
            criteria.add(c);
        }
        if (order != null) {
            criteria.addOrder(order);
        }
        return (List<T>) criteria.list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findByCriteriaWithOrder(Criterion criterion, Order order) {
        Criteria criteria = getSession().createCriteria(clazz);

        if (criterion == null) {
            return null;
        }
        criteria.add(criterion);
        if (order != null) {
            criteria.addOrder(order);
        }

        return (List<T>) criteria.list();
    }

    
    @Transactional
    @SuppressWarnings("unchecked")
    public T findByCriteriaFirstResult(Criterion criterion) {
        Criteria criteria = getSession().createCriteria(clazz);
        if (criterion == null) {
            return null;
        }
        criteria.add(criterion);
        return (T) criteria.uniqueResult();

    }
}