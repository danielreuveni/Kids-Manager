package com.example.myapplication2;

import android.graphics.Picture;
import android.media.Image;
import android.widget.ImageView;

import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Child {

        private String name;
        private String Garden;
        private ImageView profilePicture;

        //constructor
        public Child(String name, Date birthDate, ImageView picture) {
            this.name = new String(name);
            this.Garden = new String(Garden);
            this.profilePicture = picture;

        }


}
