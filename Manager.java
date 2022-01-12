package com.example.myapplication2;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Manager extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    private AlertDialog.Builder dialogBulider;
    private AlertDialog dialog;
    private EditText newChildPopUpName, getNewChildPopUpBirthDate;
    private Button newChildSave, newChildDelete, newChildPopUpPicture;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_manager);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewChild();
            }
        });

    }

    public void createNewChild() {
        dialogBulider = new AlertDialog.Builder(this);
        final View childPopUpView = getLayoutInflater().inflate(R.layout.popup, null);
        newChildPopUpName = (EditText) childPopUpView.findViewById(R.id.newChildPopUpName);
        getNewChildPopUpBirthDate = (EditText) childPopUpView.findViewById(R.id.newChildPopUpBirth);
        newChildPopUpPicture = (Button) childPopUpView.findViewById(R.id.newChildPopUpPicture);
        newChildPopUpPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.newChildPopUpPicture:
                        /*Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivity(galleryIntent);*/
                        Intent intent = new Intent(Manager.this, CropImageActivity.class);
                        startActivity(intent);
                }
            }
        });
        newChildSave = (Button) childPopUpView.findViewById(R.id.save);
        newChildDelete = (Button) childPopUpView.findViewById(R.id.cancel);
        dialogBulider.setView(childPopUpView);
        dialog = dialogBulider.create();
        dialog.show();
        newChildSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SAVE!
            }
        });
        newChildDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}
