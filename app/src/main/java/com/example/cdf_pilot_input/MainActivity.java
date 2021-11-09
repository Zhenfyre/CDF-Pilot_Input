package com.example.cdf_pilot_input;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app collects water testing results and prepares and email for submission
 */
public class MainActivity extends AppCompatActivity {
/*
    String dateWaterCollected;
    String timeWaterCollected;
    String tabletNumber;
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
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitResults(View view) {

        // Get participant ID number
        EditText tabletNumberField = (EditText) findViewById(R.id.tablet_number);
        Editable tabletNumberEditable = tabletNumberField.getText();
        String tabletNumber = tabletNumberEditable.toString();

        // Get status of water used for drinking checkbox
        CheckBox drinkingCheckbox = (CheckBox) findViewById(R.id.checkBoxDrinking);
        boolean usedForDrinking = drinkingCheckbox.isChecked();
        Log.v("MainActivity", "Used for drinking: " + usedForDrinking);

        // Get status of water used for brushing checkbox
        CheckBox brushingCheckbox = (CheckBox) findViewById(R.id.checkBoxBrushingTeeth);
        boolean usedForBrushing = brushingCheckbox.isChecked();
        Log.v("MainActivity", "Used for brushing: " + usedForBrushing);

        // Get status of water used for handwashing checkbox
        CheckBox handwashingCheckbox = (CheckBox) findViewById(R.id.checkBoxHandwashing);
        boolean usedForHandwashing = handwashingCheckbox.isChecked();
        Log.v("MainActivity", "Used for handwashing: " + usedForHandwashing);

        // Get status of water used for none checkbox
        CheckBox noneCheckbox = (CheckBox) findViewById(R.id.checkBoxNone);
        boolean usedForNone = noneCheckbox.isChecked();
        Log.v("MainActivity", "Used for None: " + usedForNone);

        boolean noneDrinking = usedForDrinking;
        boolean noneHandwashing = usedForHandwashing;
        boolean noneBrushing = usedForBrushing;

        if (usedForNone) {
            noneDrinking = false;
            noneHandwashing = false;
            noneBrushing = false;
        }

        Log.v("MainActivity", "Used for drinking: " + noneDrinking);
        Log.v("MainActivity", "Used for brushing: " + noneBrushing);
        Log.v("MainActivity", "Used for handwashing: " + noneHandwashing);

        // Display the results summary
        String message = createResultsSummary(tabletNumber, noneDrinking, noneBrushing, noneHandwashing, usedForNone);

        // Display results summary to the screen
        display(message);
    }

    /**
     * Create summary of the results.
     *
     * @param participantID            on the order
     * @return text summary
     */
    private String createResultsSummary(String participantID, Boolean drinking, Boolean brushing, Boolean handwashing, Boolean none) {
        String summaryMessage = "\n " + participantID;
        summaryMessage += "\n " + getString(R.string.drinking) + ":" + drinking;
        summaryMessage += "\n " + getString(R.string.brushing_teeth) + ":" + brushing;
        summaryMessage += "\n " + getString(R.string.handwashing) + ":" + handwashing;
        summaryMessage += "\n " + getString(R.string.none) + ":" + none;

        return summaryMessage;
    }

    /**
     * This method displays the summary to the screen.
     */
    private void display(String summary) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary);
        summaryTextView.setText("Summary: \n" + summary);
        summaryTextView.setVisibility(View.VISIBLE);

    }

}
