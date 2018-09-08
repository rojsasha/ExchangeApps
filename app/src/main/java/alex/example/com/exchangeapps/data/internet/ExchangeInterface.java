package alex.example.com.exchangeapps.data.internet;

import com.google.gson.JsonObject;

import alex.example.com.exchangeapps.data.entity.ExchangeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static alex.example.com.exchangeapps.AppConstansts.ENDPOINT;

public interface ExchangeInterface {
    @GET(ENDPOINT)
    Call<ExchangeModel> getRates(@Query("access_key") String key);
}
