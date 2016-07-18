package rishabh.example.com.jsonarraydemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jindal on 7/13/2016.
 */
public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MyViewHolder> {

    ArrayList<Contact> contactList;

    public RecyclerViewAdaptor(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact=contactList.get(position);
        holder.name.setText(contact.getName());
        holder.email.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,email;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name_txt);
            email=(TextView)itemView.findViewById(R.id.email_txt);
        }
    }
}
