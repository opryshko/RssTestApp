package com.geekapps.rsstestapp.ui.categories.audiobooks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekapps.rsstestapp.R;
import com.geekapps.rsstestapp.data.network.pojo.category.MediaItem;
import com.geekapps.rsstestapp.ui.categories.BaseCategoryFragment;
import com.geekapps.rsstestapp.ui.categories.audiobooks.impl.AudiobooksPresenter;
import com.geekapps.rsstestapp.ui.detail_information.DetailInformationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudiobooksFragment extends BaseCategoryFragment implements AudiobooksView {

    @BindView(R.id.reload_data_view)
    View reloadDataView;

    AudiobooksPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_audiobooks, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        presenter = new AudiobooksPresenter(this);
        detailInformationFragment = new DetailInformationFragment();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadTop25Audiobooks();
    }

    @Override
    public void updateMediaItem(MediaItem media) {
        presenter.updateMediaItem(media);
    }

    @Override
    public void showReloadDataView() {
        reloadDataView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideReloadDataView() {
        reloadDataView.setVisibility(View.GONE);
    }

    @Override
    @OnClick(R.id.tv_try_again)
    public void onClickTryAgain() {
        presenter.loadTop25Audiobooks();
    }
}
