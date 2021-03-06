package com.example.retime;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
//import android.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder>{
    private List<com.example.retime.TimeTable> TimeTableList;
    private Context context;
    private OnFragmentListener monfragmentlistener;

    public TimeTableAdapter(List<com.example.retime.TimeTable> TimeTableList, Context context, OnFragmentListener onfragmentlistener) {
        this.TimeTableList = TimeTableList;
        this.context = context;
        this.monfragmentlistener = onfragmentlistener;
    }

    @NonNull
    @Override
    public TimeTableAdapter.TimeTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(context).inflate(R.layout.time_slot, parent, false);
        return new TimeTableAdapter.TimeTableViewHolder(itemView, monfragmentlistener);
    }

    @Override  // Populating data into the item through holder
    public void onBindViewHolder (TimeTableViewHolder holder, int position )
    {   // get element from your dataset (Property) at this position
        // replace the contents of the view with that element
        holder.TimeTableTime.setText(TimeTableList.get(position).getTime());
        holder.TimeTableTask1.setText(TimeTableList.get(position).getTask1());
        holder.TimeTableTask2.setText(TimeTableList.get(position).getTask2());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount(){
        return TimeTableList.size();
    }

    public class TimeTableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView TimeTableTime;
        public TextView TimeTableTask1;
        public TextView TimeTableTask2;
        public OnFragmentListener onfragmentlistener;

        public TimeTableViewHolder (View view, OnFragmentListener onfragmentlistener)
        {   super(view);

            TimeTableTime = view.findViewById(R.id.time);
            TimeTableTask1 = view.findViewById(R.id.task1);
            TimeTableTask2 = view.findViewById(R.id.task2);
            this.onfragmentlistener = onfragmentlistener;
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) { //click event

            onfragmentlistener.onFragmentClick(getPosition());

        }
    }

    public interface OnFragmentListener{ //click listener of the fragment item in recycler view
        void onFragmentClick(int position);
    }

}
