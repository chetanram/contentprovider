package com.binding;

import android.content.ContentValues;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.binding.data.TaskUpdateService;
import com.binding.databinding.ActivityAddEventBinding;
import com.binding.data.DatabaseContract.TaskColumns;

public class AddEventActivity extends AppCompatActivity {

    ActivityAddEventBinding activityAddEventBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_event);

    }

    public void addName(View view) {
        if (activityAddEventBinding.editTextName.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_SHORT).show();
        }
        else {
            //set Name values in content value object
            ContentValues values = new ContentValues();
            values.put(TaskColumns.NAME,activityAddEventBinding.editTextName.getText().toString());
            values.put(TaskColumns.IS_DELETE, 0);

            TaskUpdateService.insertNewTask(this, values);
            finish();
        }
    }
}
