package ru.turpattaya.turpattayaapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactsActivity extends BaseActivity {

    private TextView contactsEmail;
    private TextView contactsWebSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        contactsEmail = (TextView) findViewById(R.id.contacts_email);
        contactsWebSite = (TextView) findViewById(R.id.contacts_webSite);


        //при клике пишет : "НЕПОДДЕРЖИВАЕМОЕ ДЕЙСТВИЕ
        // В настоящий время это действие не поддерживается"
        contactsEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                String uriText =
                        "mailto:" + Uri.encode("TURPATTAYA@gmail.com") +
                                "?subject=" + Uri.encode("") +
                                "&body=" + Uri.encode("");
                Uri emailUri = Uri.parse(uriText);
                sendIntent.setData(emailUri);
                startActivity(Intent.createChooser(sendIntent, "написать письмо"));
            }
        });

        contactsWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://turpattaya.ru/"));
                startActivity(browserIntent);
            }
        });
    }


}
