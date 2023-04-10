package com.devarch.pushexample.client

import com.devarch.pushexample.constants.FireBaseConstants
import com.devarch.pushexample.notification.FirebaseNotificationAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(FireBaseConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val notificationApi: FirebaseNotificationAPI by lazy {
            retrofit.create(FirebaseNotificationAPI::class.java)
        }
    }
}