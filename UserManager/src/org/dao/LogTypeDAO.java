package org.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.LogType;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.vo.LogType
 * @author MyEclipse Persistence Tools
 */

public class LogTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LogTypeDAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(LogType transientInstance) {
		log.debug("saving LogType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LogType persistentInstance) {
		log.debug("deleting LogType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LogType findById(java.lang.Integer id) {
		log.debug("getting LogType instance with id: " + id);
		try {
			LogType instance = (LogType) getSession().get("org.vo.LogType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LogType> findByExample(LogType instance) {
		log.debug("finding LogType instance by example");
		try {
			List<LogType> results = (List<LogType>) getSession()
					.createCriteria("org.vo.LogType").add(create(instance))
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
		log.debug("finding LogType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LogType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LogType> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all LogType instances");
		try {
			String queryString = "from LogType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LogType merge(LogType detachedInstance) {
		log.debug("merging LogType instance");
		try {
			LogType result = (LogType) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LogType instance) {
		log.debug("attaching dirty LogType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LogType instance) {
		log.debug("attaching clean LogType instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}