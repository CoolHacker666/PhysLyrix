package ru.mixa201.physlyrix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

import ru.mixa201.physlyrix.R;

public class StatisticActivity extends AppCompatActivity {
    private ListView lv;
    private TextView mb;
    private TextView me;
    private String APP_PATH;
    private Vector<Integer> ids=new Vector<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        setTitle("Статистика");
        lv=(ListView)findViewById(R.id.historyView);
        mb=(TextView)findViewById(R.id.myBalls);
        me=(TextView)findViewById(R.id.myErrors);
        Intent intent=getIntent();
        APP_PATH=intent.getStringExtra("APP_PATH");
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(APP_PATH+"statistics.db", null);
        Cursor c=db.rawQuery("SELECT * FROM [History]",null);
        c.move(0);
        Vector<String> v=new Vector<String>();
        while(c.moveToNext()){
            v.add(c.getString(4)+" ("+c.getInt(5)+"/"+c.getInt(6)+")");
            ids.add(c.getInt(0));
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,v);
        lv.setAdapter(a);
        Cursor c1=db.rawQuery("SELECT * FROM [User]",null);
        c1.moveToFirst();
        Log.i("scores & errors",c1.getInt(1)+" "+c1.getInt(2));
        mb.setText(""+c1.getInt(1));
        me.setText(""+c1.getInt(2));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent();
                i.putExtra("APP_PATH", APP_PATH);
                i.putExtra("id", ids.get(position));
                i.setClass(getApplicationContext(), DetailsActivity.class);
                startActivity(i);
            }
        });
    }
}
