package com.example.ecommercesiteforonlineshopping.ui

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.ecommercesiteforonlineshopping.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ViewMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val permissions = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_maps)
        checkRunTimePermission()

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.addMarker(
            MarkerOptions().position(LatLng(27.7052354,85.3272271))
                .title("SMBK WEARS, Kathmandu")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(27.7052354,85.3272271),20F),4000,null
        )
   
        mMap.uiSettings.isZoomControlsEnabled = true
    }
    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()
        }
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@ViewMapsActivity, permissions, 1)
    }

}