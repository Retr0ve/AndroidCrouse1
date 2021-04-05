package xyz.retrove.androidcourse1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    //private MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.content, TabContact.class, null)
                .commit();

        //topAppBar = findViewById(R.id.topAppBar);
        //topAppBar.setOnMenuItemClickListener();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ContactItem:
                        replaceFragment(TabContact.class);
                        return true;
                    case R.id.FriendItem:
                        replaceFragment(TabFriend.class);
                        return true;
                    case R.id.MsgItem:
                        replaceFragment(TabMsg.class);
                        return true;
                    case R.id.SettingItem:
                        replaceFragment(TabSetting.class);
                        return true;
                    default:
                        break;
                }

                return false;
            }
        });
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button:
//                replaceFragment(new AnotherRightFragment());
//                break;
//            default:
//                break;
//        }
//    }

    private void replaceFragment(Class fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment, null)
                .setReorderingAllowed(true)
                .commit();
    }

}