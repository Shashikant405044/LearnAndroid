package com.example.learnandroid.contactlistApp.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.R;
import com.example.learnandroid.contactlistApp.activity.ContactDetailActivity;
import com.example.learnandroid.contactlistApp.interfascpak.OnItemClickListner;
import com.example.learnandroid.contactlistApp.model.ContactList;

import java.util.List;

public class MyContactRecyclerViewAdapter extends RecyclerView.Adapter<MyContactRecyclerViewAdapter.MyViewHolder>{
  //  private String[] AllowPermission = new String[]{Manifest.permission.CALL_PHONE};

    private Context context;
    private List<ContactList> contactLists;
    private OnItemClickListner listner;


    public MyContactRecyclerViewAdapter(Context context, List<ContactList> contactLists) {
        this.context = context;
        this.contactLists = contactLists;
    }
    public MyContactRecyclerViewAdapter(Context context, List<ContactList> contactLists, OnItemClickListner listner) {
        this.context = context;
        this.contactLists = contactLists;
        this.listner = listner;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.contactitem_list, parent, false));


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ContactList clist = contactLists.get(position);
        holder.firstName_Last.setText(clist.getF_name() + "" + clist.getL_name());
        holder.mobil_txt.setText(clist.getMobilNo());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ContactDetailActivity.class);
                intent.putExtra("fname",clist.getF_name());
                intent.putExtra("lname",clist.getL_name());
                intent.putExtra("mobil",clist.getMobilNo());
                intent.putExtra("email",clist.getEmail());
                intent.putExtra("address",clist.getAddress_bar());
                context.startActivity(intent);
            }
        });





        holder.dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "kg gkdfgkdfk gf"+clist.getMobilNo(), Toast.LENGTH_SHORT).show();
//                Activity activity = new Activity();
//                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
//                dialIntent.setData(Uri.parse(clist.getMobilNo()));
//                context.startActivity(dialIntent);

                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + clist.getMobilNo();
                i.setData(Uri.parse(p));
                context.startActivity(i);
            }
        });

//        holder.call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Activity activity = new Activity();
//
//                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) ==
//                        PackageManager.PERMISSION_GRANTED) {
//                    Intent i = new Intent(Intent.ACTION_CALL);
//                    String p = "tel:" + clist.getMobilNo();
//                    i.setData(Uri.parse(p));
//                    context.startActivity(i);
//                }
//
//                else {
//                    ActivityCompat.requestPermissions(activity, AllowPermission, 1);
//                }
//
//
//            }
//        });



        listner.onItemClick(contactLists, position);

    }





    @Override
    public int getItemCount() {
        return contactLists.size();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//
//        if (requestCode == 1)
//        {
//
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//
//                Toast.makeText(context, "aaaceeesss", Toast.LENGTH_SHORT).show();
//            }
//            else {
//               // customeToast("Permission Denied !!!!!");
//
//            }
//
//        }
//    }


    class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView firstName_Last;
        TextView mobil_txt;
        ImageView dial,call;

        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName_Last   = itemView.findViewById(R.id.fandLastName);
            mobil_txt = itemView.findViewById(R.id.mobil_text);
            dial = itemView.findViewById(R.id.dial_);
            call = itemView.findViewById(R.id.call_);
            layout = itemView.findViewById(R.id.liniaer_data);
        }


    }
}
