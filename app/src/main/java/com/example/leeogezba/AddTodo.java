package com.example.leeogezba;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.leeogezba.databinding.ActivityMain2Binding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTodo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTodo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText fullName,work,address;
    private TextView titleTextView;
    private Button addButton;




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddTodo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddTodo.
     */
    // TODO: Rename and change types and number of parameters
    public static AddTodo newInstance(String param1, String param2) {
        AddTodo fragment = new AddTodo();
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
  ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActivityMain2Binding binding;
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        binding.getRoot();
        final Bundle bundle = new Bundle();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

    ArrayList<User> userArrayList=new ArrayList<User>();
        bundle.putString("test", "Hello World!");
//
       fullName = view.findViewById(R.id.fullName);
       work=view.findViewById(R.id.work);
       address=view.findViewById(R.id.address);


        addButton = view.findViewById(R.id.btnSubmit);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String Name=fullName.getText().toString();
             String job=work.getText().toString();
             String location=address.getText().toString();
         int[] image= {R.drawable.u1, R.drawable.u2, R.drawable.u3, R.drawable.u4};
         int i;
                int [] users = new int[4];;

                 for(i=0;i<image.length;i++){
                     User user=new User(users[i],Name,job,location,image[i]);
                     userArrayList.add(user);
                     goToAttract(view, (List<User>) user);

                 }
            }
        });
        return view;
    }
    public void goToAttract(View v,List<User> user){
        Intent intent=new Intent(getActivity(),Regsteration.class);
        intent.putExtra("user", (CharSequence) user);
        startActivity(intent);

    }

    }
