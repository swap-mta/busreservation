package com.example.aashu.busreservation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
    TextView add, cadd, nadd;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.frame_payment);
         //setContentView(R.layout.fragment_payment);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment= null;

        switch (position) {
            case 0:
                fragment = new PaymentFragment();
                break;
            case 1:
                fragment = new PaymentFragment();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;


            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_payment, fragment).addToBackStack(null).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
