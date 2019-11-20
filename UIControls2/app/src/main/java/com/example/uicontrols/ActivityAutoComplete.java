package com.example.uicontrols;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ActivityAutoComplete extends Activity {
    AutoCompleteTextView autocmplt;

    String[] arr = {"Aditia Got Cha", "Kulsum", "Daffa Ahmad", "Edgard Jeremiah", "Farid", "Felix", "Haidar", "Raihan", "Rakha"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Memanggil layout
        setContentView(R.layout.control_autocomplete);
        // Objek AutoComplete
        autocmplt = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                // Bagian ini mengatur view untuk
                // menampilkan data dari data set (array : arr)
                (this, android.R.layout.select_dialog_item, arr);

        autocmplt.setThreshold(2);
        // Mengatur adapter yag digunakan
        autocmplt.setAdapter(adapter);
    }
}
