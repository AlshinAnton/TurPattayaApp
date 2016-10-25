package ru.turpattaya.turpattayaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ExcursionDetailActivity extends AppCompatActivity {

    private TextView pagetitleExcursionDetail;
    private TextView contextExcursionDetail;

    private ViewPager viewPagerDetail;
    private MyAdapter adapter;
    int[] imageArray = new int[]{};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_detail);

        pagetitleExcursionDetail = (TextView) findViewById(R.id.excursion_detail_pagetitle);
        contextExcursionDetail = (TextView) findViewById(R.id.excursion_detail_content);

        adapter = new MyAdapter(getSupportFragmentManager(), imageArray);
        viewPagerDetail = (ViewPager) findViewById(R.id.viewPager_excursion_detail);

        viewPagerDetail.setAdapter(adapter);
        viewPagerDetail.setCurrentItem( 1 );
        viewPagerDetail.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int index) {
                Log.v( "onPageSelected", String.valueOf( index ) );
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // Log.v("onPageScrolled", "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.v("onPageScrollStateCh", String.valueOf(state));

                if (state ==ViewPager.SCROLL_STATE_IDLE) {
                    int index = viewPagerDetail.getCurrentItem();
                    if ( index == 0 )
                        viewPagerDetail.setCurrentItem( adapter.getCount() - 2, false );
                    else if ( index == adapter.getCount() - 1 )
                        viewPagerDetail.setCurrentItem( 1, false);
                }
            }
        });
    }


    public static class MyAdapter extends FragmentPagerAdapter {

        int[] promoImageIds;

        public MyAdapter(FragmentManager fm, int[] promoImageIds){
            super(fm);
            this.promoImageIds = promoImageIds;
        }

        @Override
        public int getCount(){
            return promoImageIds.length;
        }

        @Override
        public Fragment getItem(int position) {

            return PromoFragment.newInstance( promoImageIds[position] );
        }
    }

    public static class PromoFragment extends Fragment
    {
        int imageID;


        static PromoFragment newInstance( int imageID)
        {
            PromoFragment f = new PromoFragment();

            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt( "imageID", imageID );
            f.setArguments(args);

            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            imageID = getArguments() != null ? getArguments().getInt( "imageID" ) : null;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            ImageView v = (ImageView) inflater.inflate(R.layout.viewpager_detail, container, false);
            v.setImageResource( imageID );
            return v;
        }
    }
}






    /*private void setupViewPagerDetail(ViewPager viewPagerDetail) {
        ViewPagerDetailAdapter adapter = new ViewPagerDetailAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExcursionDetailFragment(), ImageView );
    }

    static class ViewPagerDetailAdapter extends FragmentPagerAdapter {

        private final List<Fragment> imageList = new ArrayList<>(); //контейнер для изображений


        public ViewPagerDetailAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return imageList.get(position);
        }

        @Override
        public int getCount() {
            return imageList.size();
        }
        void addFragment(Fragment fragment, ImageView imageView) {

        }
    }*/
