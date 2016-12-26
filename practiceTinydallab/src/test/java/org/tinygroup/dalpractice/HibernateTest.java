package org.tinygroup.dalpractice;

import java.util.List;

import org.tinygroup.dalpractice.dataobject.CustomDo;
import org.tinygroup.dalpractice.hibernate.HibernateCustomDao;

public class HibernateTest extends BaseTest {
	public void testCrud() {

		CustomDo customDo = new CustomDo();
		customDo.setAge(11);
		customDo.setName("hibernate");

		customDao = applicationContext.getBean("hibernateCustomDao",
				HibernateCustomDao.class);

		customDo = customDao.insertCustom(customDo);

		assertNotNull(customDo.getId());

//		customDo.setName("hibernate1");
//		customDo.setAge(12);
//		int affect = customDao.updateCustom(customDo);
//		assertEquals(1, affect);
//
//		CustomDo customDo2 = customDao.getCustomById(customDo.getId());
//		assertEquals(12, customDo2.getAge());
//		assertEquals("hibernate1", customDo2.getName());
//
//		List<CustomDo> customs = customDao.getAllCustoms();
//		assertEquals(1, customs.size());
//
//		affect=customDao.deleteCustomById(customDo.getId());
//		assertEquals(1, affect);
	}
}
