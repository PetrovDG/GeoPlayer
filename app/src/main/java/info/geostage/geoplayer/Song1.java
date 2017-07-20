package info.geostage.geoplayer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Song1 extends AppCompatActivity {

    String Comment;
    Button bn1, bn2, bn3, bn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_song1);

        // Enable the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bn1 = (Button) findViewById(R.id.bn1);
        bn2 = (Button) findViewById(R.id.bn2);
        bn3 = (Button) findViewById(R.id.bn3);
        bn4 = (Button) findViewById(R.id.bn4);

        // Set a click listener on that button
        bn2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked on.
            @Override
            public void onClick(View v) {
                Toast.makeText(Song1.this, "The button starts music", Toast.LENGTH_SHORT).show();

            }
        });

        // Set a click listener on that button
        bn3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play button is clicked on.
            @Override
            public void onClick(View v) {
                Toast.makeText(Song1.this, "The button stop music", Toast.LENGTH_SHORT).show();

            }
        });

        // The code for other activities goes here
        // .......................
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song1, menu);
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
}

