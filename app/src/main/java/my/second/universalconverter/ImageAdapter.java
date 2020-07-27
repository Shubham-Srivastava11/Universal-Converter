package my.second.universalconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter {



    ArrayList<Item> thumb = new ArrayList<Item>();

    public ImageAdapter(Context c, int textViewResourceId, ArrayList<Item> objects) {
        super(c, textViewResourceId, objects);
        thumb = objects;
    }
    @Override
    public int getCount() {
        
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_item, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        textView.setText(thumb.get(position).getItemName());
        imageView.setImageResource(thumb.get(position).getItemImage());
        return v;
    }


}
