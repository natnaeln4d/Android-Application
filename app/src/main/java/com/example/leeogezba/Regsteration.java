package com.example.leeogezba;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.leeogezba.databinding.ActivityMain2Binding;
import com.example.leeogezba.databinding.FragmentAddTodoBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Regsteration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Regsteration extends Fragment {
       private EditText fullName,work,address;
   private TextView titleTextView ,edit, delect;
   private Button addButton;
   private ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Regsteration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Regsteration.
     */
    // TODO: Rename and change types and number of parameters
    public static Regsteration newInstance(String param1, String param2) {
        Regsteration fragment = new Regsteration();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<User> userArrayList = new ArrayList<User>();
        View view = inflater.inflate(R.layout.fragment_regsteration, container, false);
        ListView listView = view.findViewById(R.id.list_item);
        DBHelper dbHelper = new DBHelper(getActivity());

        // Fetch user data from the database
        userArrayList = dbHelper.getAllUsers();

        // Create adapter and set it to list view
        UserAdapter adapter = new UserAdapter(getActivity(), userArrayList);
        listView.setAdapter(adapter);

        return  view;
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        ArrayList<User> userArrayList=new ArrayList<User>();
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_regsteration, container, false);
//        ListView listView = view.findViewById(R.id.list_item);
//        int [] users = new int[4];
//        int[] image= {R.drawable.u1, R.drawable.u2, R.drawable.u3, R.drawable.u4};
//        String[] FullNames={"Natanel Getachew","yohanes Gertachew","Zebider miliket","Eyob Abate"};
//        String[] Jobs={"Developer","Doctor","Teacher","Artist"};
//        String[] Location={"jimma oromia Ethiopia","jijiga somali Ethiopia","harege East Ethiopia","A A Ethiopia"};
//        int i;
//        User user;
//
//        for(i=0;i<image.length;i++){
//            user=new User(users[i],FullNames[i],Jobs[i],Location[i],image[i]);
//            userArrayList.add(user);
//        }
//        UserAdapter adapter=new UserAdapter(getActivity(), userArrayList);
//        listView.setAdapter(adapter);
//        return  view;
//    }

}