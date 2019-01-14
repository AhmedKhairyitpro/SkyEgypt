package com.zecode.z.skyegyptdemo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zecode.z.skyegyptdemo.R;

public class Fragment_internalToursDahabHotels extends Fragment {

    ListView listdahabhotels;
    int dahabhotels[] ={R.drawable.ecotildahab,R.drawable.jazzdahabeya,R.drawable.lemeredidahab,R.drawable.tiranadahabresort,R.drawable.tropitaldahab};
    String [] dahabhotelnames={"Ecotil dahab","Jazz Dahabeya","Le Meredian Dahab", "Tirana Dahab Resort","Tropital Dahab"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         return inflater.inflate(R.layout.fragment_internaltoursdahabhotels,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customListView();

    }

    public void customListView(){
        listdahabhotels=getActivity().findViewById(R.id.listdahabhotels);
        listdahabhotels.setAdapter(new CustomList(getActivity().getApplicationContext(),dahabhotels,dahabhotelnames));
    }

    public class CustomList extends BaseAdapter{

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
