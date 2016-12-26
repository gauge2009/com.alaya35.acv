package org.tinygroup.dalpractice.jpa;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.tinygroup.dalpractice.CustomDao;
import org.tinygroup.dalpractice.dataobject.CustomDo;

public class JpaCustomDao extends JpaDaoSupport implements CustomDao {

	public CustomDo insertCustom(CustomDo customDo) {
		getJpaTemplate().persist(customDo);
		return getJpaTemplate().find(CustomDo.class, customDo.getId());
	}
	public int updateCustom(CustomDo customDo) {
		try {
			getJpaTemplate().merge(customDo);
		} catch (DataAccessException e) {
			return 0;
		}
		return 1;
	}

	public int deleteCustomById(int id) {
		try {
			CustomDo customDo=getJpaTemplate().find(CustomDo.class, id);
			getJpaTemplate().remove(customDo);
		} catch (Exception e) {
            return 0;
		}
		return 1;
	}

	public CustomDo getCustomById(int id) {
		return getJpaTemplate().find(CustomDo.class, id);
	}

	public List<CustomDo> getAllCustoms() {
		return getJpaTemplate().find("select c from custom c");
	}
}
