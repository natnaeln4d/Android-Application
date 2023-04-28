package com.example.leeogezba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {




    public UserAdapter(Context context, ArrayList<User> userArrayList) {
        super(context,R.layout.item,userArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user=getItem(position);

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.user_id);
        TextView fullName=convertView.findViewById(R.id.fullName);
        TextView address=convertView.findViewById(R.id.address);

        imageView.setImageResource(user.photoUrl);
        fullName.setText(user.fullName);
        address.setText(user.address);
        return convertView;
    }
}
