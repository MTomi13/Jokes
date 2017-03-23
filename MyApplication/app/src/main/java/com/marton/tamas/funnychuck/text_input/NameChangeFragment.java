package com.marton.tamas.funnychuck.text_input;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.GeneralErrorHandler;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangeFragment extends BaseFragment implements NameChangeView {

    private static final String FILTER_FLAG = "filter";

    @BindView(R.id.personEditText)
    EditText changeNameEditText;

    @BindView(R.id.joke_text)
    TextView jokeTextView;

    @BindView(R.id.progress_ring)
    ProgressBar progressBar;

    @Inject
    NameChangeInteractorImpl nameChangeInteractor;

    @Inject
    NameChangePresenterImpl nameChangePresenter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_name_change;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbarTitle("Change name");
    }

    protected void setToolbarTitle(String title) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(title);
    }

    @OnClick(R.id.btn_submit)
    public void onSubmitButtonCLicked() {
        hideKeyboard();
        String fullName = changeNameEditText.getText().toString().trim();
        nameChangePresenter.getJokesWithChangedName(false, fullName);
    }

    @Override
    public void showJoke(Joke joke) {
        jokeTextView.setText(joke.getJoke());
    }

    @Override
    public void showError(String error) {
        GeneralErrorHandler.showErrorMessage(getActivity(), error);
    }

    @Override
    public void showProgressRing(int visibility) {
        progressBar.setVisibility(visibility);
    }

    public void hideKeyboard() {
        if (getActivity() != null && getActivity().getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }
}