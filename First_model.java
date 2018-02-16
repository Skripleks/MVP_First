package android.mvp_first;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Admin on 2/13/2018.
 */

public class First_model implements First_Presenter {
    Context f_context;
    First_model(Context context){
        f_context = context;
    }

    String en_word;
    String ru_word;





    @Override
    public void give_en_word(String en_word) {
        this.en_word = en_word;
        MyDB myDB = new MyDB(f_context);
        SQLiteDatabase db = myDB.getReadableDatabase();
        Cursor cursor = db.query("WORDS", new String[]{"ENWORD", "RUWORD"}, "ENWORD = ?",new String[]{en_word}, null, null, null, null);

            while (cursor.moveToNext()){
                ru_word = cursor.getString(cursor.getColumnIndex("RUWORD"));
            }
        cursor.close();
            db.close();
            myDB.close();

    }

    @Override
    public String set_en_word() {
        return ru_word;
    }

    @Override
    public void insert(String en_word, String ru_word) {
        MyDB myDB1 = new MyDB(f_context);
        SQLiteDatabase db = myDB1.getWritableDatabase();
        myDB1.insert_word(db, en_word, ru_word);
        db.close();
        myDB1.close();


    }
}
