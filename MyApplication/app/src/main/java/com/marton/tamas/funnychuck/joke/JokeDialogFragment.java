package com.marton.tamas.funnychuck.joke;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

import com.marton.tamas.funnychuck.BaseDialogFragment;
import com.marton.tamas.funnychuck.R;

import butterknife.ButterKnife;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokeDialogFragment extends BaseDialogFragment {

    public static JokeDialogFragment getInstance() {
        return new JokeDialogFragment();
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
        TextView textView = ButterKnife.findById(alertDialog, R.id.joke);
        textView.setText("Chuck Norris");
    }
}
