package com.example.shivam.firebaseintegrationtutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by shivam on 1/2/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public List<MyUser> models;
    public Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public UserAdapter(Context context, List<MyUser> models){
        this.models = models;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserViewHolder eventViewHolder = null;
        LayoutInflater li= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = li.inflate(R.layout.custom_layout,parent,false);
        eventViewHolder = new UserViewHolder(layoutView, models);
        return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        holder.textView_name.setText(models.get(position).getName());
        holder.textView_rollno.setText(models.get(position).getRollno());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name;
        TextView textView_rollno;

        public UserViewHolder(View itemView,List<MyUser> models) {
            super(itemView);
            textView_name = (TextView)itemView.findViewById(R.id.name);
            textView_rollno = (TextView)itemView.findViewById(R.id.rollno);
        }
    }
}