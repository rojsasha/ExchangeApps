package alex.example.com.exchangeapps.ui.main;

import android.support.annotation.NonNull;

import alex.example.com.exchangeapps.R;
import alex.example.com.exchangeapps.data.entity.ExchangeModel;
import alex.example.com.exchangeapps.data.entity.Rates;
import alex.example.com.exchangeapps.data.internet.ExchangeInterface;
import alex.example.com.exchangeapps.ui.main.MainContract;
import alex.example.com.exchangeapps.utils.StringResourses;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private ExchangeInterface mService;
    private StringResourses mStringResourses;

    MainPresenter(ExchangeInterface service, StringResourses stringResourses) {
        mService = service;
        mStringResourses = stringResourses;
    }

    @Override
    public void bind(MainContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    @Override
    public void getExchangeRates() {
        mView.showProgress();
        mService.getRates(mStringResourses.getString(R.string.API_KEY))
                .enqueue(new Callback<ExchangeModel>() {
                    @Override
                    public void onResponse(@NonNull Call<ExchangeModel> call, @NonNull Response<ExchangeModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            if (isViewAttached())
                                convertCourses(response.body().getRates());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ExchangeModel> call, @NonNull Throwable t) {

                    }
                });
        mView.hideProgress();
    }

    private void convertCourses(Rates rates) {
        Double usd = rates.getrUB() / rates.getuSD();
        Double euro = rates.getrUB();
        Double gbp = rates.getrUB() / rates.getgBP();
        Double cnf = rates.getrUB() / rates.getcHF();
        rates.setuSD(usd);
        rates.setEuro(euro);
        rates.setgBP(gbp);
        rates.setcHF(cnf);
        mView.onSuccess(rates);
    }

    private boolean isViewAttached() {
        return mView != null;
    }
//
//    private void parseGson(JsonObject body) {
//        JsonObject jsonObject = body.getAsJsonObject("rates");
//        ArrayList<String> currencyValues = new ArrayList<>();
//        Object[] currencyTitle = jsonObject.keySet().toArray();
//        for (Object aStringsList : currencyTitle) {
//            currencyValues.add(String.valueOf(jsonObject.get(String.valueOf(aStringsList))));
//        }
//
//
//
//        mView.onSuccess(currencyTitle, currencyValues);
//    }
}
