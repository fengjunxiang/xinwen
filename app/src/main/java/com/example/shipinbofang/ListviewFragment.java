package com.example.shipinbofang;

/**
 * Created by admin on 2019/2/23.
 */
import com.example.shipinbofang.Main2Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.TextView;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ListviewFragment extends Fragment {
    private Context mContext;
    private List<Fruit> fruitList =new ArrayList<>();
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public ListviewFragment() {

        // Required empty public constructor

    }



    /**
     * Use this factory method to create a new instance of

     * this fragment using the provided parameters.

     *



     * @return A new instance of fragment BlankFragment.

     */

    public static ListviewFragment newInstance() {

        ListviewFragment fragment = new ListviewFragment();






        return fragment;

    }



    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {



        }

    }



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.listview, container, false);

        initFruits();
      FruitAdapter adapter=new FruitAdapter(getContext(),R.layout.fruit_item,fruitList);
        ListView listView=(ListView) rootView.findViewById(R.id.List_view);
        listView.setAdapter(adapter);
        return rootView;

    }
private  void initFruits(){
    for (int i=0;i<2;i++){
        Fruit apple=new Fruit("战斗天使",R.drawable.img_2);
        fruitList.add(apple);
    }

}


}

