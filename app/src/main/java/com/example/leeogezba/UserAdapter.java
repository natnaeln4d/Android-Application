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
import androidx.appcompat.app.AlertDialog;

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
        TextView work=convertView.findViewById(R.id.work);
        TextView edit=convertView.findViewById(R.id.edit);
        TextView delete=convertView.findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=fullName.getText().toString();
                DBHelper dbHelper=new DBHelper(getContext());
                long i=dbHelper.deleteEnter(String.valueOf(user.getId()));
                if(i==1){
                    androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setCancelable(true);
                    builder.setTitle("success");
                    builder.setMessage("1."+name+": Deleted successfully");
                    builder.show();

                }
            }
        });

       work.setText(user.getJob());
        fullName.setText(user.getFullName());
        address.setText(user.getAddress());

        return convertView;
    }
}
