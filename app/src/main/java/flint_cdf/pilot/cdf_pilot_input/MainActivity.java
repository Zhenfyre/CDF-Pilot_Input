package flint_cdf.pilot.cdf_pilot_input;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cdf_pilot_input.R;

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

        // Get Total Hardness
        EditText hardnessField = (EditText) findViewById(R.id.enter_hardness);
        Editable hardnessEditable = hardnessField.getText();
        String hardness = hardnessEditable.toString();

        // Get Total Chlorine
        EditText chlorineField = (EditText) findViewById(R.id.enter_chlorine);
        Editable chlorineEditable = chlorineField.getText();
        String chlorine = chlorineEditable.toString();

        // Get Alkalinity
        EditText alkalinityField = (EditText) findViewById(R.id.enter_alkalinity);
        Editable alkalinityEditable = alkalinityField.getText();
        String alkalinity = alkalinityEditable.toString();

        // Get Copper
        EditText copperField = (EditText) findViewById(R.id.enter_copper);
        Editable copperEditable = copperField.getText();
        String copper = copperEditable.toString();

        // Get Iron
        EditText ironField = (EditText) findViewById(R.id.enter_iron);
        Editable ironEditable = ironField.getText();
        String iron = ironEditable.toString();

        // Get pH
        EditText phField = (EditText) findViewById(R.id.enter_pH);
        Editable phEditable = phField.getText();
        String pH = phEditable.toString();

        // Get Bacteria
        boolean bacteria = false;
        RadioButton bacteriaButton = (RadioButton) findViewById(R.id.positive_bacteria_radio_button);
        boolean ifBacteria = bacteriaButton.isChecked();
        if (ifBacteria)
        {bacteria = true;}

        // Get Pesticide
        boolean pesticide = false;
        RadioButton pesticideButton = (RadioButton) findViewById(R.id.positive_pesticide_radio_button);
        boolean ifPesticide = pesticideButton.isChecked();
        if (ifPesticide)
        {pesticide = true;}

        // Get Lead
        boolean lead = false;
        RadioButton leadButton = (RadioButton) findViewById(R.id.positive_lead_radio_button);
        boolean ifLead = leadButton.isChecked();
        if (ifLead)
        {lead = true;}

        // Get Nitrite
        boolean nitrite = false;
        RadioButton nitriteButton = (RadioButton) findViewById(R.id.unsafe_nitrite_radio_button);
        boolean ifNitrite = nitriteButton.isChecked();
        if (ifNitrite)
        {nitrite = true;}

        // Get Nitrate
        boolean nitrate = false;
        RadioButton nitrateButton = (RadioButton) findViewById(R.id.unsafe_nitrate_radio_button);
        boolean ifNitrate = nitrateButton.isChecked();
        if (ifNitrate)
        {nitrate = true;}

        // Display the results summary
        String message = createResultsSummary(dateCollection, timeCollection, tabletNumber,
                timeRunning, waterTemperature, noneDrinking, noneBrushing, noneHandwashing,
                usedForNone, appearance, smell, taste, rottenEgg, sediment, feathery,
                hardness, chlorine, alkalinity, copper, iron, pH, bacteria, pesticide, lead,
                nitrite, nitrate);

        // Display results summary to the screen
        // display(message);

        String subject = getString(R.string.email_subject);
        String email_address = getString(R.string.email_address);

        // Use an intent to launch an email app.
        // Send the results summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_address});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);


        Toast toast = Toast.makeText(this, getString(R.string.thank_you), Toast.LENGTH_LONG);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(48);
        toastTV.setGravity(Gravity.CENTER);
        toastTV.setBackgroundColor(Color.parseColor("#e1ff00"));
        toastTV.setTextColor(Color.parseColor("#4800ff"));
        toastTV.setTypeface(null, Typeface.BOLD);
        toast.show();

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
      String taste, Boolean rottenEgg, Boolean sediment, Boolean feathery, String hardness,
      String chlorine, String alkalinity, String copper, String iron, String pH, Boolean bacteria,
      Boolean pesticide, Boolean lead, Boolean nitrite, Boolean nitrate) {

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

        summaryMessage += "\n " + getString(R.string.total_hardness) + ": " + hardness + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.total_chlorine) + ": " + chlorine + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.alkalinity) + ": " + alkalinity + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.copper) + ": " + copper + " " + getString(R.string.concentration_ppm);
        summaryMessage += "\n " + getString(R.string.iron) + ": " + iron + " " + getString(R.string.concentration_ppm) + "\n";

        summaryMessage += "\n " + getString(R.string.ph) + " " + pH + "\n";

        summaryMessage += "\n " + getString(R.string.bacteria) + ": " + bacteria;
        summaryMessage += "\n " + getString(R.string.pesticide) + ": " + pesticide;
        summaryMessage += "\n " + getString(R.string.lead) + ": " + lead + "\n";

        summaryMessage += "\n " + getString(R.string.nitrite) + ": " + nitrite;
        summaryMessage += "\n " + getString(R.string.nitrate) + ": " + nitrate;

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
