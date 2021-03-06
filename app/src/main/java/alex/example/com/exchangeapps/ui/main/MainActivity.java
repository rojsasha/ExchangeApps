package alex.example.com.exchangeapps.ui.main;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import alex.example.com.exchangeapps.MyBroadcastReceiver;
import alex.example.com.exchangeapps.R;
import alex.example.com.exchangeapps.StartApplication;
import alex.example.com.exchangeapps.base.BaseActivity;
import alex.example.com.exchangeapps.data.entity.Rates;
import alex.example.com.exchangeapps.ui.about.AboutActivity;
import alex.example.com.exchangeapps.utils.StringResourses;

public class MainActivity extends BaseActivity implements MainContract.View {
    private MainContract.Presenter mPresenter;
    private TextView mTvDollar, mTvEuro, mTvFunt, mTvSwiss;
    IntentFilter s_intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);
        initToolbar();
        registerReceiver(m_timeChangedReceiver, setS_intentFilter());
        mTvDollar = findViewById(R.id.tvDollar);
        mTvEuro = findViewById(R.id.tvEuro);
        mTvFunt = findViewById(R.id.tvFunt);
        mTvSwiss = findViewById(R.id.tvSwiss);


        mPresenter = new MainPresenter(StartApplication.get(this).getService(),
                new StringResourses(this));
        mPresenter.bind(this);

        mPresenter.getExchangeRates();

    }

    @Override
    public void onSuccess(Rates rates) {

        mTvDollar.setText(getString(R.string.usd, formatDouble(rates.getuSD())));
        mTvEuro.setText(getString(R.string.euro, formatDouble(rates.getEuro())));
        mTvFunt.setText(getString(R.string.gbp, formatDouble(rates.getgBP())));
        mTvSwiss.setText(getString(R.string.cnf, formatDouble(rates.getcHF())));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private String formatDouble(Double value) {
        return String.format("%.2f", value);
    }

    private IntentFilter setS_intentFilter() {
        s_intentFilter = new IntentFilter();
        s_intentFilter.addAction(Intent.ACTION_DATE_CHANGED);
        return s_intentFilter;
    }

    private final BroadcastReceiver m_timeChangedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(Intent.ACTION_DATE_CHANGED)) {
                mPresenter.getExchangeRates();
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
        unregisterReceiver(m_timeChangedReceiver);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        showProgressbar();
    }

    @Override
    public void hideProgress() {
        hideProgressBar();
    }
}
