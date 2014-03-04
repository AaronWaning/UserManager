package org.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.RoleAuth;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleAuth entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.vo.RoleAuth
 * @author MyEclipse Persistence Tools
 */

public class RoleAuthDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RoleAuthDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String MEMO = "memo";

	public void save(RoleAuth transientInstance) {
		log.debug("saving RoleAuth instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleAuth persistentInstance) {
		log.debug("deleting RoleAuth instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleAuth findById(java.lang.Integer id) {
		log.debug("getting RoleAuth instance with id: " + id);
		try {
			RoleAuth instance = (RoleAuth) getSession().get("org.vo.RoleAuth",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RoleAuth> findByExample(RoleAuth instance) {
		log.debug("finding RoleAuth instance by example");
		try {
			List<RoleAuth> results = (List<RoleAuth>) getSession()
					.createCriteria("org.vo.RoleAuth").add(create(instance))
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
		log.debug("finding RoleAuth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleAuth as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<RoleAuth> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<RoleAuth> findByMemo(Object memo) {
		return findByProperty(MEMO, memo);
	}

	public List findAll() {
		log.debug("finding all RoleAuth instances");
		try {
			String queryString = "from RoleAuth";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleAuth merge(RoleAuth detachedInstance) {
		log.debug("merging RoleAuth instance");
		try {
			RoleAuth result = (RoleAuth) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleAuth instance) {
		log.debug("attaching dirty RoleAuth instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleAuth instance) {
		log.debug("attaching clean RoleAuth instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}