package ru.turpattaya.turpattayaapp.excursions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.turpattaya.turpattayaapp.R;

/**
 * Created by MSI on 29.10.2016.
 */
public class ExcursionImageItem extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.image_for_viewpager_detailactivity, container, false);
        Bundle bundle = getArguments();
        String url = bundle.getString("url", "");

        ImageView excursionDetailImage = (ImageView) rootView.findViewById(R.id.image_excursion_detail);
        Picasso.with(container.getContext()).load(url).fit().centerCrop().into(excursionDetailImage);

        return rootView;
    }
}
