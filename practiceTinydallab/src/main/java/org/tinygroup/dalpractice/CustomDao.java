package org.tinygroup.dalpractice;

import java.util.List;

import org.tinygroup.dalpractice.dataobject.CustomDo;


/**
 * 客户crud操作的公共接口
 * @author renhui
 *
 */
public interface CustomDao {
	/**
	 * 插入客户
	 */
	public CustomDo insertCustom(CustomDo customDo);
	/**
	 * 更新客户
	 */
	public int updateCustom(CustomDo customDo);
	/**
	 * 根据客户id删除客户
	 */
	public int deleteCustomById(int id);
	/**
	 * 根据客户id查询客户信息
	 */
	public CustomDo getCustomById(int id);
	/**
	 * 返回所有客户信息
	 */
	public List<CustomDo> getAllCustoms();
}
