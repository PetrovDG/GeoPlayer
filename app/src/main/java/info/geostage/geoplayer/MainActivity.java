package info.geostage.geoplayer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String Comment;
    TextView song1, song_3;
    Spinner mSpinner;
    Button bn1, bn2, bn3, bn4;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Enable the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set the label name of that activity
        setTitle(getString(R.string.app_short_name));

        // Enable the spinner
        mSpinner = (Spinner) findViewById(R.id.spinner);

        // The list of items added to mSpinner using an Adapter
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner_list));
        // Specify the layout to use when the list of choices appears
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(mAdapter);
        mSpinner.setSelection(mAdapter.getPosition("All"));
        addListenerOnSpinnerItemSelection();

        // Find the View that shows Song 3
        song_3 = (TextView) findViewById(R.id.song_3);

        // Set a click listener on that View
        song_3.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the Song 3 TextView is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "The hart shows the favorites songs/albums of the user", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // Find the View that shows Song 1
        song1 = (TextView) findViewById(R.id.song_1);

        // Set a click listener on that View
        song1.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the song1 category is clicked on.
            @Override
            public void onClick(View view) {
                Intent Song1Intent = new Intent(MainActivity.this, Song1.class);
                // Start the new activity
                startActivity(Song1Intent);
            }
        });

        bn1 = (Button) findViewById(R.id.bn1);
        bn2 = (Button) findViewById(R.id.bn2);
        bn3 = (Button) findViewById(R.id.bn3);
        bn4 = (Button) findViewById(R.id.bn4);

        // Set a click listener on that button
        bn2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked on.
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "The button starts music", Toast.LENGTH_SHORT).show();

            }
        });

        // Set a click listener on that button
        bn3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked on.
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "The button stop music", Toast.LENGTH_SHORT).show();

            }
        });


        // The code for other activities goes here
        // .......................

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                //Do something
                Toast.makeText(this, "Show the app settings", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_help:
                //Do something
                Toast.makeText(this, "Show help window", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_share:
                //Do something
                Comment = getString(R.string.comment);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.send_music));
                intent.putExtra(Intent.EXTRA_TEXT, Comment);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                break;
            case R.id.action_search:
                //Do something
                View menuItemView = findViewById(R.id.action_search); // SAME ID AS MENU ID
                PopupMenu popupMenu = new PopupMenu(this, menuItemView);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.show();


            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnSpinnerItemSelection() {
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            switch (pos) {
                case (2):
                    intent = new Intent(MainActivity.this, Albums.class);
                    MainActivity.this.startActivity(intent);
                    break;
                default:
                    break;

            }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

    }
}





