package com.dkotama.udayanaojsreader.view.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.home.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.dkotama.udayanaojsreader.presenter.home.HomePresenter;
import com.dkotama.udayanaojsreader.view.common.CommonActivity;
import com.dkotama.udayanaojsreader.view.login.LoginActivity;

import java.util.Iterator;
import java.util.List;

public class HomeActivity extends CommonActivity implements HomeContract.View {

    HomeContract.Presenter presenter;
    String TAG = "HomeActivity";

    RecyclerView recyclerView;
    ProgressBar progressBar;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        presenter = new HomePresenter(this);
        presenter.loadHome();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite_btn :
                makeError("Fav Selected", "selected").show();
                return true;
            case R.id.logout_btn:
                askLogout();
                return true;
            default:
                return true;
        }
    }

    @Override
    public void onLoadHomeSuccess(List<JournalItemData> journals) {
        adapter = new HomeAdapter(getBaseContext(), journals);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.INVISIBLE);

//        for (Iterator<JournalItemData> j = journals.iterator(); j.hasNext();) {
//            JournalItemData journal = j.next();
//
//            Log.d(TAG, "ID: " + journal.getId());
//        }
    }

    @Override
    public void onLoadHomeFailed(String message) {
        progressBar.setVisibility(View.INVISIBLE);
        makeError(message, "Error").show();
    }

    @Override
    public void onLogoutSuccess() {
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    private void askLogout() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(true);
        dialog.setTitle("Konfirmasi");
        dialog.setMessage("Apakah anda yakin ingin logout ?");
        dialog.setNegativeButton("Tidak", null);
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.logout();
            }
        });

        dialog.create().show();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
