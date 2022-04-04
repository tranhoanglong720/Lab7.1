package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvwContact;
    private List<Contact> contacts;
    Button btnAdd,btnxoa,btncan;
    EditText txtnhap;
    TextView txtten;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

   /*    // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));
*/
        // Reading all contacts
        lvwContact=(ListView) findViewById(R.id.listcontact);
        Log.d("Reading:  ", "Reading all contacts..");
       contacts = db.getAllContacts();

        btnAdd=(Button) findViewById(R.id.btnadd);
        btnxoa=(Button) findViewById(R.id.btnremove);
        btncan=(Button) findViewById(R.id.btncancel);
        txtnhap=(EditText) findViewById(R.id.txtnhap);
        txtten=(TextView) findViewById(R.id.txtten);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact(txtnhap.getText().toString()));
                contacts = db.getAllContacts();
                dataChange();
            }
        });
        lvwContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Contact c=contacts.get(i);
                vitri=c._id;
                Toast.makeText(MainActivity.this, "id: "+vitri, Toast.LENGTH_SHORT).show();
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact xoa=  db.getContact(vitri);
                db.deleteContact(xoa);
                contacts = db.getAllContacts();
                dataChange();
            }
        });
        dataChange();

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void dataChange(){
        Adaptercontact adaptercontact=new Adaptercontact(MainActivity.this,R.layout.item_contact,contacts);
        lvwContact.setAdapter(adaptercontact);
    }
}