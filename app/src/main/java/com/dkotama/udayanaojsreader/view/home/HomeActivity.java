package com.dkotama.udayanaojsreader.view.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.home.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.dkotama.udayanaojsreader.presenter.home.HomePresenter;
import com.dkotama.udayanaojsreader.view.common.CommonActivity;
import com.dkotama.udayanaojsreader.view.login.LoginActivity;

import java.util.List;

public class HomeActivity extends CommonActivity implements HomeContract.View {

    HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        presenter = new HomePresenter(this);
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

    }

    @Override
    public void onLoadHomeFailed(String message) {

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
}
