package sg.edu.rp.c346.id20002694.ourndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class EditSong extends AppCompatActivity {

    EditText etTitle, etSingers, etYear, etID;
    RatingBar ratingBar;
    Button btnUpdate, btnDelete, btnCancel;
    sg.edu.rp.c346.id20002694.ourndpsongs.Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        Intent i = getIntent();
        data = (sg.edu.rp.c346.id20002694.ourndpsongs.Song) i.getSerializableExtra("data");

        etTitle  = findViewById(R.id.etTitle);
        etSingers= findViewById(R.id.etSingers);
        etYear= findViewById(R.id.etYear);
        etID= findViewById(R.id.etID);
        ratingBar = findViewById(R.id.ratingBar);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete= findViewById(R.id.btnDelete);
        btnCancel= findViewById(R.id.btnCancel);

        etID.setText(data.getId()+"");
        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(data.getYear()+"");

        ratingBar.setRating((data.getStars()));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper dbh = new sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper(sg.edu.rp.c346.id20002694.ourndpsongs.EditSong.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper dbh = new sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper(sg.edu.rp.c346.id20002694.ourndpsongs.EditSong.this);


                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                int stars = ratingBar.getNumStars();

                data.setSongContent(title, singers, year, stars);
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper dbh = new sg.edu.rp.c346.id20002694.ourndpsongs.DBHelper(sg.edu.rp.c346.id20002694.ourndpsongs.EditSong.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });

    }
}