package com.example.anand.womensecurity;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class details extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        et1 = findViewById(R.id.lat);
        et2 = findViewById(R.id.lon);
        b = findViewById(R.id.btn);
        b.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
//        String abc = extras.getString("currentlatitude");
//        String def = extras.getString("currentlongtitude");
//        Toast.makeText(this, def+","+abc, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String str = Mydata.savelatlon(et1.getText().toString(),et2.getText().toString());
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = new MenuInflater(this);
        mi.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mm1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are You Sure ");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    details.this.finish();
                    Intent in = new Intent(details.this,login.class);
                    startActivity(in);                }
            });

            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();

        }
        return super.onOptionsItemSelected(item);
    }
}
