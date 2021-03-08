package com.cheekupeeku.testpopupmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.cheekupeeku.testpopupmenu.databinding.HomeBinding;

public class MainActivity extends AppCompatActivity {
    HomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        registerForContextMenu(binding.button);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,binding.button);
                Menu menu = popupMenu.getMenu();
                menu.add("View");
                menu.add("Edit");
                menu.add("Delete");
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String title = item.getTitle().toString();
                        if(title.equals("View")){
                            Toast.makeText(MainActivity.this, "View clicked", Toast.LENGTH_SHORT).show();
                        }
                        else if(title.equals("Edit")){
                            Toast.makeText(MainActivity.this, "Edit clicked", Toast.LENGTH_SHORT).show();
                        }
                        else if(title.equals("Delete")){
                            Toast.makeText(MainActivity.this, "Delete clicked", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Menu-1");
        menu.add("Menu-2");
        menu.add("Menu-3");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String title = item.getTitle().toString();
        switch (title){
            case "Menu-1":
                Toast.makeText(this, "Menu-1 clicked", Toast.LENGTH_SHORT).show();break;
            case "Menu-2":
                Toast.makeText(this, "Menu-1 clicked", Toast.LENGTH_SHORT).show();break;
            case "Menu-3":
                Toast.makeText(this, "Menu-1 clicked", Toast.LENGTH_SHORT).show();break;
        }
        return super.onContextItemSelected(item);
    }
}