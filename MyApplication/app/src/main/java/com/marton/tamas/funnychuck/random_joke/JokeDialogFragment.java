package com.marton.tamas.funnychuck.random_joke;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marton.tamas.funnychuck.BaseDialogFragment;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.util.Constants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokeDialogFragment extends BaseDialogFragment implements JokeContentView {

    private TextView textView;
    private ProgressBar progressBar;

    @Inject
    JokeInteractorImpl jokeInteractor;

    @Inject
    JokeDialogPresenterImpl jokeDialogPresenter;

    public static JokeDialogFragment getInstance(boolean isFilter) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.FILTER_FLAG, isFilter);
        JokeDialogFragment jokeDialogFragment = new JokeDialogFragment();
        jokeDialogFragment.setArguments(bundle);
        return jokeDialogFragment;
    }

    @Override
    protected AlertDialog.Builder getDialogBuilder(ContextThemeWrapper contextThemeWrapper) {
        return new AlertDialog.Builder(contextThemeWrapper)
                .setTitle(R.string.joke_dialog_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_joke_dialog;
    }

    @Override
    public void onShow(DialogInterface dialogInterface) {
        textView = ButterKnife.findById(alertDialog, R.id.joke);
        progressBar = ButterKnife.findById(alertDialog, R.id.progress_ring);
        jokeDialogPresenter.getJokes(isFilter, 1);
    }

    @Override
    public void showJokes(ArrayList<Joke> jokes) {
        textView.setText(jokes.get(0).getJoke());
    }

    @Override
    public void showError(String error) {
        textView.setText(error);
    }

    @Override
    public void showProgressRing(int visibility) {
        progressBar.setVisibility(visibility);
    }
}