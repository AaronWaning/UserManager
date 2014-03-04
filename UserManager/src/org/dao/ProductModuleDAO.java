package org.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vo.ProductModule;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProductModule entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.vo.ProductModule
 * @author MyEclipse Persistence Tools
 */

public class ProductModuleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProductModuleDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String MEMO = "memo";
	public static final String ORDER_NO = "orderNo";

	public void save(ProductModule transientInstance) {
		log.debug("saving ProductModule instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProductModule persistentInstance) {
		log.debug("deleting ProductModule instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductModule findById(java.lang.Integer id) {
		log.debug("getting ProductModule instance with id: " + id);
		try {
			ProductModule instance = (ProductModule) getSession().get(
					"org.vo.ProductModule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProductModule> findByExample(ProductModule instance) {
		log.debug("finding ProductModule instance by example");
		try {
			List<ProductModule> results = (List<ProductModule>) getSession()
					.createCriteria("org.vo.ProductModule").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ProductModule instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProductModule as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ProductModule> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<ProductModule> findByMemo(Object memo) {
		return findByProperty(MEMO, memo);
	}

	public List<ProductModule> findByOrderNo(Object orderNo) {
		return findByProperty(ORDER_NO, orderNo);
	}

	public List findAll() {
		log.debug("finding all ProductModule instances");
		try {
			String queryString = "from ProductModule";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProductModule merge(ProductModule detachedInstance) {
		log.debug("merging ProductModule instance");
		try {
			ProductModule result = (ProductModule) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductModule instance) {
		log.debug("attaching dirty ProductModule instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductModule instance) {
		log.debug("attaching clean ProductModule instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}