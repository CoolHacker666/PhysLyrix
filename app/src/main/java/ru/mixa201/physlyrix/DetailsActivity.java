package ru.mixa201.physlyrix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.mixa201.physlyrix.R;

public class DetailsActivity extends AppCompatActivity {
    private String APP_PATH;
    private TextView td;
    private TextView tt;
    private TextView tp;
    private TextView tn;
    private TextView ts;
    private Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        td=(TextView)findViewById(R.id.tvDate);
        tt=(TextView)findViewById(R.id.tvType);
        tp=(TextView)findViewById(R.id.tvPackage);
        tn=(TextView)findViewById(R.id.tvName);
        ts=(TextView)findViewById(R.id.tvScores);
        btOk=(Button)findViewById(R.id.btFinishReview);
        Intent intent=getIntent();
        APP_PATH=intent.getStringExtra("APP_PATH");
        int id=intent.getIntExtra("id",-1);
        SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(APP_PATH + "statistics.db", null);
        Cursor c=db.rawQuery("SELECT * FROM [History] WHERE id="+id,null);
        c.moveToFirst();
        td.setText("Дата: " + c.getString(1));
        tt.setText("Тип: " + c.getString(2));
        tp.setText("Пакет: " + c.getString(3));
        tn.setText("Имя: " + c.getString(4));
        ts.setText("Результат: " + c.getInt(5) + "/" + c.getInt(6));
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
