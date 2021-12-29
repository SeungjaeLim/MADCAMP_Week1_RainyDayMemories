package com.example.spring_rain_with_who.Tab1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.spring_rain_with_who.R;

//외부에서 new Frag1 호출 시
public class Frag1 extends Fragment {
    private static final String TAG = "Frag1";

    Fragment contactFragment;
    EditText inputName;
    EditText inputPhonenumber;
    Context context;

    public static ItemDatabase itemDatabase = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab1_add,container,false);

        contactFragment = new ContactFragment();

        getChildFragmentManager().beginTransaction().replace(R.id.container,contactFragment).commit();
        ImageButton saveButton = v.findViewById(R.id.addbutton);
        inputName = v.findViewById(R.id.inputname);
        inputPhonenumber = v.findViewById(R.id.inputphonenumber);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name = inputName.getText().toString();
                String phonenumber = inputPhonenumber.getText().toString();

                String n_a= String.format("이름: %.4s     |      연락처: %.13s",name,phonenumber);
                String sqlSave = "insert into " + ItemDatabase.TABLE_ITEM + " (PHONENUMBER) values (" +
                        "'"+n_a+"')";

                ItemDatabase database = ItemDatabase.getInstance(context);
                database.execSQL(sqlSave);

                inputName.setText("");
                inputPhonenumber.setText("");

                Toast.makeText(view.getContext(),"Add",Toast.LENGTH_SHORT).show();

            }
        });
        openDatabase();
        return v;
    }

    public void openDatabase() {
        if (itemDatabase != null) {
            itemDatabase.close();
            itemDatabase = null;
        }

        itemDatabase = ItemDatabase.getInstance(getActivity());
        boolean isOpen = ItemDatabase.open();
        if (isOpen) {
            Log.d(TAG, "Item database is open.");
        } else {
            Log.d(TAG, "Item database is not open.");
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (itemDatabase != null) {
            itemDatabase.close();
            itemDatabase = null;
        }
    }
}