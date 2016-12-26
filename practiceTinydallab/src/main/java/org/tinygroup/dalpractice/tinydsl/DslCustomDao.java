package org.tinygroup.dalpractice.tinydsl;

import static org.tinygroup.dalpractice.tinydsl.CustomTable.CUSTOM;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;

import java.io.Serializable;
import java.util.List;

import org.tinygroup.dalpractice.CustomDao;
import org.tinygroup.dalpractice.dataobject.CustomDo;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.InsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.SelectGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.UpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.daosupport.TinyDslDaoSupport;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;

public class DslCustomDao extends TinyDslDaoSupport implements CustomDao {

	public CustomDo insertCustom(final CustomDo customDo) {
		return getDslTemplate().insertAndReturnKey(customDo,
				new InsertGenerateCallback<CustomDo>() {
					public Insert generate(CustomDo t) {
						Insert insert = insertInto(CUSTOM).values(
								CUSTOM.NAME.value(customDo.getName()),
								CUSTOM.AGE.value(customDo.getAge()));
						return insert;
					}

				});
	}

	public int updateCustom(CustomDo customDo) {
		return getDslTemplate().update(customDo,
				new UpdateGenerateCallback<CustomDo>() {
					public Update generate(CustomDo customDo) {
						Update update = update(CUSTOM).set(
								CUSTOM.NAME.value(customDo.getName()),
								CUSTOM.AGE.value(customDo.getAge())).where(
								CUSTOM.ID.eq(customDo.getId()));
						return update;
					}
				});
	}

	public int deleteCustomById(int id) {
		return getDslTemplate().deleteByKey(id,
				new DeleteGenerateCallback<Serializable>() {
					public Delete generate(Serializable id) {
						Delete delete = delete(CUSTOM).where(CUSTOM.ID.eq(id));
						return delete;
					}
				});
	}

	public CustomDo getCustomById(int id) {
		return getDslTemplate().getByKey(id, CustomDo.class,
				new SelectGenerateCallback<Serializable>() {
					public Select generate(Serializable id) {
						return selectFrom(CUSTOM).where(CUSTOM.ID.eq(id));
					}
				});
	}

	public List<CustomDo> getAllCustoms() {
		return getDslTemplate().query(new CustomDo(),
				new SelectGenerateCallback<CustomDo>() {
					public Select generate(CustomDo t) {
						return selectFrom(CUSTOM);
					}
				});
	}

}
