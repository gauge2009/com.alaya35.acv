package org.tinygroup.dalpractice;

import java.util.List;

import org.tinygroup.dalpractice.dataobject.CustomDo;
import org.tinygroup.dalpractice.ibatis.IbatisCustomDao;

public class IbatisTest extends BaseTest {
	public void testCrud(){
		CustomDo customDo = new CustomDo();
		customDo.setAge(13);
		customDo.setName("ibatis");

		customDao = applicationContext.getBean("ibatisCustomDao",
				IbatisCustomDao.class);
		
		customDo = customDao.insertCustom(customDo);

		assertNotNull(customDo.getId());

		customDo.setName("ibatis1");
		customDo.setAge(14);
		int affect = customDao.updateCustom(customDo);
		assertEquals(1, affect);

		CustomDo customDo2 = customDao.getCustomById(customDo.getId());
		assertEquals(14, customDo2.getAge());
		assertEquals("ibatis1", customDo2.getName());

		List<CustomDo> customs = customDao.getAllCustoms();
		assertEquals(1, customs.size());
		
		affect=customDao.deleteCustomById(customDo.getId());
		assertEquals(1, affect);
		
	}
}
