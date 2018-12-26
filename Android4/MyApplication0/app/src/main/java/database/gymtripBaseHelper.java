package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class gymtripBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="gymtrip";
    public gymtripBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE gymtrip(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "time VARCHAR(255)," +
                "thing VARCHAR(255))");

        db.execSQL(
                "INSERT INTO gymtrip(id,time,thing) values(?,?,?)",new Object[] { 1,
                        "2018-12-20",
                        "健身内容：T25健身（速度1.0）；提踵40次（20次/组）；前后踮脚尖40次（20次/组）\n" +
                                "健身时长：40分钟\n" +
                                "今天的健身主要做了T25的速度1.0、提踵和前后踮脚尖，主要以锻炼小腿部肌肉群为主。腿部肌肉的锻炼比较关键，可能刚开始的时候会很痛苦特别是健身完后第二天会感觉小腿酸胀甚至走路都会受影响。但一定不要因此就停下，就算腿疼也要继续坚持这样两三天之后腿部肌肉会慢慢适应不再疼。",
         });

        db.execSQL(
                "INSERT INTO gymtrip(id,time,thing) values(?,?,?)",new Object[] { 2,
                        "2018-12-22",
                        "健身内容：T25健身（下半身集中训练）；提踵40次（20次/组）；木乃伊跳40次（20次/组）；小腿拉伸\n" +
                                "健身时长：40分钟\n" +
                                "今天的健身主要以T25下半身集中训练、提踵和木乃伊跳为主，重点是要锻炼腿部的力量。开始之前建议大家先进行简单的热身，特别是腿部可以采取侧压腿和高抬腿让腿部肌肉快速适应。\n" +
                                "\n" +
                                "T25中的弓步压腿难度较大而且容易感到小腿肌肉酸疼，一定要按照标准动作坚持做完，这样对于增强腿部肌肉很有帮助而且为以后的健身打下基础。",
                });



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}