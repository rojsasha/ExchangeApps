package alex.example.com.exchangeapps.ui.about;

import android.os.Bundle;

import alex.example.com.exchangeapps.R;
import alex.example.com.exchangeapps.base.BaseActivity;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initToolbar();
        backArrowEnable();
    }
}
