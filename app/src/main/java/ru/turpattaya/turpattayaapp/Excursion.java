package ru.turpattaya.turpattayaapp;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class Excursion implements Comparable<Excursion> {

    private int imageViewitem;
    private String textExcursionItem;
    private String textPriceItem;

    private ViewPager viewPagerDetail;
    private String pagetitleExcursionDetail;
    private String contextExcursionDetail;

    public Excursion(ViewPager viewPagerDetail, String pagetitleExcursionDetail, String contextExcursionDetail) {
        this.viewPagerDetail = viewPagerDetail;
        this.pagetitleExcursionDetail = pagetitleExcursionDetail;
        this.contextExcursionDetail = contextExcursionDetail;

    }

    public Excursion(int imageViewItem, String textExcursionItem, String textPriceItem) {
        this.imageViewitem = imageViewItem;
        this.textExcursionItem = textExcursionItem;
        this.textPriceItem = textPriceItem;
    }

    public int getImageViewitem() {
        return imageViewitem;
    }

    public void setImageViewitem(int imageViewitem) {
        this.imageViewitem = imageViewitem;
    }

    public String getTextExcursionItem() {
        return textExcursionItem;
    }

    public void setTextExcursionItem(String textExcursionItem) {
        this.textExcursionItem = textExcursionItem;
    }

    public String getTextPriceItem() {
        return textPriceItem;
    }

    public void setTextPriceItem(String textPriceItem) {
        this.textPriceItem = textPriceItem;
    }

    @Override
    public int compareTo(Excursion another) {
        return getTextExcursionItem().compareTo(another.getTextExcursionItem());
    }

    public ViewPager getViewPagerDetail() {
        return viewPagerDetail;
    }

    public void setViewPagerDetail(ViewPager viewPagerDetail) {
        this.viewPagerDetail = viewPagerDetail;
    }

    public String getPagetitleExcursionDetail() {
        return pagetitleExcursionDetail;
    }

    public void setPagetitleExcursionDetail(String pagetitleExcursionDetail) {
        this.pagetitleExcursionDetail = pagetitleExcursionDetail;
    }

    public String getContextExcursionDetail() {
        return contextExcursionDetail;
    }

    public void setContextExcursionDetail(String contextExcursionDetail) {
        this.contextExcursionDetail = contextExcursionDetail;
    }
}