package ru.turpattaya.turpattayaapp;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ExcursionsListFragment extends Fragment  {

    String orderBy = "";
    static String selection= "";
    private static String likeQuery="";
/*
    public interface GoToDetailActivity {
        public void StartDetail();
    }
*/

    public ExcursionsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_excursions, container, false);
        ListView list = (ListView) view.findViewById(R.id.list_excursion);
/*        TextView title = (TextView) view.findViewById(R.id.excursion_detail_pagetitle); */

        MySQLiteHelper helper = new MySQLiteHelper(getContext());


        Cursor cursor = helper.getReadableDatabase().query(
                ExcursionTable.TABLE_EXCURSION,
                null,
                selection,
                null,
                null,
                null,
                orderBy
        );
        ExcursionAdapter adapter = new ExcursionAdapter(getContext(), cursor);

        list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public static void handleSearch(final MenuItem item) {

        final SearchView searchView = (SearchView) item.getActionView();

        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {   //как сделать так чтобы он по мере добавления букв фильтровал нашу
                                                                                    базу и соответственно при удалении искал по оставшимся буквам в поиске...?
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/

        final EditText et = (EditText) searchView.findViewById(R.id.search_src_text);

        item.expandActionView();
        searchView.setQuery(likeQuery, false);
        Log.d("happy", "Like query is " + likeQuery);

        if (et != null) {
            et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_NULL) { // поиск только когда пользователь нажал на поиск..
                        String query = et.getText().toString();
                        Log.d("happy", "In onEditorAction, query is:" + query);
                        if (query.equals("")) {
                            selection = "";
                            likeQuery = "";
                        } else {
                            selection = ExcursionTable.COLUMN_EXCURSION_PAGETITLE + " like '%" + query + "%'";// выглядит пимерно так : select * from
                            likeQuery = query;
                        }
                        /*updateAdapterCursor();*/
                        return true;
                    }
                    return false;
                }
            });
        }
    }
}