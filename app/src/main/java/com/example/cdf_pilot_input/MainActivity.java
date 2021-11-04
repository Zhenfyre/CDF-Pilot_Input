package com.example.cdf_pilot_input;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int bathroomSinkDrinking;
    int bathroomSinkTeeth;
    int bathroomSinkHandwashing;
    int bathroomSinkNone;
    String timeRunning;
    int tempWaterAchieved;
    String waterColor;
    String waterOdor;
    String waterTaste;
    String hardnessPpm;
    String chlorinePpm;
    String alkalinityPpm;
    String phValue;
    int nitriteUnSafe;
    int nitrateUnSafe;
    String copperPpm;
    String ironPpm;
    int bacteriaPosNeg;
    int pesticidePosNeg;
    int leadPosNeg;
    int rottenEggYN;
    int sedimentYN;
    int featheryYN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitResults(View view) {
        display(0);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.time_running_water);
        quantityTextView.setText("" + number);
    }
}
