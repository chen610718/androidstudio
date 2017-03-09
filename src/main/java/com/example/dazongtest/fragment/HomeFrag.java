package com.example.dazongtest.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dazongtest.R;
import com.example.dazongtest.activity.CityLoctionAct;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class HomeFrag extends Fragment {
    @ViewInject(R.id.iv_loc)
    private ImageView iv_loc;
    @ViewInject(R.id.tv_loc)
    private TextView tv_loc;

    private LocationManager mLocationManger;
    private static final int REQUEST_CODE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.frag_home, container, false);
        ViewUtils.inject(this, _view);
        return _view;
    }

    @OnClick(R.id.iv_loc)
    private void onIvLocClick(View view) {
        startActivity(new Intent(getContext(), CityLoctionAct.class));
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationManger = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        checkPermission();
        mLocationManger.requestLocationUpdates("", 30000, 10, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Geocoder _geocoder = new Geocoder(getContext());
                try {
                    List<Address> _list = _geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),2);
                    if (_list.size()>0){
                        tv_loc.setText(_list.get(0).toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        });
    }

    private void checkPermission(){
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE);
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
