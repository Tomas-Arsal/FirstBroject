
package com.tomas.mygod;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int notOFCacgp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {
//        CheckBox checkboxwhippedcreamview = (CheckBox) findViewById(R.id.checkbox_whippedcream_view);
//        boolean hasWhipeedcream = checkboxwhippedcreamview.isChecked();
//
//        CheckBox checkboxcheoolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
//        boolean checkboxcheoolata = checkboxwhippedcreamview.isChecked();
//        getthis(6);
//        EditText textFile = (EditText) findViewById(R.id.file_name);
//        String value = textFile.getText().toString();
//        String toto = createOrderSummary(value, notOFCacgp, hasWhipeedcream, checkboxcheoolata);
// int price = calculate(hasWhipeedcream, checkboxcheoolata);
//   displayMessage(toto);


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this

            intent.putExtra(Intent.EXTRA_SUBJECT, "movmkvddeve");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

    }

    private String createOrderSummary(String value, int p, boolean hasWhipeedcream, boolean checkboxcheoolata) {
        String passage = "Name: " + value;
        passage += "\nthat is a " + hasWhipeedcream;
        passage += "\nYou choice chocolate " + checkboxcheoolata;
        passage = passage + "\nQuantity :" + p;
        passage += "\n Total: " + p * 2;
        passage += "$" + "\n Thank YOU !";
        return passage;
    }

    private int calculate(boolean hasWhipeedcream, boolean checkboxcheoolata) {
        int space = 5;
        if (hasWhipeedcream) {
            space = space + 1;
        }
        if (checkboxcheoolata) {
            space = space + 2;
        }
        return notOFCacgp * space;
    }

    /**
     * This method is called when the order button is increased.
     */
    public void increment(View view) {
        if (notOFCacgp == 100) {
            // for shows a error of message
            Toast.makeText(this, "that is impossible becouse increased about 100 cups", Toast.LENGTH_LONG).show();
            // for exite the issuate because it is an error
            return;
        }

        notOFCacgp = notOFCacgp + 1;

        display(notOFCacgp);

    }

    /**
     * This method is called when the order button is decreased.
     */
    public void decrement(View view) {
        if (notOFCacgp == 1) {
            // for shows a error of message
            Toast.makeText(this, "that is impossible becouse increased about 1 cups", Toast.LENGTH_SHORT).show();
            return;
        }
        notOFCacgp = notOFCacgp - 1;

        display(notOFCacgp);

    }

    /**
     * This method is called when the order button is clicked.
     */
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public int getthis(int o) {
        return o;
    }

}