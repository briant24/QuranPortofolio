package com.michi.quran;

public class QiblaDirection {
    public static double calculateQiblaDirection(double userLatitude, double userLongitude) {
        double qiblaLatitude = 21.42250833; // Latitude of Kaaba
        double qiblaLongitude = 39.82616111; // Longitude of Kaaba

        double lKlM = Math.toRadians(qiblaLongitude - userLongitude);
        double sinLKLM = Math.sin(lKlM);
        double cosLKLM = Math.cos(lKlM);
        double sinLM = Math.sin(Math.toRadians(userLatitude));
        double cosLM = Math.cos(Math.toRadians(userLatitude));
        double tanLK = Math.tan(Math.toRadians(qiblaLatitude));

        double denominator = (cosLM * tanLK) - sinLM * cosLKLM;

        double qibla = Math.atan2(sinLKLM, denominator);
        qibla = Math.toDegrees(qibla);

        if (qibla < 0) {
            qibla += 360;
        }

        return qibla;
    }
}

