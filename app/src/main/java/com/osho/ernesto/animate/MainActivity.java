package com.osho.ernesto.animate;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact Me", Snackbar.LENGTH_LONG)
                        .setAction("Email", null).show();

                // Send email to developer

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[] { "fumesbond@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Enter Subject");

                startActivity(Intent.createChooser(intent, "Email via..."));
        }
    }

    );
}

    // Animation code
    public void clockwise(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation);

        Snackbar.make(view, "CLOCKWISE animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "CLOCKWISE animation", Toast.LENGTH_SHORT).show();

    }

    public void zoom(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        image.startAnimation(animation1);

        Snackbar.make(view, "ZOOM animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "ZOOM animation", Toast.LENGTH_SHORT).show();

    }

    public void blink(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);

        Snackbar.make(view, "BLINK animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "BLINK animation", Toast.LENGTH_SHORT).show();

    }

    public void move(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);

        Snackbar.make(view, "MOVE animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "MOVE animation", Toast.LENGTH_SHORT).show();

    }

    public void slide(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);

        Snackbar.make(view, "SLIDE UP animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "SLIDE animation", Toast.LENGTH_SHORT).show();

    }

    public void bounce(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        image.startAnimation(animation1);

        Snackbar.make(view, "BOUNCE animation", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        //Toast.makeText(this, "BOUNCE animation", Toast.LENGTH_SHORT).show();

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            final TextView title = new TextView(this);
            title.setMovementMethod(LinkMovementMethod.getInstance());
            title.setText(R.string.about_body);
            title.setGravity(Gravity.CENTER);

            dlgAlert.setView(title);
            dlgAlert.setTitle("About");
            dlgAlert.setIcon(R.drawable.ic_account_outline_black_24dp); // default for now
            dlgAlert.setPositiveButton("EXIT",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //dismiss the dialog
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }



        return super.onOptionsItemSelected(item);
    }
}
