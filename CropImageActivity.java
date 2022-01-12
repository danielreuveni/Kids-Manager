package com.example.myapplication2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CropImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_upload_picture);
        Button button = findViewById(R.id.uploadPicture);
        button.setOnClickListener(view -> {
            startCropImageActivity();
        });

    }
    private void startCropImageActivity() {
        CropImage.activity().setGuidelines(CropImageView.Guidelines.ON).start(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                ImageView imageView = findViewById(R.id.croppedImage);
                imageView.setImageURI(resultUri);
            }
            /*if(requestCode== 22 && resultCode==RESULT_OK){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                ImageView imageView = (ImageView) findViewById(R.id.croppedImage);
                imageView.setImageBitmap(image);
            }*/

            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


}
