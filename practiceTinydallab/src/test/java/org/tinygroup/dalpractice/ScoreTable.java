package org.tinygroup.dalpractice;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

/**
 * Created by luoguo on 2015/3/11.
 */
public class ScoreTable extends Table {
    public static final ScoreTable TSCORE = new ScoreTable();
    public final Column ID = new Column(this, "id");
    public final Column NAME = new Column(this, "name");
    public final Column SCORE = new Column(this, "score");
    public final Column COURSE = new Column(this, "course");
    public final Column CUSTOMID = new Column(this,"customid");
    private ScoreTable() {
        super("score");
    }
}
