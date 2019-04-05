package com.example.todolist;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Task.class, version = 1)
public abstract class TaskDataBase extends RoomDatabase {

    private static TaskDataBase instance;

    public abstract TaskDao taskDao();
    public static synchronized TaskDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDataBase.class, "task_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private TaskDao taskDao;

        private PopulateDBAsyncTask(TaskDataBase db){
            taskDao = db.taskDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            taskDao.insert(new Task("Заголовок 1", "Описание 1", true, 1));
            taskDao.insert(new Task("Заголовок 2", "Описание 2", false, 5));
            taskDao.insert(new Task("Заголовок 3", "Описание 3", true, 3));
            return null;
        }
    }
}
