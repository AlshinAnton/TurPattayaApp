package ru.turpattaya.turpattayaapp.CurrencyExchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.turpattaya.turpattayaapp.R;

/**
 * Created by MSI on 12/14/2016.
 */

public class CurrencyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Currency> currencyList;

    public CurrencyAdapter(Context context, List<Currency> currencyList) {
        this.context = context;
        this.currencyList = currencyList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return currencyList.size();
    }

    @Override
    public Object getItem(int position) {
        return currencyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currencyItemView = layoutInflater.inflate(R.layout.currency_item, null);
        TextView tvName = (TextView) currencyItemView.findViewById(R.id.tvName);
        TextView tvRate = (TextView) currencyItemView.findViewById(R.id.tvRate);

        Currency currency = currencyList.get(position);
        tvName.setText(currency.getName());
        tvRate.setText(Double.toString(currency.getRate()));
        return currencyItemView;
    }
}
