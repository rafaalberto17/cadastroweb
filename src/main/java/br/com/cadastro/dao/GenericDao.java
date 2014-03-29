package br.com.cadastro.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface GenericDao<T> {

	void save(T entity);

	void delete(T entity);

	T findById(Long id);

	T findByPk(Object pk);

	List<T> findAll();

	List<T> findAll(Order order);

	T findByCriteriaFirstResult(Criterion criterion);

	List<T> findByCriteriaWithOrder(List<Criterion> criterion, Order order);

	List<T> findByCriteriaWithOrder(Criterion criterion, Order order);

	List<T> findByCriteria(Criterion criterion);

	List<T> findAllById(Long id);
        
	Long count();

	List<T> selectWithHQL(String hql, Map<String, Object> params);

    List<T> selectWithHQL(String hql, Map<String, Object> params, Integer maxResult);
	
	List<Object[]> selectGenericWithHQL(String hql, Map<String, Object> params);
}
