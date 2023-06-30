package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView image = findViewById(R.id.imageView2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileClicked();
                // Code to be executed when the ImageView is clicked
                // Navigate to MainActivity or perform any desired action
                //Intent intent = new Intent(ListActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });


    }
    private void profileClicked(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        //builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                int id = randomNoGenerator();
                String k = String.valueOf(id);

                Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                activityName.putExtra("key", k);

                Log.v("hi", k);
                //Log.v(TITLE, String.valueOf(myUser.getId()));
                startActivity(activityName);
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
    private int randomNoGenerator(){
        Random rand = new Random();
        int myNumber = Math.abs(rand.nextInt(2147483647));
        return myNumber;
    }
}