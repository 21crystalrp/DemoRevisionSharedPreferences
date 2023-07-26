package sg.edu.rp.c346.id21033293.demorevisionsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    CheckBox cbMarried;
    Button btnSave, btnShow;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        cbMarried = findViewById(R.id.cbMarried);
        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);

        // step 1: create SharedPreferences instance and initialize it
        myPref = getPreferences(MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // step 2: create an editor object for saving by calling the edit()
                SharedPreferences.Editor prefEdit = myPref.edit();

                // step 3a: get the name value from the screen
                String name = etName.getText().toString();
                // step 3b: get the marital status
                boolean status = cbMarried.isChecked();
                // step 3c: save the 3 pieces of info to SharedPreferences
                prefEdit.putString("name", name);
                prefEdit.putBoolean("status", status);

                // step 4: commit the saving
                prefEdit.commit(); // OR prefEdit.apply();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // step 1: done, same SharedPreferences instance

                // step 2a: retrieve the name value from the SharedPreferences
//                myPref.getString("name", "Jack");
                // step 2b: retrieve the marital status from the SharedPreferences
//                myPref.getBoolean("status", true);
                String name = myPref.getString("name", "Jack");
                boolean status = myPref.getBoolean("status", true);

                // challenge
                String statusInString = "Married";
                if (status == false) {
                    statusInString = "Unmarried";
                }

                // step 3: close message
                Toast.makeText(MainActivity.this, name + ", " + status, Toast.LENGTH_LONG).show();
            }
        });
    }
}