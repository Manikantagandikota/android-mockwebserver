package com.example.ruwa.mockservertest.view;

import com.example.ruwa.mockservertest.model.Hero;

import java.util.List;

public interface MainView {

    void showResponse(String response, int statusCode, List<Hero> responseDetails);

    void showProgressBar(boolean show);
}
