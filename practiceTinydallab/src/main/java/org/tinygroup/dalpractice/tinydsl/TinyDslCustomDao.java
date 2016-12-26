package org.tinygroup.dalpractice.tinydsl;

import static org.tinygroup.dalpractice.tinydsl.CustomTable.CUSTOM;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;

import java.util.List;

import org.tinygroup.dalpractice.CustomDao;
import org.tinygroup.dalpractice.dataobject.CustomDo;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.DslSession;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;

public class TinyDslCustomDao implements CustomDao {
	
	private DslSession dslSession;
	
	public void setDslSession(DslSession dslSession) {
		this.dslSession = dslSession;
	}
	public CustomDo insertCustom(CustomDo customDo) {
		Insert insert = insertInto(CUSTOM).values(
		        CUSTOM.NAME.value(customDo.getName()),
				CUSTOM.AGE.value(customDo.getAge()));
		return dslSession.executeAndReturnObject(insert, CustomDo.class);
	}

	public int updateCustom(CustomDo customDo) {
		Update update = update(CUSTOM).set(CUSTOM.NAME.value(customDo.getName()),
				CUSTOM.AGE.value(customDo.getAge())).where(
				CUSTOM.ID.eq(customDo.getId()));
		return dslSession.execute(update);
	}

	public int deleteCustomById(int id) {
		Delete delete = delete(CUSTOM).where(CUSTOM.ID.eq(id));
		return dslSession.execute(delete);
	}
	public CustomDo getCustomById(int id) {
		Select select = selectFrom(CUSTOM).where(CUSTOM.ID.eq(id));
		return dslSession.fetchOneResult(select, CustomDo.class);
	}

	public List<CustomDo> getAllCustoms() {
		Select select = selectFrom(CUSTOM);
		return dslSession.fetchList(select, CustomDo.class);
	}
}
