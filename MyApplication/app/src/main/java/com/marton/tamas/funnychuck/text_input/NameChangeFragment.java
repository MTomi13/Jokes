package com.marton.tamas.funnychuck.text_input;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.util.Constants;
import com.marton.tamas.funnychuck.util.GeneralErrorHandler;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangeFragment extends BaseFragment implements NameChangeView {

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

    public static NameChangeFragment getInstance(boolean isFilter) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.FILTER_FLAG, isFilter);
        NameChangeFragment nameChangeFragment = new NameChangeFragment();
        nameChangeFragment.setArguments(bundle);
        return nameChangeFragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_name_change;
    }

    @OnClick(R.id.btn_submit)
    public void onSubmitButtonCLicked() {
        hideKeyboard();
        nameChangePresenter.getJokesWithChangedName(isFilter, changeNameEditText.getText().toString().trim());
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
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }
}