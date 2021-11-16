package com.example.ruwa.mockservertest.presenter;

import com.example.ruwa.mockservertest.model.Hero;
import com.example.ruwa.mockservertest.model.ResponseDetails;
import com.example.ruwa.mockservertest.service.ApiService;
import com.example.ruwa.mockservertest.service.TestService;
import com.example.ruwa.mockservertest.view.MainView;

import java.util.List;

public class MainActivityPresenter implements MainPresenter {

    private ApiService apiService;

    private MainView view;

    TestService service;

    public MainActivityPresenter(MainView v){
        this.view = v;
        service = new TestService();
    }

    @Override
    public void callService() {
        view.showProgressBar(true);
        service.getHeroes(new TestService.ServiceCallback<List<Hero>>() {
            @Override
            public void onResponse(List<Hero> responseDetails, int statusCode) {
              //  view.showResponse(responseDetails.getResponse(), statusCode);
                view.showResponse(responseDetails.get(0).getName(), statusCode,responseDetails);
                view.showProgressBar(false);
            }

            @Override
            public void onFailure(String message) {
                view.showProgressBar(false);
            }
        });
    }
}
