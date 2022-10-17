package com.lmar.chipbottomnavigation

import android.app.Activity
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast

fun Toast.showCustomToast(activity: Activity, message: String, type: ToastType = ToastType.INFO)
{
    val layout = activity.layoutInflater.inflate (
        R.layout.custom_toast_message,
        activity.findViewById(R.id.toastContainer)
    )

    val ivIndicator = layout.findViewById<FrameLayout>(R.id.toastIndicator)
    val drawable = ivIndicator.background
    Utils().setTint(drawable, type.color)

    // set the text of the TextView of the message
    val textView = layout.findViewById<TextView>(R.id.toastMessage)
    textView.text = message

    // use the application extension function
    this.apply {
        setGravity(Gravity.BOTTOM, 0, 230)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}