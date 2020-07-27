package my.second.universalconverter;

import android.app.WallpaperInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.androidsx.rateme.RateMeDialog;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Arrays;

public class Support extends AppCompatActivity {
    private static final String TAG = "Support";
    private RewardedAd rewardedAd;
    private Button bt;
    Context context;
    private Vibrator vibe;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.support_me);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        bt = findViewById(R.id.button12);
        loadAd();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAd();
            }
        });
//        bt.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View v) {
//
//                vibe.vibrate(20);
//
//                try {
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("market://details?id=" + this.getPackageName())));
//                } catch (android.content.ActivityNotFoundException e) {
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
//                }
//
////                Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
////                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
////                // To count with Play market backstack, After pressing back button,
////                // to taken back to our application, we need to add following flags to intent.
////                System.out.println(context.getPackageName());
////                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
////                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
////                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
////                try {
////                    startActivity(goToMarket);
////                } catch (ActivityNotFoundException e) {
////                    startActivity(new Intent(Intent.ACTION_VIEW,
////                            Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
////                }
//            }
//        });

        new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("B8A97AFE36E8F28CA5AE1CE938B87344"));

    }

    public void loadAd(){
        this.rewardedAd = new RewardedAd(this,"ca-app-pub-9674543621331425/4665755399");
        RewardedAdLoadCallback callback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdFailedToLoad(int i) {
                super.onRewardedAdFailedToLoad(i);
                Log.i(TAG,"onRewardedAdFailedToLoad" );
            }

            @Override
            public void onRewardedAdLoaded() {
                super.onRewardedAdLoaded();
                Log.i(TAG,"onRewardedAdLoaded");
            }
        };
        this.rewardedAd.loadAd(new AdRequest.Builder().build(), callback);
//        showAd();
    }
    public void showAd(){

        vibe.vibrate(20);
        if(this.rewardedAd.isLoaded()){
            RewardedAdCallback callback = new RewardedAdCallback(){
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    Log.i(TAG,"onUserEarnedReward");
                }
            };
            this.rewardedAd.show(this,callback);
        }else Log.i(TAG,"Ad not loaded");

    }

    public void rateMe(View view){
        vibe.vibrate(20);
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + this.getPackageName())));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }
}
