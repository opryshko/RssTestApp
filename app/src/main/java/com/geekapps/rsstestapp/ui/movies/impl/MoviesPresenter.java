package com.geekapps.rsstestapp.ui.movies.impl;

import com.geekapps.rsstestapp.data.network.pojo.Audiobooks;
import com.geekapps.rsstestapp.mvp.BaseMvpPresenter;
import com.geekapps.rsstestapp.ui.audiobooks.AudiobooksModel;
import com.geekapps.rsstestapp.ui.audiobooks.AudiobooksView;
import com.geekapps.rsstestapp.ui.movies.MoviesModel;
import com.geekapps.rsstestapp.ui.movies.MoviesView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MoviesPresenter extends BaseMvpPresenter {
    private MoviesView view;
    private MoviesModel model;

    public MoviesPresenter(MoviesView view) {
        super(view);
        this.view = view;
        this.model = new MoviesModelImpl();
    }

    public void getTop25Movies() {
        view.showLoading();
        model.getTop25Movies().subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleGetTop25MoviesResponse, this::showError);

    }

    private void handleGetTop25MoviesResponse(Audiobooks audiobooks) {
        view.initRecyclerView(audiobooks);
        view.hideLoading();
    }
}
