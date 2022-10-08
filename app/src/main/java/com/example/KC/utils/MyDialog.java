package com.example.KC.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.KC.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MyDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("באיזה מצב אתה רוצה להיות?      ").setMessage("מצב:")
                .setPositiveButton("נותן", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNeutralButton("מתווך", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "עובדים על זה", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("מקבל", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "עובדים על זה", Toast.LENGTH_SHORT).show();
                    }
                });
                return builder.create();
    }
}
