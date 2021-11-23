package com.project.agrivetApp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.project.agrivetApp.R;
import com.project.agrivetApp.adapters.StateDepartmentAdapter;


public class StateDepartment extends AppCompatActivity {

    private StateDepartmentAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        String[] array=getResources().getStringArray(R.array.Counties);
        String[] links=getResources().getStringArray(R.array.state_links);

        adapter = new StateDepartmentAdapter(this,array,links);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.progress).setVisibility(View.GONE);
    }
}
