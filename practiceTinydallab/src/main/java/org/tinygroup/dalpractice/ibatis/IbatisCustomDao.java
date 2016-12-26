package org.tinygroup.dalpractice.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.tinygroup.dalpractice.CustomDao;
import org.tinygroup.dalpractice.dataobject.CustomDo;

public class IbatisCustomDao extends SqlMapClientDaoSupport implements
		CustomDao {

	public CustomDo insertCustom(CustomDo customDo) {
		int id=(Integer) getSqlMapClientTemplate().insert("insertCustom", customDo);
		customDo.setId(id);
		return customDo;
	}

	public int updateCustom(CustomDo customDo) {
		return getSqlMapClientTemplate().update("updateCustom", customDo);
	}

	public int deleteCustomById(int id) {
		return getSqlMapClientTemplate().delete("deleteCustomById", id);
	}

	public CustomDo getCustomById(int id) {
		return (CustomDo) getSqlMapClientTemplate().queryForObject("queryCustomById", id);
	}

	public List<CustomDo> getAllCustoms() {
		return getSqlMapClientTemplate().queryForList("queryAllCustoms");
	}

}
