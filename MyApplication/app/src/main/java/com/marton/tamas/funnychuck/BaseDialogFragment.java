package com.marton.tamas.funnychuck;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.view.View;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public abstract class BaseDialogFragment extends BaseFragment implements DialogInterface.OnShowListener {

    protected AlertDialog alertDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Joke_Main_Dialog);
        View view = View.inflate(getContext(), layoutId(), null);
        alertDialog = getDialogBuilder(contextThemeWrapper).setView(view).create();
        alertDialog.setOnShowListener(this);
        return alertDialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().setCanceledOnTouchOutside(false);
    }

    @Override
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    protected abstract AlertDialog.Builder getDialogBuilder(ContextThemeWrapper contextThemeWrapper);
}