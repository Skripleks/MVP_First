package android.mvp_first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final First_model first_model = new First_model(MainActivity.this);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        first_model.insert("Test", "Тест");
        first_model.insert("Book", "Книга");
        first_model.insert("Pen", "Ручка");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               first_model.give_en_word(editText.getText().toString());
               textView.setText(first_model.set_en_word());
            }
        });


    }
}
