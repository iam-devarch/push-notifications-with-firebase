package com.devarch.pushexample.notification

import com.devarch.pushexample.constants.FireBaseConstants.Companion.CONTENT_TYPE
import com.devarch.pushexample.constants.FireBaseConstants.Companion.SERVER_KEY
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface FirebaseNotificationAPI {

    @Headers("Authorization: key=$SERVER_KEY", "Content-Type:$CONTENT_TYPE")
    @POST("fcm/send")
    suspend fun postNotification(
        @Body pushNotificationMessage: PushNotificationMessage
    ): Response<ResponseBody>
}