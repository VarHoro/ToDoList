package com.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddTaskActivity extends AppCompatActivity {
    public static final String EXTRA_CAPTION = "com.example.todolist.EXTRA_CAPTION";
    public static final String EXTRA_DESCRIPTION = "com.example.todolist.EXTRA_DESCRIPTION";
    public static final String EXTRA_IS_COMPLETE = "com.example.todolist.EXTRA_IS_COMPLETE";
    public static final String EXTRA_PRIORITY = "com.example.todolist.EXTRA_PRIORITY";

    private EditText editTextCaption;
    private EditText editTextDescription;
    private CheckBox checkBoxIsComplete;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextCaption = findViewById(R.id.edit_text_caption);
        editTextDescription = findViewById(R.id.edit_text_description);
        checkBoxIsComplete = findViewById(R.id.check_box_is_complete);
        numberPickerPriority = findViewById(R.id.number_picker);

        numberPickerPriority.setMinValue(0);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle(R.string.add_new_task_title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_task:
                saveTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveTask() {
        String caption = editTextCaption.getText().toString();
        String description = editTextDescription.getText().toString();
        boolean isComplete = checkBoxIsComplete.isClickable();
        int priority = numberPickerPriority.getValue();

        Intent data = new Intent();
        data.putExtra(EXTRA_CAPTION, caption);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_IS_COMPLETE, isComplete);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();

    }
}
