package com.example.mapsalud.presentation.main.view.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mapsalud.R;
import com.example.mapsalud.presentation.main.presenter.MainPresenter;
import com.example.mapsalud.presentation.main.presenter.implementations.MainPresenterImpl;
import com.example.mapsalud.presentation.main.view.adapter.RVUserAdapter;
import com.example.mapsalud.presentation.main.view.interfaces.IMainView;
import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;
import com.example.mapsalud.presentation.util.view.dialog.AlertUtils;
import com.example.mapsalud.presentation.util.view.dialog.ProgressDialogFragment;

public class MainActivity extends AppCompatActivity implements IMainView {

    private Toolbar toolbar;
    private EditText etActivityPage;
    private Button btMainActivityBuscar;
    private ProgressDialogFragment mProgressDialogFragment;
    private MainPresenter mMainPresenter;
    private RVUserAdapter mRVUserAdapter;
    private RecyclerView rvData;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarItem);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        setUpToolbar();
        mProgressDialogFragment = new ProgressDialogFragment();
        mMainPresenter = new MainPresenterImpl(MainActivity.this);
        mRVUserAdapter = new RVUserAdapter();
        rvData = (RecyclerView) findViewById(R.id.rvData);
        rvData.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvData.setAdapter(mRVUserAdapter);
        etActivityPage = findViewById(R.id.etActivityPage);
        btMainActivityBuscar = findViewById(R.id.btMainActivityBuscar);
        btMainActivityBuscar.setOnClickListener(btMainActivityBuscarClickListener);

    }

    View.OnClickListener btMainActivityBuscarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMainPresenter.validateFields(etActivityPage.getText().toString().trim());
        }
    };
    private void setUpToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        TextView tvToolbarItem = (TextView) findViewById(R.id.toolbarItem).findViewById(R.id.tvToolbarItem);
        tvToolbarItem.setText(R.string.Main_Activity_toolbar_text);
    }

    @Override
    public void onError(String error) {
        AlertUtils.showMessage(MainActivity.this,getResources().getString(R.string.app_name), error, getResources().getString(R.string.alert_accept_text), onAcceptDialogInterface);

    }

    DialogInterface.OnClickListener onAcceptDialogInterface = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    };

    @Override
    public void onNetworkError() {
        AlertUtils.showNetworkError(MainActivity.this);

    }

    @Override
    public void onTokenExpires() {

    }


    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.onAttach(MainActivity.this);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onLoader(boolean show) {
        if (show)
            mProgressDialogFragment.show(getFragmentManager(), ProgressDialogFragment.TAG);
        else
            mProgressDialogFragment.dismissAllowingStateLoss();
    }

    @Override
    public void onValidateFields(String page) {
        mMainPresenter.onGetUserPage(page);
    }

    @Override
    public void onGetUsersPage(GetUsersPageVM getUsersPageVM) {
        Log.e("UsersPage"," "+getUsersPageVM.getListData().size());
            if (!getUsersPageVM.getListData().isEmpty() || getUsersPageVM.getListData().size() > 0) {
                mRVUserAdapter.clearAllAndAddAll(getUsersPageVM.getListData());
            }else {
                mRVUserAdapter.clearAllAndAddAll(null);
            }

    }
}
