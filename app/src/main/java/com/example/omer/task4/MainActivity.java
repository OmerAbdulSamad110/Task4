package com.example.omer.task4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView slistView, clistView;
    List<String> simpleList = new ArrayList<>();
    List<String> customList = new ArrayList<>();
    List<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slistView = (ListView) findViewById(R.id.simple_list);
        clistView = (ListView) findViewById(R.id.custom_list);
        populateSimpleLV();
        populateCustomLV();
    }

    private void populateSimpleLV() {
        int a=1;
        for (int i = 0; i < 3; i++) {
            simpleList.add("item " + a);
            a++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, simpleList);
        slistView.setAdapter(adapter);
    }

    private void populateCustomLV() {
        int a=1;
        for (int i = 0; i < 3; i++) {
            customList.add("Person " + a);
            imageList.add(R.mipmap.ic_person);
            a++;
        }
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, imageList, customList);
        clistView.setAdapter(adapter);
    }
}

class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<Integer> images;
    private final List<String> items;


    public CustomAdapter(Context context, List<Integer> images, List<String> items) {
        super(context, R.layout.custom_lv, items);
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_lv, null, true);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_lv);
        TextView textView = (TextView) view.findViewById(R.id.text_lv);

        imageView.setImageResource(images.get(position));
        textView.setText(items.get(position));
        return view;
    }
}
