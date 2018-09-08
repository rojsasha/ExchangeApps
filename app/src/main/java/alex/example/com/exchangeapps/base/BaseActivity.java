package alex.example.com.exchangeapps.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import alex.example.com.exchangeapps.R;

public abstract class BaseActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;

    protected void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    protected void backArrowEnable() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected void showProgressbar(){
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.VISIBLE);

    }

    protected void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}
