
package alex.example.com.exchangeapps.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {


    @SerializedName("CHF")
    @Expose
    private Double cHF;
    @SerializedName("GBP")
    @Expose
    private Double gBP;
    @SerializedName("RUB")
    @Expose
    private Double rUB;
    @SerializedName("USD")
    @Expose
    private Double uSD;

    private Double euro;

    public Double getEuro() {
        return euro;
    }

    public void setEuro(Double euro) {
        this.euro = euro;
    }

    public Double getcHF() {
        return cHF;
    }

    public void setcHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getgBP() {
        return gBP;
    }

    public void setgBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getrUB() {
        return rUB;
    }

    public void setrUB(Double rUB) {
        this.rUB = rUB;
    }

    public Double getuSD() {
        return uSD;
    }

    public void setuSD(Double uSD) {
        this.uSD = uSD;
    }
}
