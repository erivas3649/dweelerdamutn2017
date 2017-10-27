package ar.com.dweeler.dweeler.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nemesys on 26/10/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentData;
    private List<String> titleData;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentData = new ArrayList<>();
        titleData = new ArrayList<>();
    }

    public void addTab(Fragment f, String title) {
        this.fragmentData.add(f);
        this.titleData.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentData.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleData.get(position);
    }

    @Override
    public int getCount() {
        return fragmentData.size();
    }
}
