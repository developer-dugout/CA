package com.coding.pixel.ca.Model;

import com.coding.pixel.ca.Home.MainActivity;

import java.util.ArrayList;

public class Card2ItemData {

    int c2pic;
    String c2text;


    public Card2ItemData(int c2pic, String c2text) {
        this.c2pic = c2pic;
        this.c2text = c2text;
    }


    public int getC2pic() {
        return c2pic;
    }

    public void setC2pic(int c2pic) {
        this.c2pic = c2pic;
    }

    public String getC2text() {
        return c2text;
    }

    public void setC2text(String c2text) {
        this.c2text = c2text;
    }
}
