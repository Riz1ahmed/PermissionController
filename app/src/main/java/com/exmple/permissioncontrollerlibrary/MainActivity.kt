package com.exmple.permissioncontrollerlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.exmple.permissioncontrollerlibrary.databinding.ActivityMainBinding
import com.video_lab.permission_controller.PermissionListener
import com.video_lab.permission_controller.PermissionsController

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStoragePermission.setOnClickListener {
            PermissionsController.check(
                this, arrayListOf(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                ), object : PermissionListener {
                    override fun allGranted() {
                        Toast.makeText(
                            this@MainActivity,
                            "Storage permissions granted.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun allNotGranted(deniedList: ArrayList<String>) {
                        super.allNotGranted(deniedList)
                        Toast.makeText(
                            this@MainActivity,
                            "Storage permission granted failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
        binding.btnCameraPermission.setOnClickListener {
            PermissionsController.check(
                this, arrayListOf(
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.READ_CONTACTS
                ), object : PermissionListener {
                    override fun allGranted() {
                        Toast.makeText(
                            this@MainActivity,
                            "Camera & Contact permissions granted.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun allNotGranted(deniedList: ArrayList<String>) {
                        super.allNotGranted(deniedList)
                        Toast.makeText(
                            this@MainActivity,
                            "Some/All permission failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
    }
}