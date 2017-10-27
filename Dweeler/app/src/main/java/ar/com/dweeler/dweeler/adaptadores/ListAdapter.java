package ar.com.dweeler.dweeler.adaptadores;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by nemesys on 25/10/17.
 */

public abstract class ListAdapter<E> extends BaseAdapter {

    protected List<E> data;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public E getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
