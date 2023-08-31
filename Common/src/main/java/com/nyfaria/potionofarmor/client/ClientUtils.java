package com.nyfaria.potionofarmor.client;

import net.minecraft.util.Mth;

import java.util.Date;

public class ClientUtils {
    public static int getColor() {
        double p = new Date().getTime() % 6400d / 6400d;
        if(p < 0.5) {
            p = p * 2;
        } else {
            p = (1-p) * 2;
        }
        int r = Mth.floor(2 * p + 247 * (1 - p));
        int g = Mth.floor(253 * p + 8 * (1 - p));
        int b = Mth.floor(255 * p + 221 * (1 - p));

        return getIntColor(r, g, b);
    }
    public static int getIntColor(int r, int g, int b) {
        return ((255 & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8) |
                ((b & 0xFF) << 0);
    }
}
