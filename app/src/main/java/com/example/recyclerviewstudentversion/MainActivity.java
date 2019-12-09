package com.example.recyclerviewstudentversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Todo create a player class that will hold info about the player
public class MainActivity extends AppCompatActivity {
    // Todo initialize these variables
    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Player> list;



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem item=menu.getItem(R.id.hh);
       SearchView searchView=(SearchView) item.getActionView();
       searchView.setQueryHint("search");
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
           @Override
           public boolean onQueryTextSubmit(String s) {

               return false;
           }


           @Override
           public boolean onQueryTextChange(String s) {
               mAdapter.getFilter().filter(s);
                           //filter now
               return true;
           }
       });
        return true;
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<Player>();
        fillplayers();
        recyclerView=findViewById(R.id.recy);
       mAdapter=new MyRecyclerAdapter(list);
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        ItemTouchHelper ith=new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                       final int from=viewHolder.getAdapterPosition();
                       final int to=target.getAdapterPosition();
                        Collections.swap(list,from,to);
                       mAdapter.notifyItemMoved(from,to);
                       return true;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        final int position=viewHolder.getAdapterPosition();
                        final Player gone=list.get(position);
                        switch(direction){
                            case ItemTouchHelper.LEFT:
                                list.remove(position);
                                mAdapter.notifyItemRemoved(position);
                                Snackbar.make(recyclerView,"swipe left",Snackbar.LENGTH_SHORT).setAction("Undo",new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        list.add(position,gone);
                                        mAdapter.notifyItemInserted(position);
                                    }
                                }).show();
                        }
                    }
                }
        );

        ith.attachToRecyclerView(recyclerView);
    }


        private void fillplayers(){
            list.add(new Player("Usain St Leo Bolt",33,(long)90000000,"Track and Field",R.drawable.bolt,"https://en.wikipedia.org/wiki/Usain_Bolt"));
            list.add(new Player("Kobe Bryant",41,(long)500000000,"Basketball",R.drawable.kobe,"https://en.wikipedia.org/wiki/Kobe_Bryant"));
            list.add(new Player("Lionel Andrés Messi Cuccittini",32,(long)400000000,"Football",R.drawable.mesi,"https://en.wikipedia.org/wiki/Lionel_Messi"));
            list.add(new Player("Cristiano Ronaldo dos Santos Aveiro",34,(long)108000000,"Football",R.drawable.ronaldo,"https://en.wikipedia.org/wiki/Cristiano_Ronaldo"));
            list.add(new Player("Niels Bohr",134,(long)5000000,"Football",R.drawable.niels,"https://en.wikipedia.org/wiki/Niels_Bohr"));
            list.add(new Player("Harald Bohr",132,(long)5000000,"Football",R.drawable.bohr,"https://en.wikipedia.org/wiki/Harald_Bohr"));
            list.add(new Player("AlphaGo",4,(long)35000000,"Go",R.drawable.alphago,"https://en.wikipedia.org/wiki/AlphaGo"));
            list.add(new Player("Sun Yang",28,(long)10000000,"Swimming",R.drawable.sunyang,"https://en.wikipedia.org/wiki/Sun_Yang"));
            list.add(new Player("Anna Bessonova",35,(long)12000000,"Rhythmic Gymnastics", R.drawable.besa,"https://en.wikipedia.org/wiki/Anna_Bessonova"));
            list.add(new Player("Dina Averina",21,(long)16000000,"Rhythmic Gymnastics",R.drawable.evereena,"https://en.wikipedia.org/wiki/Dina_Averina"));
            list.add(new Player("Shiwen Ye",23,(long)16000000,"Swimming",R.drawable.shiwen,"https://en.wikipedia.org/wiki/Ye_Shiwen"));
            list.add(new Player("Jike Zhang",31,(long)20000000,"Table Tennis",R.drawable.jike,"https://en.wikipedia.org/wiki/Zhang_Jike"));
            list.add(new Player("Miro Jurisic",79,(long)20000000,"Badminton",R.drawable.miro,"https://cn.linkedin.com/in/miro-jurisic-4678a261"));
            list.add(new Player("Rookie Song",22,(long)200088888,"Electonic Sport",R.drawable.yijin,"https://lol.gamepedia.com/Rookie"));
            list.add(new Player("Tetsuya Kuroko",16,(long)2000,"Basketball",R.drawable.kuroko,"https://hero.fandom.com/wiki/Tetsuya_Kuroko"));
        }






            }


    //Todo create method that will fill list of players

