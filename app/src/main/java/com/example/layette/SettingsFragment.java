package com.example.layette;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.DialogFragment;

public class SettingsFragment extends DialogFragment {

    Switch darkmode_switch;
    SharedPreferences darkModeState;

    public SettingsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_settings, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        darkmode_switch = view.findViewById(R.id.darkmode_switch);
        darkModeState = view.getContext().getSharedPreferences("darkmode", Context.MODE_PRIVATE);

        darkmode_switch.setChecked(darkModeState.getBoolean("darkmode",false));

        darkmode_switch.setOnClickListener(v -> {

            SharedPreferences.Editor editor = darkModeState.edit();

            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                editor.putBoolean("darkmode",false);
                editor.apply();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putBoolean("darkmode",true);
                editor.apply();
            }
        });



    }

}
