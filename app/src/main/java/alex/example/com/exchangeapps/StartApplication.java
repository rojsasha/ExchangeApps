package alex.example.com.exchangeapps;

import android.app.Application;
import android.content.Context;

import alex.example.com.exchangeapps.data.internet.ExchangeInterface;
import alex.example.com.exchangeapps.data.internet.RetrofitConnection;

public class StartApplication extends Application {
    private ExchangeInterface mService;

    @Override
    public void onCreate() {
        super.onCreate();
        mService = RetrofitConnection.initRetrofit();
    }

    public static StartApplication get(Context context) {
        return (StartApplication) context.getApplicationContext();
    }

    public ExchangeInterface getService() {
        return mService;
    }
}
