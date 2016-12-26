package org.tinygroup.dalpractice;

import java.util.List;

import org.tinygroup.dalpractice.dataobject.CustomDo;
import org.tinygroup.dalpractice.tinydsl.DslCustomDao;
import org.tinygroup.dalpractice.tinydsl.TinyDslCustomDao;

public class TinyDslTest extends BaseTest {

	public void testCrud() {
		CustomDo customDo = new CustomDo();
		customDo.setAge(11);
		customDo.setName("tinydsl");

		customDao = applicationContext.getBean("tinyDslCustomDao",
				TinyDslCustomDao.class);

		customDo = customDao.insertCustom(customDo);

		assertNotNull(customDo.getId());

		customDo.setName("tinydsl1");
		customDo.setAge(12);
		int affect = customDao.updateCustom(customDo);
		assertEquals(1, affect);

		CustomDo customDo2 = customDao.getCustomById(customDo.getId());
		assertEquals(12, customDo2.getAge());
		assertEquals("tinydsl1", customDo2.getName());

		List<CustomDo> customs = customDao.getAllCustoms();
		assertEquals(1, customs.size());

		affect = customDao.deleteCustomById(customDo.getId());
		assertEquals(1, affect);
	}

	public void testCrud2() {
		CustomDo customDo = new CustomDo();
		customDo.setAge(11);
		customDo.setName("tinydsl");

		customDao = applicationContext.getBean("dslCustomDao",
				DslCustomDao.class);

		customDo = customDao.insertCustom(customDo);

		assertNotNull(customDo.getId());

		customDo.setName("tinydsl1");
		customDo.setAge(12);
		int affect = customDao.updateCustom(customDo);
		assertEquals(1, affect);

		CustomDo customDo2 = customDao.getCustomById(customDo.getId());
		assertEquals(12, customDo2.getAge());
		assertEquals("tinydsl1", customDo2.getName());

		List<CustomDo> customs = customDao.getAllCustoms();
		assertEquals(1, customs.size());

		affect = customDao.deleteCustomById(customDo.getId());
		assertEquals(1, affect);
	}
}
