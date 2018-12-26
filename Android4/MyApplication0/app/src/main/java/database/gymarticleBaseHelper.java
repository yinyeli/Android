package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class gymarticleBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="gymarticle";
    public gymarticleBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE gymarticle(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sentence VARCHAR(255)," +
                "word VARCHAR(255))");}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}