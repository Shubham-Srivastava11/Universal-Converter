package my.second.universalconverter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter1 extends BaseAdapter {
    private Context pContext;
    public GridAdapter1(Context c) {
        pContext = c;
    }

    @Override
    public int getCount() {
        return thumbImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(pContext);
        imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }
    public Integer[] thumbImages = {R.drawable.tool, R.drawable.setup};
}
