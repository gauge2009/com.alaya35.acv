package org.tinygroup.dalpractice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.tinygroup.commons.tools.Resources;
import org.tinygroup.tinytestutil.script.ScriptRunner;


public abstract class BaseTest extends TestCase {

	protected  static AbstractRefreshableConfigApplicationContext applicationContext;
	
	protected CustomDao customDao;
	
	private static final String DEFAULT_CONFIG_LOCATION = "classpath*:*.beans.xml";

	private static boolean inited;
	
	
	@Override
	protected void setUp() throws Exception {
		if(!inited){
			applicationContext=new FileSystemXmlApplicationContext();
			applicationContext.setConfigLocation(DEFAULT_CONFIG_LOCATION);
			applicationContext.refresh();
			initTable();
			inited=true;
		}
	}
	
	private void initTable() throws IOException, Exception {
		Connection conn = null;
		try {
			DataSource dataSource = (DataSource) applicationContext
					.getBean("dataSource");
			conn = dataSource.getConnection();
			ScriptRunner runner = new ScriptRunner(conn, false, false);
			// 设置字符集
			Resources.setCharset(Charset.forName("utf-8"));
			// 加载sql脚本并执行
			//runner.runScript(Resources.getResourceAsReader("table_derby.sql"));
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					fail(e.getMessage());
				}
			}
		}

	}
	
}
