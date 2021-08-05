package com.callor.cacao;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int setting_item=item.getItemId();
        /**
         * MainActivity 에서 호출되어 열린 새로운 Activity에 있는
         * optionMenu 의 item 은
         * "R.id.아이템" 으로 사용하지 않고
         * "android.R.id.아이템" 으로 사용 해야 한다
         */
        if(setting_item==android.R.id.home){
            /**
             * onBackPressed() method 는 이전 화면으로 이동하는 method
             * 현재 Activity 를 닫고 이전 Activity 를 열어주는 method
             * 이 method 가 이전 Activity 를 정확히 인지하도록 Manifest.xml 의
             * 현재 Activity 설정 부분에 다음의 코드를 추가 해주자
             * android:parentActivityName=".MainActivity"
             */
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}