Andorid 4 技术实现文档
成员：尹业立 16301054 陈建 16301031

使用API：cursor,ArraryList等

具体实现：为文章显示，日程记录，教练资料分别创建BaseHelper类
以文章显示为例：public class gymarticleBaseHelper extends SQLiteOpenHelper 
插入数据后 创建model以更易操作：gymarticleBean类 gymarticleLab类
gymarticleLab gLab=gymarticleLab.getInstance();
 if (gLab.getLen() <= 0) {
            gymarticleBaseHelper dbHelper = new gymarticleBaseHelper(articleActivity.this, "gymarticle", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("gymarticle", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i <=cursor.getColumnCount(); i++) {
                gLab.add(new gymarticleBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
            }
            cursor.close();
}
实现一个activity内只调用一次创建语句，将数据内容存储于容器中，查找数据仅需调用接口，十分方便。