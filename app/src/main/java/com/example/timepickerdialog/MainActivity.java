package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.time);

        txtTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                chonGio();
            }
        });

    }

    private void chonGio(){
        Calendar calendar = java.util.Calendar.getInstance();
        int gio = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        int phut = calendar.get(java.util.Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0,hourOfDay,minute);
                txtTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },gio,phut, true);
        timePickerDialog.show();
    }
}