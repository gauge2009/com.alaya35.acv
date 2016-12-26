package org.tinygroup.dalpractice.keygenerate;

import org.apache.commons.lang.math.RandomUtils;
import org.tinygroup.tinysqldsl.KeyGenerator;
import org.tinygroup.tinysqldsl.base.InsertContext;

public class MyKeyGenerater implements KeyGenerator{

	public <T> T generate(InsertContext insertContext) {
		Integer key=RandomUtils.nextInt();
		return (T) key;
	}

}
