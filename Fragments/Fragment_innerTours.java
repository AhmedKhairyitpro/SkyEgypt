package com.zecode.z.skyegyptdemo.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.zecode.z.skyegyptdemo.HotelsActivity;
import com.zecode.z.skyegyptdemo.R;

public class Fragment_innerTours extends Fragment {

    ListView innertours_pics;
    ImageView imageView;
    int[] photos={R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         return inflater.inflate(R.layout.fragment_innertours,null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customListView();



    }

    public void customListView (){
        innertours_pics = getActivity().findViewById(R.id.innertours_pics);
        innertours_pics.setAdapter(new CustomList(getActivity().getApplicationContext(),photos));

        innertours_pics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1 :
                        int dahabhotels[] ={R.drawable.ecotildahab,R.drawable.jazzdahabeya,R.drawable.lemeredidahab,R.drawable.tiranadahabresort,R.drawable.tropitaldahab};
                        String [] dahabhotelnames={"Ecotil dahab","Jazz Dahabeya","Le Meredian Dahab", "Tirana Dahab Resort","Tropital Dahab"};
                        Intent i = new Intent(getActivity(),HotelsActivity.class);
                        i.putExtra("hotels", dahabhotels);
                        i.putExtra("hotelsname",dahabhotelnames);
                        startActivity(i);
                        break;
                }
            }
        });

    }

    public class CustomList extends BaseAdapter {
        Context con;
        int [] images;

        public CustomList (Context con,int [] images){
            this.con = con;
            this.images = images;
        }

        @Override
        public int getCount() {
            return images.length;
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

            LayoutInflater layoutInflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            myView = layoutInflater.inflate(R.layout.innertours_picsanddata,null);
            imageView = myView.findViewById(R.id.imageView);
            imageView.setImageResource(images[position]);
            return myView;
        }
    }

}
