package com.devarch.pushexample.notification

data class PushNotificationMessage(
    val data: NotificationData,
    val to: String
)