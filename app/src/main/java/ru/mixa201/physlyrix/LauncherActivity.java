package ru.mixa201.physlyrix;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.mixa201.physlyrix.fragments.AboutFragment;
import ru.mixa201.physlyrix.fragments.ExamFragment;
import ru.mixa201.physlyrix.fragments.NotFoundFragment;
import ru.mixa201.physlyrix.fragments.QuestionnaryFragment;
import ru.mixa201.physlyrix.fragments.SettingsFragment;
import ru.mixa201.physlyrix.fragments.StatisticsFragment;
import ru.mixa201.physlyrix.fragments.TestFragment;
import ru.mixa201.physlyrix.fragments.TextbookFragment;

public class LauncherActivity extends AppCompatActivity {
    private String[] menuTitles;
    private ListView drawer;
    private DrawerLayout layout;
    private FragmentManager manager;
    private Fragment about_fragment;
    private Fragment notFoundFragment;
    private Fragment test_fragment;
    private Fragment textbook_fragment;
    private Fragment questionnary_fragment;
    private Fragment exam_fragment;
    private Fragment statictics_fragment;
    private Fragment settings_fragment;
    public static String APP_PATH=Environment.getExternalStorageDirectory().getPath()+"/android/data/ru.mixa201.physlyrix/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        menuTitles = getResources().getStringArray(R.array.main_menu_items);
        drawer = (ListView) findViewById(R.id.left_drawer);
        layout=(DrawerLayout)findViewById(R.id.drawer_layout);

        manager=getSupportFragmentManager();
        about_fragment=new AboutFragment();
        notFoundFragment=new NotFoundFragment();
        test_fragment=new TestFragment();
        textbook_fragment=new TextbookFragment();
        questionnary_fragment=new QuestionnaryFragment();
        exam_fragment=new ExamFragment();
        statictics_fragment=new StatisticsFragment();
        settings_fragment=new SettingsFragment();

        about();

        drawer.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, menuTitles));
        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:{
                        about();
                        break;
                    }
                    case 1:{
                        test();
                        break;
                    }
                    case 2:{
                        textbook();
                        break;
                    }
                    case 3:{
                        questionnary();
                        break;
                    }
                    case 4:{
                        exam();
                        break;
                    }
                    case 5:{
                        statistics();
                        break;
                    }
                    case 6:{
                        settings();
                        break;
                    }
                    default:{
                        not_found();
                        break;
                    }
                }
                drawer.setItemChecked(position,true);
                layout.closeDrawer(drawer);
            }
        });
    }

    public void about(){
        setTitle("PhysLyrix/О приложении");
        manager.beginTransaction().replace(R.id.content_frame,about_fragment).commit();
    }

    public void not_found(){
        setTitle("PhysLyrix/Не найдено");
        manager.beginTransaction().replace(R.id.content_frame,notFoundFragment).commit();
    }
    public void test(){
        setTitle("PhysLyrix/Тесты");
        manager.beginTransaction().replace(R.id.content_frame,test_fragment).commit();
    }
    public void textbook(){
        setTitle("PhysLyrix/Учебник");
        manager.beginTransaction().replace(R.id.content_frame,textbook_fragment).commit();
    }
    public void questionnary(){
        setTitle("PhysLyrix/Задачник");
        manager.beginTransaction().replace(R.id.content_frame,questionnary_fragment).commit();
    }
    public void exam(){
        setTitle("PhysLyrix/Контрольные");
        manager.beginTransaction().replace(R.id.content_frame,exam_fragment).commit();
    }
    public void statistics(){
        setTitle("PhysLyrix/Статистика");
        manager.beginTransaction().replace(R.id.content_frame,statictics_fragment).commit();
    }
    public void settings(){
        setTitle("PhysLyrix/Настройки");
        manager.beginTransaction().replace(R.id.content_frame,settings_fragment).commit();
    }
}
