package com.example.aashu.busreservation;


import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;


public class PaymentFragment extends Fragment {

    TextView add,cadd,nadd;
    private Toolbar mToolbar;
    private CoordinatorLayout coordinatorLayout;
    private Button btnSimpleSnackbar, btnActionCallback, btnCustomView;
    private FloatingActionButton fab;


    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinatorLayout);
        add = (TextView) rootView.findViewById(R.id.address);
       // cadd = (TextView) rootView.findViewById(R.id.caddress);
       // nadd = (TextView) rootView.findViewById(R.id.naddress);

        add.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Bundle args = new Bundle();
                                       PaymentDelivery fragment = new PaymentDelivery();
                                       fragment.setArguments(args);
                                       FragmentManager fragmentManager = getFragmentManager();
                                       fragmentManager.beginTransaction()
                                               .replace(R.id.frame_payment, fragment).addToBackStack(null).commit();
                                   }

                                   });
        cadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                PaymentDelivery fragment=new PaymentDelivery();
                fragment.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_payment, fragment).addToBackStack(null).commit();
            }
        });

        nadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Had a snack at Snackbar", Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener()
                        {
                                    @Override
                                    public void onClick(View view) {
                                    }
                                });
                snackbar.setActionTextColor(Color.RED);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(Color.DKGRAY);
                TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
               // EditText editText= (EditText) snackbarView.findViewById(android.support.design.internal.R.id.snackbar_edittext);
                snackbar.show();
            }
        });

        return rootView;
    }
}