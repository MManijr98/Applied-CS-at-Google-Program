package com.example.wordstack;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.target);


        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, myShadowBuilder, v, 0);
                return true;
            }
        };

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);

        txt4.setOnDragListener(dragListener);

    }
     View.OnDragListener dragListener = new View.OnDragListener() {

         @Override
         public boolean onDrag(View v, DragEvent event) {
             int dragEvent = event.getAction();
             final View view = (View) event.getLocalState();

             switch (dragEvent){
                 case DragEvent.ACTION_DRAG_ENTERED:


                     if (view.getId() == R.id.txt1) {
                         txt4.setText("TextView 1 is Entered");
                     } else if (view.getId()== R.id.txt2){
                         txt4.setText("TextView 2 is Entered");
                     } else if (view.getId()== R.id.txt3){
                         txt4.setText("TextView 3 is Entered");
                     }
                     break;
                 case DragEvent.ACTION_DRAG_EXITED:

                     if (view.getId() == R.id.txt1) {
                         txt4.setText("TextView 1 is Exitted");
                     } else if (view.getId()== R.id.txt2){
                         txt4.setText("TextView 2 is Exitted");
                     } else if (view.getId()== R.id.txt3){
                         txt4.setText("TextView 3 is Exitted");
                     }
                     break;
                 case DragEvent.ACTION_DROP:
                     if (view.getId() == R.id.txt1) {
                         txt4.setText("TextView 1 is Dropped");
                     } else if (view.getId()== R.id.txt2){
                         txt4.setText("TextView 2 is Dropped");
                     } else if (view.getId()== R.id.txt3){
                         txt4.setText("TextView 3 is Dropped");
                     }
                     view.animate()
                             .x(txt4.getX())
                             .y(txt4.getY())
                             .setDuration(700)
                             .start();
                     break;


             }
             return true;
         }
     };


        };


