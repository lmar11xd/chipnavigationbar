package com.lmar.chipbottomnavigation

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.lmar.chipbottomnavigation.databinding.ActivityMainBinding //activity_main.xml
import com.lmar.chipbottomnavigation.databinding.CustomDialogBinding //custom_dialog.xml

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setUpTabBar()
        setUpButtom()
        setUpToast()
    }

    private fun setUpTabBar() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it) {
                R.id.nav_near -> binding.textMain.text = "Nearby"
                R.id.nav_new_chat -> binding.textMain.text = "Chat"
                R.id.nav_profile -> {
                    binding.textMain.text = "Profile"
                    binding.bottomNavBar.showBadge(R.id.nav_settings)
                }
                R.id.nav_settings -> {
                    binding.textMain.text = "Settings"
                    binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }
            }
        }
    }

    private fun setUpButtom() {
        binding.btnShowDialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater);
        val dialog = Dialog(this, R.style.DialogStyle)
        dialog.setContentView(dialogBinding.root)
        dialog.window!!.setBackgroundDrawableResource(R.drawable.bg_window)
        dialogBinding.btnClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun setUpToast() {
        binding.btnToast1.setOnClickListener {
            Toast.makeText(this, "This is a Simple Text", Toast.LENGTH_SHORT).show()
/*
            val toast: Toast = Toast.makeText(this, "This is a Text - Changing Position", Toast.LENGTH_SHORT)
            toast.show()
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 0, 0)
*/
        }
        binding.btnToast2.setOnClickListener {
            Toast(this).showCustomToast (this,"Custom Toast Error!", ToastType.ERROR)
        }
        binding.btnToast3.setOnClickListener {
            Toast(this).showCustomToast (this,"Custom Toast Info")
        }
    }
}