package android.lucamps.controledefidelidade.Util;

import androidx.appcompat.app.AppCompatActivity;

public class ActionBarUtil {
    public static void configureActionBar(AppCompatActivity ctx,int iconHome, float elevation){
        ctx.getSupportActionBar().setHomeAsUpIndicator(iconHome);
        ctx.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ctx.getSupportActionBar().setElevation(elevation);
    }
    public static void configureActionBar(AppCompatActivity ctx, float elevation) {
        ctx.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ctx.getSupportActionBar().setElevation(elevation);
    }

    public static void configureActionBar(AppCompatActivity ctx,int iconHome){
        ctx.getSupportActionBar().setHomeAsUpIndicator(iconHome);
        ctx.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static void configureActionBar(AppCompatActivity ctx){
        ctx.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
