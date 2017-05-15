package com.prew.liveat500px.datatype;

import android.os.Bundle;

/**
 * Created by Prew on 3/9/2017.
 */

public class MutableInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MutableInteger(int value) {
        this.value = value;
    }

    public Bundle onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("value",value);
        return bundle;
    }

    public void onRestoreInstanceState(Bundle saveInstanceState)
    {
        value = saveInstanceState.getInt("value");
    }
}
