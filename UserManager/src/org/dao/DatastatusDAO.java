package org.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.Datastatus;

/**
 * A data access object (DAO) providing persistence and search support for
 * Datastatus entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.vo.Datastatus
 * @author MyEclipse Persistence Tools
 */

public class DatastatusDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DatastatusDAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(Datastatus transientInstance) {
		log.debug("saving Datastatus instance");
		Transaction tran = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tran.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(Datastatus persistentInstance) {
		log.debug("deleting Datastatus instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Datastatus findById(java.lang.Integer id) {
		log.debug("getting Datastatus instance with id: " + id);
		try {
			Datastatus instance = (Datastatus) getSession().get(
					"org.vo.Datastatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Datastatus> findByExample(Datastatus instance) {
		log.debug("finding Datastatus instance by example");
		try {
			List<Datastatus> results = (List<Datastatus>) getSession()
					.createCriteria("org.vo.Datastatus").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Datastatus instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Datastatus as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Datastatus> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Datastatus instances");
		try {
			String queryString = "from Datastatus";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Datastatus merge(Datastatus detachedInstance) {
		log.debug("merging Datastatus instance");
		try {
			Datastatus result = (Datastatus) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Datastatus instance) {
		log.debug("attaching dirty Datastatus instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Datastatus instance) {
		log.debug("attaching clean Datastatus instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}