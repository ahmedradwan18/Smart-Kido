package com.elasdka2.myapp.BroadCastReceiver;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.elasdka2.myapp.Login;
import com.elasdka2.myapp.NotificationInstruction;
import com.elasdka2.myapp.R;

import java.util.Random;

public class NotificationAlarmService extends Service {

    NotificationCompat.Builder builder;
    Intent notificationIntent;

    String Instruction1,Instruction2,Instruction3,Instruction4,Instruction5;
    String Instruction6,Instruction7,Instruction8,Instruction9,Instruction10;
    String Instruction11,Instruction12,Instruction13,Instruction14,Instruction15;
    String Instruction16,Instruction17;

    @Override
    public int onStartCommand(Intent intent,int flag, int startId)
    {
        super.onStartCommand(intent, flag, startId);

        Instruction1  = "Do take a multivitamin";

        Instruction2  = "Eating a balanced diet that’s rich in vitamins and minerals is the best way to provide your body with all of the healthy nutrients it needs to support a growing baby. A healthy diet alone, however, may not be enough for pregnancy.";

        Instruction3  = "Prenatal vitamins contain higher levels of certain nutrients that expectant mothers require at higher doses, such as:\n" +
                "*folic acid\n" +
                "*calcium\n" +
                "*iron\n" +
                "These vitamins assist with proper development of the fetus and help prevent birth defects. Your doctor can help you find a multivitamin or a series of vitamins that are best for you.\n";

        Instruction4  = "A multivitamin will usually include DHA, EPA, or both. These are omega-3 fats that are important for your baby’s proper brain development.";

        Instruction5  = "Don’t take more than one dose of multivitamins, though. Some vitamins in higher amounts can be harmful to the baby.";

        Instruction6  = "Don’t smoke\n" +
                "Babies born to women who smoke during pregnancy are more likely Trusted Source to have a lower birth weight and are at a greater risk for learning disabilities than children born to nonsmoking mothers.\n" +
                "\n" +
                "Additionally, children born to women who smoke are more likely to try smoking at a younger age and become regular smokers earlier, due to physiologic nicotine addiction.\n";

        Instruction7  = "Do get lots of sleep\n" +
                "Changing hormone levels, anticipation, and anxiety can make sleep elusive during your 9 months of pregnancy. Pregnancy is demanding, especially in the final trimester, and you’ll need your sleep.\n" +
                "Take a quick snooze if you feel tired and schedule naps whenever you can. Set bedtimes and stick to them.\n" +
                "Aim for 7-9 hours of shut-eye each night. Fatigue is a sign that your body needs more rest, so give yourself all the sleep you can.\n";

        Instruction8  = "Don’t drink alcohol\n" +
                "Alcohol may greatly impact your baby’s development. People who drink alcohol while pregnant could deliver a baby with fetal alcohol syndrome (FAS).\n" +
                "Symptoms of FAS include:\n" +
                "*low birth weight\n" +
                "*learning disabilities\n" +
                "*behavior problems\n" +
                "*lagging patterns in terms of growth and development milestones\n" +
                "Even small amounts of alcohol can be a problem. There appears to be no safe level of alcohol intake in pregnancy.\n" +
                "\n" +
                "If you need help stopping drinking while you’re pregnant, talk with your doctor as soon as possible. The sooner you get help, the healthier your baby is likely to be.\n";

        Instruction9  = "Do work out\n" +
                "Gone are the days of pregnant women avoiding lifting a finger during their pregnancies: We now know that exercise is good for mama and baby.\n" +
                "In fact, regular exercise may help you combat many of the issues that arise during pregnancy, including:\n" +
                "*insomnia\n" +
                "*muscle pain\n" +
                "*excessive weight gain\n" +
                "*mood problems\n" +
                "If you regularly exercised before you became pregnant, keep it up. Talk with your doctor about any adjustments you should make to your routine, especially as you move into your second and third trimesters.\n" +
                "If you didn't exercise regularly before you found out you were expecting, ask your doctor about incorporating a fitness routine into your day. They can guide you into a program that’s safe and comfortable for you and your growing baby.";

        Instruction10 = "Don’t eat raw meat\n" +
                "Raw and undercooked meat and eggs carry the risk of foodborne illness, such as listeriosis and toxoplasmosis. Food poisoning is also a possibility.\n" +
                "\n" +
                "These conditions can cause serious, life-threatening illnesses that could lead to severe birth defects and even miscarriage. Make sure all eggs and meat that you eat while pregnant are well-cooked.\n";

        Instruction11 = "Do eat seafood\n" +
                "Seafood is loaded with vitamins and minerals, such as heart-healthy omega-3 fatty acids, zinc, and iron. These are all important for both mom and baby. But undercooked or raw seafood can cause some problems.\n" +
                "\n" +
                "Seafood may carry harmful bacteria and viruses, which are eliminated when thoroughly cooked. Also, pregnant women should avoid raw fish and fish that may contain high levels of mercury.\n" +
                "\n" +
                "Examples of fish containing high levels of mercury include:\n" +
                "*swordfish\n" +
                "*tilefish\n" +
                "*king mackerel\n" +
                "Eat a variety of seafood so you don’t have a concentration of minerals from one type of fish. Eat no more than 12 ounces of fish per week.\n";

        Instruction12 = "Do have sex\n" +
                "Sex during pregnancy is fine, as long as you don’t have a complicating factor such as placenta previa or another type of high-risk pregnancy.\n" +
                "\n" +
                "Sex is safe with your partner right up until your water breaks. If you have discomfort you may have to try new positions. Talk with your doctor if you have any questions about the safety of intercourse during your pregnancy.\n";


        Instruction13 = ") Do practice yoga\n" +
                "You should avoid Bikram or hot yoga, but other yoga modalities are fine when you’re expecting. Seek out prenatal or gentle yoga classes that are designed for mothers-to-be. Instructors in these classes will know which poses are best and which you should avoid.\n" +
                "\n" +
                "If you weren’t doing yoga before you became pregnant, talk with your doctor before signing up for a class. While it’s possible you can start, it’s best to go over the risks and concerns with your doctor.\n";

        Instruction14 = "Don’t sit in a hot tub or sauna\n" +
                "Though relaxing, the high-heat environment of hot tubs, Jacuzzis, and saunas may be too dangerous for expecting mothers.\n" +
                "\n" +
                "In fact, research suggests that using one of these during your first trimester may double your risk of miscarriage. Soaking in hot water can raise body temperature and this causes problems with the baby including increasing the risk of birth defects.\n";

        Instruction15 = "Don’t drink a lot of caffeine\n" +
                "Caffeine can travel through the placenta and increase your baby’s heart rate.\n" +
                "\n" +
                "Current research suggests that women can safely consume a cup or two of coffee each day, but forego downing a triple-shot latte while you’re carrying.\n";

        Instruction16 = "Do gain weight smartly\n" +
                "The “eat for two” advice to expecting mothers isn’t a license to eat whatever you’d like. Instead, women need to be strategic about what they eat and how much.\n" +
                "Gaining a lot of weight during pregnancy may do more harm to your baby than good. During your first trimester, you only need about 100 extra calories a day to support your growing fetus.\n" +
                "By your third trimester, that additional calorie number is closer to 300 per day.\n";

        Instruction17 = "Do visit your dentist\n" +
                "Trips to the dentist’s office were avoided for decades for fear that an oral cleaning might cause bacteria to spread and lead to an infection. Now we know that’s just not the case.\n" +
                "\n" +
                "In fact, the American College of Obstetricians and Gynecologists recommends that expectant mothers have a routine oral health assessment while pregnant, along with regular dental cleanings. Be sure to tell your dentist that you’re pregnant.\n";

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationIntent = new Intent(this, NotificationInstruction.class);

        generateRandom();

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {


            String CHANNEL_ID = "my_channel_01";
            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);
        }else {
            builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Today Instruction")
                    .setContentText("Tap To show Instruction Description")
                    .setSound(alarmSound)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setVibrate(new long[] {1000,1000,1000,1000,1000});


            notificationManager.notify(0,builder.build());
        }

