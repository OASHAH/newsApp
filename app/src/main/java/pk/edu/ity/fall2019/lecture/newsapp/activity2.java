package pk.edu.ity.fall2019.lecture.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    public static TextView d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        d = findViewById(R.id.display);

    }
}
