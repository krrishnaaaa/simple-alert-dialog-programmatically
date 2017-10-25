package com.pcsalt.example.customalertdialogsimpleprogrammatically;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dialog).setOnClickListener(view -> createAndDisplayDialog());
    }

    private void createAndDisplayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout layout       = new LinearLayout(this);
        TextView tvMessage        = new TextView(this);
        final EditText etInput    = new EditText(this);

        tvMessage.setText("Enter name:");
        tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
        etInput.setSingleLine();
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(tvMessage);
        layout.addView(etInput);
        layout.setPadding(50, 40, 50, 10);

        builder.setView(layout);

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        builder.setPositiveButton("Done", (dialog, which) -> {
            String name = etInput.getText().toString();
            Toast.makeText(this, "Name entered: " + name, Toast.LENGTH_SHORT).show();
        });

        builder.create().show();
    }
}
