package alex.example.com.exchangeapps.data.internet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static alex.example.com.exchangeapps.AppConstansts.BASE_URL;

public class RetrofitConnection {
    private static ExchangeInterface mService = null;

    public static ExchangeInterface initRetrofit(){
        if (mService == null){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ExchangeInterface.class);
        }
        return mService;
    }
}
