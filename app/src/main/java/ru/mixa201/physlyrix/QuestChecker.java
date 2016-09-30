package ru.mixa201.physlyrix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.mixa201.physlyrix.Questionary.Watcher;
import ru.mixa201.physlyrix.R;
import ru.mixa201.physlyrix.fragments.CalculatorFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestChecker extends AppCompatActivity {
    private TextView yfttv,yftv;
    private TextView yattv;
    private EditText yaet;
    private TextView tfttv,tftv;
    private TextView tattv,tatv;
    private TextView rttv, rtv;
    private Button bt;
    private String APP_PATH;
    private String pack;
    private String quest;
    private FragmentManager manager;

    private TextView byId(int id){
        return (TextView)findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_checker);
        Intent intent=getIntent();
        APP_PATH=intent.getStringExtra("APP_PATH");
        pack=intent.getStringExtra("PACKAGE");
        quest=intent.getStringExtra("QUEST");

        manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.calculator_frame,new CalculatorFragment()).commit();


        yfttv=byId(R.id.yfttv);
        yftv=byId(R.id.yftv);
        yattv=byId(R.id.yattv);
        yaet=(EditText)findViewById(R.id.yaet);
        bt=(Button)findViewById(R.id.btCheckNum);
        tfttv=byId(R.id.tfttv);
        tftv=byId(R.id.tftv);
        tattv=byId(R.id.tattv);
        tatv=byId(R.id.tatv);
        rttv=byId(R.id.rttv);
        rtv=byId(R.id.rtv);
        final Intent i=getIntent();
        yftv.setText(i.getStringExtra("CALC"));
        final Double tanswer=i.getDoubleExtra("RESULT",0);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction().replace(R.id.calculator_frame,new Fragment()).commit();
                yfttv.setVisibility(View.GONE);
                yftv.setVisibility(View.GONE);
                yattv.setVisibility(View.GONE);
                yaet.setVisibility(View.GONE);
                bt.setVisibility(View.GONE);
                tfttv.setVisibility(View.VISIBLE);
                tftv.setVisibility(View.VISIBLE);
                tattv.setVisibility(View.VISIBLE);
                tatv.setVisibility(View.VISIBLE);
                rttv.setVisibility(View.VISIBLE);
                rtv.setVisibility(View.VISIBLE);
                Double answer=Double.parseDouble(yaet.getText().toString());
                tftv.setText(i.getStringExtra("TRUE"));
                tatv.setText(""+tanswer);
                int r=0;
                if(yftv.getText().toString().equals(tftv.getText().toString())){
                    r+=3;
                }
                r+= Watcher.check(tanswer,answer);
                rtv.setText(r*4+"/20");
                SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(APP_PATH+"statistics.db",null);
                Date now=new Date();
                SimpleDateFormat format=new SimpleDateFormat("kk:mm dd.MM.yyyy");
                String date=format.format(now);
                db.execSQL("INSERT INTO [History](date, type, package, name, result, maxresult) VALUES ('"+date+"', 'Задача', '"+pack+"', '"+quest+"', "+r*4+", "+20+")");
                Cursor c=db.rawQuery("SELECT * FROM [User]",null);
                c.moveToFirst();
                int ar=c.getInt(1);
                int ae=c.getInt(2);
                db.execSQL("UPDATE [User] SET results=" + (ar + r*4) + ", errors=" + (ae + (20 - r*4)));
                db.close();
            }
        });
    }
}
