package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OrderDialog extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
    }

    public void mOnClick(View view) {
        final LinearLayout linearLayout = (LinearLayout)View.inflate(this, R.layout.order, null);
        new AlertDialog.Builder(this)
                .setTitle("주문 정보를 입력하세요")
                .setIcon(R.drawable.androboy)
                .setView(linearLayout)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText product = (EditText)linearLayout.findViewById(R.id.product);
                        EditText number = (EditText)linearLayout.findViewById(R.id.number);
                        CheckBox paymethod = (CheckBox)linearLayout.findViewById(R.id.paymethod);
                        TextView text = (TextView)findViewById(R.id.dialogtext);
                        text.setText("주문 정보 : " + product.getText() + "상품 " + number.getText() + "개 " +
                                (paymethod.isChecked() ? "착불결제" : ""));
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView text = (TextView)findViewById(R.id.dialogtext);
                        text.setText("주문을 취소했습니다");
                    }
                })
                .setCancelable(false)
                .show();
    }
}
