package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class gymcoachBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="gymcoach";
    public gymcoachBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE gymcoach(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "time VARCHAR(255)," +
                "thing VARCHAR(255))");

        db.execSQL(
                "INSERT INTO gymcoach(id,time,thing) values(?,?,?)",new Object[] { 1,
                        "尹业立",
                        "性别：男，年龄35岁，山西师范大学毕业，国家体育总局一级社会体育指导员，运动营养师导师，国家健身营养师导师，私人教练培训导师 亚洲形体健身学院培训导师，哥伦比亚运动营养师，私人健身教练行业十年工作经验。尹业立出生于1982年10月，2002年考入山西师范大学，2003年开始接触健身此后开始疯狂吸收各个方面的健身理念。2006年7月14日毕业。两周后即在当年北京唯一的五星健身中心青鸟健身百盛店任教，07年4月至09年6月在青鸟健身百盛店私人教练，学习了先进的训练理论和管理经验。并多次为北京电台拍摄外国人士健身事迹。",
                });

        db.execSQL(
                "INSERT INTO gymcoach(id,time,thing) values(?,?,?)",new Object[] { 2,
                        "张小明",
                        "张小明是一位健身教练，也是一位广场舞老师，1986年8月20日出生于江苏南京，因为教美国人跳“最炫民族风”而受到关注，曾上过《快乐大本营》《天天向上》等综艺节目，2006年12月被聘请黄金甲电影发布和监票房一职。2007年 北京电台拍摄的加拿大人在北京，担任加拿大人教练一职。2008年 被青鸟健身选为优秀员工，外派香港学习先进训练理念和管理经验。2009年 被青鸟健身聘为部门经理兼训导师。2010年 nsca-cpt美国体能协会私人教练2011年 nike签约教练2012年 学习3个月到12岁早期体育教育。2013年 学习最流行的高强度交叉训练crossfit。",
                });

    }
     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}

