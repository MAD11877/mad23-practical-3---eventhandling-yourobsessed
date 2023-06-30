package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user1 = new User("Rae", "Smart", 25, true);
        user1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");

        user1.setName("MAD" + randomNoGenerator() );
        // Load followed value from the User object
        boolean followed = user1.isFollowed();

        // Update the button text based on the followed value
        Button followButton = findViewById(R.id.button3);
        Button messageButton = findViewById(R.id.button4);

        if (followed) {
            followButton.setText("Followed");
        } else {
            followButton.setText("Follow");
        }

        // Set OnClickListener for the button
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the followed value
                user1.setFollowed(!user1.isFollowed());

                // Update the button text based on the new followed value
                if (user1.isFollowed()) {
                    followButton.setText("Followed");
                } else {
                    followButton.setText("Follow");
                }

                // Perform any additional actions based on the button click
                // ...
            }
        });

        // Retrieve data from intent extras
        Intent intent = getIntent();
        String name = intent.getStringExtra("MAD");
        int randomNumber = intent.getIntExtra("randomNumber", 0);

        TextView textView = findViewById(R.id.textView);
        textView.setText(user1.getName());



        TextView textView2 = findViewById(R.id.textView2);
        //textView.setText(String.format("MAD " + randomNumber));
        textView2.setText(user1.getDescription());

    }
    private int randomNoGenerator(){
        Random rand = new Random();
        int myNumber = Math.abs(rand.nextInt(2147483647));
        return myNumber;
    }


}