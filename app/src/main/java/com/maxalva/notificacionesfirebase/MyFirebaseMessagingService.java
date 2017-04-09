package com.maxalva.notificacionesfirebase;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by max on 07/04/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null){
            String titulo = remoteMessage.getNotification().getTitle();
            String texto = remoteMessage.getNotification().getBody();

            System.out.println("Notificación recibida");
            System.out.println("Titulo: " + titulo);
            System.out.println("Texto: " + texto);

            //mostramos la notificacion en la barra de estado
            showNotification(titulo, texto);
        }

        System.out.println("Data ==> " + remoteMessage.getData().toString());
        if (remoteMessage.getData() != null){
            System.out.println("Datos recibidos");
            System.out.println("Usuario: " + remoteMessage.getData().get("user"));
        }
    }

    private void showNotification(String title, String text){

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle(title)
                .setContentText(text);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

    }
}
