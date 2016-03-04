package com.flurry.lauraxu.flurryapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.PurchaseEvent;

/**
 * A placeholder fragment containing a simple view.
 */
public class FlurryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flurry, container, false);
        Button crashButton = (Button) rootView.findViewById(R.id.crash_button);
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("This is a crash");
            }
        });

        Button buyButton = (Button) rootView.findViewById(R.id.buy_button);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answers.getInstance().logPurchase(new PurchaseEvent());
            }
        });
        return rootView;
    }
}
