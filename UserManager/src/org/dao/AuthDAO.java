package org.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.Auth;

/**
 * A data access object (DAO) providing persistence and search support for Auth
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.vo.Auth
 * @author MyEclipse Persistence Tools
 */

public class AuthDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AuthDAO.class);
	// property constants
	public static final String COMPANY_ID = "companyId";
	public static final String NAME = "name";
	public static final String MEMO = "memo";

	public void save(Auth transientInstance) {
		log.debug("saving Auth instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Auth persistentInstance) {
		log.debug("deleting Auth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Auth findById(java.lang.Integer id) {
		log.debug("getting Auth instance with id: " + id);
		try {
			Auth instance = (Auth) getSession().get("org.vo.Auth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Auth> findByExample(Auth instance) {
		log.debug("finding Auth instance by example");
		try {
			List<Auth> results = (List<Auth>) getSession().createCriteria(
					"org.vo.Auth").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Auth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Auth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Auth> findByCompanyId(Object companyId) {
		return findByProperty(COMPANY_ID, companyId);
	}

	public List<Auth> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Auth> findByMemo(Object memo) {
		return findByProperty(MEMO, memo);
	}

	public List findAll() {
		log.debug("finding all Auth instances");
		try {
			String queryString = "from Auth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Auth merge(Auth detachedInstance) {
		log.debug("merging Auth instance");
		try {
			Auth result = (Auth) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Auth instance) {
		log.debug("attaching dirty Auth instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Auth instance) {
		log.debug("attaching clean Auth instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}