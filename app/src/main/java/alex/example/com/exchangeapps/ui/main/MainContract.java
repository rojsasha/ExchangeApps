package alex.example.com.exchangeapps.ui.main;

import alex.example.com.exchangeapps.Lifecycle;
import alex.example.com.exchangeapps.ProgressBarInterface;
import alex.example.com.exchangeapps.data.entity.Rates;

public interface MainContract {
    interface View extends ProgressBarInterface {
        void onSuccess(Rates rates);

        void onError(String msg);

    }

    interface Presenter extends Lifecycle<View> {
        void getExchangeRates();
    }
}
