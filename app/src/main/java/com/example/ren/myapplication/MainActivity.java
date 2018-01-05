package com.example.ren.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ren.myapplication.adapter.AdapterPopular;
import com.example.ren.myapplication.api.ApiClient;
import com.example.ren.myapplication.api.ApiInterface;
import com.example.ren.myapplication.model.ModelPopular;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    Unbinder unbinder;

    @BindView(R.id.rv)
    RecyclerView rv;

    LinearLayoutManager llm;
    AdapterPopular adapter;
    ModelPopular list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        unbinder = ButterKnife.bind(this);
        list = new ModelPopular();
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        Call<ModelPopular> call = apiInterface.getPopular();

        call.enqueue(new Callback<ModelPopular>() {
            @Override
            public void onResponse(Call<ModelPopular> call, Response<ModelPopular> response) {
                if (response.code() == 200) {
                    list = response.body();
                    setAdapters(list.getResults());
                } else {
                    Log.e("error", "Data tidak bisa");
                }
            }

            @Override
            public void onFailure(Call<ModelPopular> call, Throwable t) {
                Log.e("error", t.toString());
                Log.e("error", "error broh");
            }
        });
    }

    public void setAdapters(final List<ModelPopular.Results> results) {
        adapter = new AdapterPopular(this, results, new AdapterPopular.AdapterCallback() {
            @Override
            public void onMethodCallback(int id) {

                Intent intent = new Intent(MainActivity.this, Details.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", String.valueOf(id));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
