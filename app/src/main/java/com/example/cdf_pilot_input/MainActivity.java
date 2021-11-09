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
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * This app collects water testing results and prepares and email for submission
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitResults(View view) {

        // Get date of collection
        EditText dateField = (EditText) findViewById(R.id.collectionDate);
        Editable dateEditable = dateField.getText();
        String dateCollection = dateEditable.toString();

        // Get time of collection
        EditText timeField = (EditText) findViewById(R.id.time_of_day);
        Editable timeEditable = timeField.getText();
        String timeCollection = timeEditable.toString();

        // Get participant ID number
        EditText tabletNumberField = (EditText) findViewById(R.id.tablet_number);
        Editable tabletNumberEditable = tabletNumberField.getText();
        String tabletNumber = tabletNumberEditable.toString();

        // Get time water running
        EditText timeRunningField = (EditText) findViewById(R.id.time_running_water);
        Editable timeRunningEditable = timeRunningField.getText();
        String timeRunning = timeRunningEditable.toString();

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

        // Get water temperature at time of collection
        String waterTemperature;

        RadioButton coldRadioButton = (RadioButton) findViewById(R.id.cold_radio_button);
        boolean ifTempCold = coldRadioButton.isChecked();
        RadioButton coolRadioButton = (RadioButton) findViewById(R.id.cool_radio_button);
        boolean ifTempCool = coolRadioButton.isChecked();
        RadioButton tepidRadioButton = (RadioButton) findViewById(R.id.tepid_radio_button);
        boolean ifTempTepid = tepidRadioButton.isChecked();
        RadioButton warmRadioButton = (RadioButton) findViewById(R.id.warm_radio_button);
        boolean ifTempWarm = warmRadioButton.isChecked();
        RadioButton hotRadioButton = (RadioButton) findViewById(R.id.hot_radio_button);
        boolean ifTempHot = hotRadioButton.isChecked();
        RadioButton scaldingRadioButton = (RadioButton) findViewById(R.id.scalding_radio_button);
        boolean ifTempScalding = scaldingRadioButton.isChecked();

        if (ifTempCold)
            {waterTemperature = "Cold";}
        else if (ifTempCool)
            {waterTemperature = "Cool";}
        else if (ifTempTepid)
            {waterTemperature = "Tepid";}
        else if (ifTempWarm)
            {waterTemperature = "Warm";}
        else if (ifTempHot)
            {waterTemperature = "Hot";}
        else if (ifTempScalding)
            {waterTemperature = "Scalding";}
        else
            {waterTemperature = "";}

        // Get appearance of water
        EditText appearanceField = (EditText) findViewById(R.id.water_appearance_description);
        Editable appearanceEditable = appearanceField.getText();
        String appearance = appearanceEditable.toString();

        // Get smell of water
        EditText smellField = (EditText) findViewById(R.id.water_smell_description);
        Editable smellEditable = smellField.getText();
        String smell = smellEditable.toString();

        // Get taste of water
        EditText tasteField = (EditText) findViewById(R.id.water_taste_description);
        Editable tasteEditable = tasteField.getText();
        String taste = tasteEditable.toString();

        // Get rotten egg smell
        boolean rottenEgg = false;
        RadioButton rottenEggButton = (RadioButton) findViewById(R.id.rottenEgg_yes_radio_button);
        boolean ifRottenEgg = rottenEggButton.isChecked();
        if (ifRottenEgg)
        {rottenEgg = true;}

        // Get sediment
        boolean sediment = false;
        RadioButton sedimentButton = (RadioButton) findViewById(R.id.sediment_yes_radio_button);
        boolean ifSediment = sedimentButton.isChecked();
        if (ifSediment)
        {sediment = true;}

        // Get feathery
        boolean feathery = false;
        RadioButton featheryButton = (RadioButton) findViewById(R.id.feathery_yes_radio_button);
        boolean ifFeathery = featheryButton.isChecked();
        if (ifFeathery)
        {feathery = true;}

        // Display the results summary
        String message = createResultsSummary(dateCollection, timeCollection, tabletNumber,
                timeRunning, waterTemperature, noneDrinking, noneBrushing, noneHandwashing,
                usedForNone, appearance, smell, taste, rottenEgg, sediment, feathery);

        // Display results summary to the screen
        display(message);
    }

    /**
     * Create summary of the results.
     *
     * @param participantID            on the order
     * @return text summary
     */
    private String createResultsSummary(String dateCollection, String timeCollection,
      String participantID, String timeRunning, String waterTemperature, Boolean drinking,
      Boolean brushing, Boolean handwashing, Boolean none, String appearance, String smell,
      String taste, Boolean rottenEgg, Boolean sediment, Boolean feathery) {

        String summaryMessage = "\n " + getString(R.string.tablet_number) + ": " + participantID;
        summaryMessage += "\n " + getString(R.string.date_of_collection) + ": " + dateCollection;
        summaryMessage += "\n " + getString(R.string.time_of_collection) + ": " + timeCollection;
        summaryMessage += "\n " + getString(R.string.running_time_short) + ": " + timeRunning;
        summaryMessage += "\n " + getString(R.string.water_temp_short) + ": " + waterTemperature + "\n";

        summaryMessage += "\n " + getString(R.string.drinking) + ": " + drinking;
        summaryMessage += "\n " + getString(R.string.brushing_teeth) + ": " + brushing;
        summaryMessage += "\n " + getString(R.string.handwashing) + ": " + handwashing;
        summaryMessage += "\n " + getString(R.string.none) + ": " + none + "\n";

        summaryMessage += "\n " + getString(R.string.appearance_short) + ": " + appearance + "\n";
        summaryMessage += "\n " + getString(R.string.smell_short) + ": " + smell + "\n";
        summaryMessage += "\n " + getString(R.string.taste_short) + ": " + taste + "\n";

        summaryMessage += "\n " + getString(R.string.rotten_egg_short) + ": " + rottenEgg;
        summaryMessage += "\n " + getString(R.string.sediment_short) + ": " + sediment;
        summaryMessage += "\n " + getString(R.string.feathery_short) + ": " + feathery + "\n";

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
