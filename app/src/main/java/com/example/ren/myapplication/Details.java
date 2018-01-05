package com.example.ren.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ren.myapplication.api.ApiClient;
import com.example.ren.myapplication.api.ApiInterface;
import com.example.ren.myapplication.model.ModelDetail;
import com.example.ren.myapplication.model.ModelPopular;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Details extends AppCompatActivity {
    Unbinder unbinder;
    ApiInterface apiInterface;

    @BindView(R.id.title)
    TextView title;

    ModelDetail detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        unbinder = ButterKnife.bind(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Bundle bundle = getIntent().getExtras();
        detail = new ModelDetail();

        Call<ModelDetail> call = apiInterface.getDetail(Integer.parseInt(bundle.getString("id")));
        call.enqueue(new Callback<ModelDetail>() {
            @Override
            public void onResponse(Call<ModelDetail> call, Response<ModelDetail> response) {
                detail = response.body();
                setLayouts(detail.getTitle());
            }

            @Override
            public void onFailure(Call<ModelDetail> call, Throwable t) {
                Log.e("error", t.toString());
                Log.e("error", "error broh");
            }
        });
    }

    public void setLayouts(String titles) {
        title.setText(titles);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
