package com.example.todolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private List<Task> tasks = new ArrayList<>();

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task current = tasks.get(position);
        holder.textViewCaption.setText(current.getCaption());
        holder.textViewDescription.setText(current.getDescription());
        holder.checkBoxIsComplete.setChecked(current.isComplete());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder{
        private TextView textViewCaption, textViewDescription;
        private CheckBox checkBoxIsComplete;

        public TaskHolder(View itemView) {
            super(itemView);
            textViewCaption = itemView.findViewById(R.id.text_view_caption);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            checkBoxIsComplete = itemView.findViewById(R.id.text_view_is_complete);
        }
    }
}
