package com.devarch.pushexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.devarch.pushexample.client.RetrofitClientInstance
import com.devarch.pushexample.notification.FirebaseNotificationListener
import com.devarch.pushexample.notification.NotificationData
import com.devarch.pushexample.notification.PushNotificationMessage
import com.google.firebase.iid.FirebaseInstanceId
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseNotificationListener.sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            FirebaseNotificationListener.token = it.token
            Log.d(TAG, "Token is ::${FirebaseNotificationListener.token}")
            etNotificationToken.setText(it.token)
        }

        btnNotificationSend.setOnClickListener {
            val title = etNotificationTitle.text.toString()
            val message = etNotificationMessage.text.toString()
            val recipientToken = etNotificationToken.text.toString()
            if(title.isNotEmpty() && message.isNotEmpty() && recipientToken.isNotEmpty()) {
                PushNotificationMessage(
                        NotificationData(title, message),
                        recipientToken
                ).also {
                    sendNotification(it)
                }
            }
        }
    }

    private fun sendNotification(pushNotificationMessage: PushNotificationMessage) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitClientInstance.notificationApi.postNotification(pushNotificationMessage)
            if(response.isSuccessful) {
                Log.d(TAG, "Response: ${Gson().toJson(response)}")
            } else {
                Log.e(TAG, response.errorBody()?.string())
            }
        } catch(e: Exception) {
            Log.e(TAG, e.toString())
        }
    }
}
