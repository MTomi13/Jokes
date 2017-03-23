package com.marton.tamas.funnychuck.text_input;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.common.BaseJokeView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangeFragment extends BaseFragment implements BaseJokeView<Joke> {

    @BindView(R.id.personEditText)
    EditText editText;

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

    @Override
    public void showJokes(ArrayList<Joke> jokes) {

    }

    @Override
    public void showError(String error) {

    }
}