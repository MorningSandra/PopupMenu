package cn.edu.bistu.cs.se.popupmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PopupMenu popupMenu;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        popupMenu = new PopupMenu(this, findViewById(R.id.popupmenu_btn));
        menu = popupMenu.getMenu();


        // 通过代码添加菜单项

        menu.add(Menu.NONE, Menu.FIRST + 0, 0, "文本文档");
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "RTF");

        // 通过XML文件添加菜单项

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_popup, menu);
        // 监听事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case Menu.FIRST + 0:
                        Toast.makeText(MainActivity.this, "新建文本文档",
                                Toast.LENGTH_LONG).show();
                        break;
                    case Menu.FIRST + 1:
                        Toast.makeText(MainActivity.this, "新建RTF文件",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.file:
                        Toast.makeText(MainActivity.this, "新建文件夹",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.shortcut:
                        Toast.makeText(MainActivity.this, "新建快捷方式",
                                Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    public void popupmenu(View v) {
        popupMenu.show();
    }
}