package com.example.sqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    EditText et_idauthor, et_name, et_address, et_email;
    Button bt_save, bt_select, bt_exit, bt_update, bt_delete;
    GridView gv_diplay;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        et_idauthor = (EditText) findViewById(R.id.etID);
        et_name = (EditText) findViewById(R.id.etName);
        et_address = (EditText) findViewById(R.id.etAddress);
        et_email = (EditText) findViewById(R.id.etEmail);
        gv_diplay = (GridView) findViewById(R.id.gridview_display);
        dbhelper = new DatabaseHelper(this);

        bt_save = (Button) findViewById(R.id.btSave);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId_author(Integer.parseInt(et_idauthor.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbhelper.insertAuthor(author) > 0){
                    Toast.makeText(getBaseContext(), "Save successfully!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(), "Open Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        bt_select = (Button) findViewById(R.id.btSelect);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_author;
                list_author = dbhelper.getAllAuthor();


                ArrayList<String> list_String = new ArrayList<>();
                for(Author author : list_author){
                    list_String.add(author.getId_author()+"");
                    list_String.add(author.getName());
                    list_String.add(author.getAddress());
                    list_String.add(author.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this,
                        android.R.layout.simple_list_item_1, list_String);
                gv_diplay.setAdapter(adapter);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnAuthor:{
                Intent intent1 = new Intent(AuthorActivity.this, AuthorActivity.class);
                startActivity(intent1);
                return true;
            }
            case R.id.mnBook:{
//                Intent intent2 = new Intent(MainActivity.this, OutputActivity.class);
//                startActivity(intent2);
                return true;
            }
            case R.id.mnExit:{
                finish();
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }



}