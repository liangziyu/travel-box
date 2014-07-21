package com.socialmap.yy.travelbox;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.socialmap.yy.travelbox.R;

public class TestAMap extends Activity {

    private MapView mapView;
    private AMap aMap;

    private View infoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_amap);

        infoWindow = getLayoutInflater().inflate(R.layout.map_info_window, null);

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 必须要写
        init();

        MarkerOptions mo = new MarkerOptions();
        mo.anchor(0.5f, 1f);//图标下尖点
        mo.title("Title");
        mo.snippet("Hello, Hello, Hello");
        mo.draggable(true);
        mo.visible(true);
        mo.position(new LatLng(39.9, 116.38));

        Marker m = aMap.addMarker(mo);

        m.setTitle("Show me the title");
        //m.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.a));

        m.showInfoWindow();

        Log.i("yy", "info window: " + m.isInfoWindowShown());

        Log.i("yy", m.getTitle());

        aMap.postInvalidate();
        aMap.setOnInfoWindowClickListener(new AMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

            }
        });
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                Toast.makeText(TestAMap.this, "aaa", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        aMap.setInfoWindowAdapter(new AMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                TextView title = (TextView)infoWindow.findViewById(R.id.title);
                TextView content = (TextView)infoWindow.findViewById(R.id.content);
                title.setText(marker.getTitle());
                content.setText(marker.getSnippet());
                return infoWindow;
            }

            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }
        });


    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_amap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
