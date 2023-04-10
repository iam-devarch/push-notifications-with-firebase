# push-notifications-with-firebase
## Simple Android app based on Firebase notification to test simple push notifications sent via app


:warning: **As per google security [guidelines](https://firebase.google.com/docs/cloud-messaging/concept-options)**, _SERVER_KEY_ and _google-services.json_ are sensitive and hence are not included in the repo.

Please follow this [FCM documentation](https://firebase.google.com/docs/cloud-messaging/android/first-message) to send messages by registering your own app on Firebase and creating your own _SERVER_KEY_ and _google-services.json_ file


## Steps to send push notifications on this app

* Install app on two different devices or AVDs. 

* Copy Token of the one app into the Token text field of other app (By default token id of your own app will be displayed there)

* Key-in Title and Message and click on SEND

![Enter Token](/README_resources/app_1.png "Enter Token")

* Once you send it should appear as below if you are in-app

![Enter Token](/README_resources/app_2.png "Enter Token")

* And should appear as below in notification center

![Enter Token](/README_resources/app_3.png "Enter Token")
