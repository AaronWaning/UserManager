package org.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.Log;

/**
 * A data access object (DAO) providing persistence and search support for Log
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.vo.Log
 * @author MyEclipse Persistence Tools
 */

public class LogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LogDAO.class);
	// property constants
	public static final String CREATOR_ID = "creatorId";
	public static final String LOG = "log";

	public void save(Log transientInstance) {
		log.debug("saving Log instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Log persistentInstance) {
		log.debug("deleting Log instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Log findById(java.lang.Integer id) {
		log.debug("getting Log instance with id: " + id);
		try {
			Log instance = (Log) getSession().get("org.vo.Log", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Log> findByExample(Log instance) {
		log.debug("finding Log instance by example");
		try {
			List<Log> results = (List<Log>) getSession().createCriteria(
					"org.vo.Log").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Log instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Log as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Log> findByCreatorId(Object creatorId) {
		return findByProperty(CREATOR_ID, creatorId);
	}

	public List<Log> findByLog(Object log) {
		return findByProperty(LOG, log);
	}

	public List findAll() {
		log.debug("finding all Log instances");
		try {
			String queryString = "from Log";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Log merge(Log detachedInstance) {
		log.debug("merging Log instance");
		try {
			Log result = (Log) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Log instance) {
		log.debug("attaching dirty Log instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Log instance) {
		log.debug("attaching clean Log instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}