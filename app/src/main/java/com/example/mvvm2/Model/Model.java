package com.example.mvvm2.Model;

import java.util.Observable;

public class Model extends Observable {
    String data = "Empty string";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (data == null)
            return;

        this.data = data;
        super.setChanged();
        super.notifyObservers();
    }
}
