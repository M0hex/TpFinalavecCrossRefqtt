package com.dma.tpfinal;

import android.view.View;
import android.widget.EditText;

public class Controller implements View.OnClickListener {
    EditText editText;
    Boolean plus;
    int qt=0;


    public Controller(EditText editText, Boolean plus) {
        this.editText = editText;
        this.plus = plus;
    }

    @Override
    public void onClick(View v) {
        if(plus){
            Incremment();
        }
        else{
            Decremment();
        }
    }
    private void Incremment() {
        if (!editText.getText().toString().isEmpty()) {
            qt = Integer.parseInt(editText.getText().toString());
        }
        qt++;
        editText.setText(qt + "");
    }
    private void Decremment() {
        if (!editText.getText().toString().isEmpty() && !editText.getText().toString().equals("0")) {
            qt = Integer.parseInt(editText.getText().toString());
            qt--;
        }
        editText.setText(qt + "");
    }

}

