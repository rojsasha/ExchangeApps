package alex.example.com.exchangeapps.utils;

import android.content.Context;

public class StringResourses {
    private Context mContext;

    public StringResourses(Context context) {
        mContext = context;
    }

    public String getString(int resId) {
        return mContext.getString(resId);
    }
}
