package com.zecode.z.skyegyptdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zecode.z.skyegyptdemo.Fragments.Fragment_internalToursDahabHotels;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    ListView listhotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        listhotels=findViewById(R.id.listhotels);

        int[] hotels = getIntent().getExtras().getIntArray("hotels");
        String[] hotelsname = getIntent().getExtras().getStringArray("hotelsname");


        listhotels.setAdapter(new CustomList(getApplicationContext(),hotels,hotelsname));


    }




    public class CustomList extends BaseAdapter {

        Context con;
        int[] img;
        String[] hn;

        public CustomList(Context con,int[] img,String [] hn){
            this.con=con;
            this.img=img;
            this.hn=hn;
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View myView;

            LayoutInflater layoutInflater= (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView=layoutInflater.inflate(R.layout.dahabhotels,null);
            ImageView hotelpicsdahab = myView.findViewById(R.id.hotelpicsdahab);
            TextView hotelnamedahab=myView.findViewById(R.id.hotelnamedahab);

            hotelpicsdahab.setImageResource(img[position]);
            hotelnamedahab.setText(hn[position]);

            return myView;
        }
    }
}
