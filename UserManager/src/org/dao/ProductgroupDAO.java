package org.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.Productgroup;

/**
 * A data access object (DAO) providing persistence and search support for
 * Productgroup entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.vo.Productgroup
 * @author MyEclipse Persistence Tools
 */

public class ProductgroupDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProductgroupDAO.class);
	// property constants
	public static final String COMPANY_ID = "companyId";
	public static final String USER_ID = "userId";
	public static final String NAME = "name";
	public static final String MEMO = "memo";
	public static final String ORDER_NO = "orderNo";

	public void save(Productgroup transientInstance) {
		log.debug("saving Productgroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Productgroup persistentInstance) {
		log.debug("deleting Productgroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Productgroup findById(java.lang.Integer id) {
		log.debug("getting Productgroup instance with id: " + id);
		try {
			Productgroup instance = (Productgroup) getSession().get(
					"org.vo.Productgroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Productgroup> findByExample(Productgroup instance) {
		log.debug("finding Productgroup instance by example");
		try {
			List<Productgroup> results = (List<Productgroup>) getSession()
					.createCriteria("org.vo.Productgroup")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Productgroup instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Productgroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Productgroup> findByCompanyId(Object companyId) {
		return findByProperty(COMPANY_ID, companyId);
	}

	public List<Productgroup> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Productgroup> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Productgroup> findByMemo(Object memo) {
		return findByProperty(MEMO, memo);
	}

	public List<Productgroup> findByOrderNo(Object orderNo) {
		return findByProperty(ORDER_NO, orderNo);
	}

	public List findAll() {
		log.debug("finding all Productgroup instances");
		try {
			String queryString = "from Productgroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Productgroup merge(Productgroup detachedInstance) {
		log.debug("merging Productgroup instance");
		try {
			Productgroup result = (Productgroup) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Productgroup instance) {
		log.debug("attaching dirty Productgroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Productgroup instance) {
		log.debug("attaching clean Productgroup instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}