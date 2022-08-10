package com.example.smart_campus.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FCMessagingService :FirebaseMessagingService(){
    override fun onNewToken(token: String) {
        //새로운 token 생성 callback
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.takeIf { it.data.isNotEmpty() }?.apply {
            Log.e("remote", "onMessageReceived: $remoteMessage", )

            //psuh를 전달받으면 동작하는 함수
        }
    }
}