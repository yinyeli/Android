Andorid 4 ����ʵ���ĵ�
��Ա����ҵ�� 16301054 �½� 16301031

ʹ��API��cursor,ArraryList��

����ʵ�֣�Ϊ������ʾ���ճ̼�¼���������Ϸֱ𴴽�BaseHelper��
��������ʾΪ����public class gymarticleBaseHelper extends SQLiteOpenHelper 
�������ݺ� ����model�Ը��ײ�����gymarticleBean�� gymarticleLab��
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
ʵ��һ��activity��ֻ����һ�δ�����䣬���������ݴ洢�������У��������ݽ�����ýӿڣ�ʮ�ַ��㡣