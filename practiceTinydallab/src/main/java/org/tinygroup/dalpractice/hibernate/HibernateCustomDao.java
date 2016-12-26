package org.tinygroup.dalpractice.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.tinygroup.dalpractice.CustomDao;
import org.tinygroup.dalpractice.dataobject.CustomDo;

public class HibernateCustomDao extends HibernateDaoSupport implements
		CustomDao {

	public CustomDo insertCustom(CustomDo customDo) {
		Integer id = (Integer) getHibernateTemplate().save("custom",customDo);
		customDo.setId(id);
		return customDo;
	}

	public int updateCustom(CustomDo customDo) {
		try {
			getHibernateTemplate().update("custom",customDo);
		} catch (DataAccessException e) {
			return 0;
		}
		return 1;
	}

	public int deleteCustomById(final int id) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("delete from custom where id=?")
						.setInteger(0, id).executeUpdate();
			}
		});

	}

	public CustomDo getCustomById(int id) {
		return (CustomDo) getHibernateTemplate().get("custom", id);
	}

	public List<CustomDo> getAllCustoms() {
		return getHibernateTemplate().loadAll(CustomDo.class);
	}
}