        return START_STICKY;
    }

    public int generateRandom() {
        Random rand = new Random();
        int randVal = rand.nextInt(16);

        switch (randVal) {
            case 0:
                notificationIntent.putExtra("InstructionDescription",Instruction1);
              //  builder.setContentText(Instruction1);
                break;
            case 1:
                notificationIntent.putExtra("InstructionDescription",Instruction2);
              //  builder.setContentText(Instruction2);
                break;
            case 2:
                notificationIntent.putExtra("InstructionDescription",Instruction3);
             //   builder.setContentText(Instruction3);
                break;
            case 3:
                notificationIntent.putExtra("InstructionDescription",Instruction4);

               // builder.setContentText(Instruction4);
                break;
            case 4:
                notificationIntent.putExtra("InstructionDescription",Instruction5);

              //  builder.setContentText(Instruction5);
                break;
            case 5:
                notificationIntent.putExtra("InstructionDescription",Instruction6);

              //  builder.setContentText(Instruction6);
                break;
            case 6:
                notificationIntent.putExtra("InstructionDescription",Instruction7);

              //  builder.setContentText(Instruction7);
                break;
            case 7:
                notificationIntent.putExtra("InstructionDescription",Instruction8);

            //    builder.setContentText(Instruction8);
                break;
            case 8:
                notificationIntent.putExtra("InstructionDescription",Instruction9);

             //   builder.setContentText(Instruction9);
                break;
            case 9:
                notificationIntent.putExtra("InstructionDescription",Instruction10);

              //  builder.setContentText(Instruction10);
                break;
            case 10:
                notificationIntent.putExtra("InstructionDescription",Instruction11);

              //  builder.setContentText(Instruction11);
                break;
            case 11:
                notificationIntent.putExtra("InstructionDescription",Instruction12);

              //  builder.setContentText(Instruction12);
                break;
            case 12:
                notificationIntent.putExtra("InstructionDescription",Instruction13);

              //  builder.setContentText(Instruction13);
                break;
            case 13:
                notificationIntent.putExtra("InstructionDescription",Instruction14);

              //  builder.setContentText(Instruction14);
                break;
            case 14:
                notificationIntent.putExtra("InstructionDescription",Instruction15);

               // builder.setContentText(Instruction15);
                break;
            case 15:
                notificationIntent.putExtra("InstructionDescription",Instruction16);

               // builder.setContentText(Instruction16);
                break;
            case 16:
                notificationIntent.putExtra("InstructionDescription",Instruction17);

               // builder.setContentText(Instruction17);
                break;
        }

        return randVal;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
