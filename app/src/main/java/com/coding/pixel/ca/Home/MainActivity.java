package com.coding.pixel.ca.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.coding.pixel.ca.AboutUs.AboutAppActivity;
import com.coding.pixel.ca.Adapter.Card2ItemAdapter;
import com.coding.pixel.ca.Adapter.CardItemAdapter;
import com.coding.pixel.ca.Adapter.ImageSliderAdapter;
import com.coding.pixel.ca.Adapter.TabsPagerAdapter;
import com.coding.pixel.ca.Classes.RecyclerItemClickListener;
import com.coding.pixel.ca.Dashboard.RatingActivity;
import com.coding.pixel.ca.ForgotPswrd.ForgotPasswordActivity;
import com.coding.pixel.ca.Friends.FriendsActivity;
import com.coding.pixel.ca.GovtAndPvtSector.GovtSectorActivity;
import com.coding.pixel.ca.GovtAndPvtSector.PrivateSectorActivity;
import com.coding.pixel.ca.Helping.HelpingActivity;
import com.coding.pixel.ca.LoginReg.LoginActivity;
import com.coding.pixel.ca.Dashboard.SettingActivity;
import com.coding.pixel.ca.Model.Card2ItemData;
import com.coding.pixel.ca.Model.CardItemData;
import com.coding.pixel.ca.Notification.NotificationActivity;
import com.coding.pixel.ca.PostsActivities.BlogPostActivity;
import com.coding.pixel.ca.PostsActivities.PostShownActivity;
import com.coding.pixel.ca.Profile.ProfileActivity;
import com.coding.pixel.ca.ProfileSetting.SettingsActivity;
import com.coding.pixel.ca.R;
import com.coding.pixel.ca.Search.SearchActivity;
import com.coding.pixel.ca.WebLinks.AppInfoActivity;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private CircleImageView NavProfileView;
    private TextView getUserName;
    private TextView getUserStatus;
    private FloatingActionButton userMsgBtn;

    private static final int TIME_LIMIT = 1500;
    private static long backPressed;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabsPagerAdapter mTabsPagerAdapter;
    private RecyclerView recyclerView_story, recyclerView_card, recyclerView_grid;
    private ViewFlipper viewFlipper;
    
    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference userDatabaseReference;
    public FirebaseUser currentUser;
    private FirebaseDatabase user_db;
    String currentUserId;

    private ConnectivityReceiver connectivityReceiver;

    private CardView card1;
    private SliderView sliderView;
    List<CardItemData>imageSliderModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        user_db = FirebaseDatabase.getInstance();
        //userDatabaseReference = user_db.getReference("users");
        if (currentUser != null){
            String user_uID = mAuth.getCurrentUser().getUid();

            userDatabaseReference = FirebaseDatabase.getInstance().getReference()
                    .child("users").child(user_uID);
        }
        userMsgBtn = findViewById(R.id.user_message);
        userMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageIntent = new Intent(MainActivity.this, FriendsActivity.class);
                startActivity(messageIntent);
            }
        });

        /**
         * Tabs >> Viewpager for MainActivity
         */
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);

        imageSliderModelList.add(new CardItemData(R.drawable.job_nts0, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job_ots1, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job_ppsc2, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job_pts3, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job4, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job5, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job6, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job7, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job8, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job9, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job10, "Job Opportunities"));
        imageSliderModelList.add(new CardItemData(R.drawable.job11, "Job Opportunities"));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this, imageSliderModelList));

        card1 = findViewById(R.id.card_1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jobIntent = new Intent(MainActivity.this, GovtSectorActivity.class);
                startActivity(jobIntent);
            }
        });

        recyclerView_grid = findViewById(R.id.card_2_recycler);
        ArrayList <Card2ItemData> c2list = new ArrayList<>();

        c2list.add(new Card2ItemData(R.drawable.isi_job, "Inter Service Intelligence"));
        c2list.add(new Card2ItemData(R.drawable.pma_job, "Pakistan Military Army"));
        c2list.add(new Card2ItemData(R.drawable.paf_job, "Pakistan Air Force"));
        c2list.add(new Card2ItemData(R.drawable.navy_job, "Pakistan Navy Force"));
        c2list.add(new Card2ItemData(R.drawable.nab_job, "National Accountability Bureau"));
        c2list.add(new Card2ItemData(R.drawable.hec_job, "Higher Education Commission"));
        c2list.add(new Card2ItemData(R.drawable.nts_job, "National Testing Service"));
        c2list.add(new Card2ItemData(R.drawable.ots_job, "Open Testing Service"));
        c2list.add(new Card2ItemData(R.drawable.pts_job, "Pakistan Testing Service"));
        c2list.add(new Card2ItemData(R.drawable.ppsc_job, "Punjab Public Service Commission"));
        c2list.add(new Card2ItemData(R.drawable.fpsc_job, "Federal Public Service Commission"));
        c2list.add(new Card2ItemData(R.drawable.pjp_job, "Pakistan Job Portal"));
        c2list.add(new Card2ItemData(R.drawable.jobee_job, "Jobee.pk Jobs"));
        c2list.add(new Card2ItemData(R.drawable.rozee_job, "Rozee.pk Jobs"));
        c2list.add(new Card2ItemData(R.drawable.dunya_job, "Dunya.pk Jobs"));


        Card2ItemAdapter adapter = new Card2ItemAdapter(c2list, this);
        recyclerView_grid.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView_card.setLayoutManager(layoutManager);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView_grid.setLayoutManager(layoutManager);

        recyclerView_grid.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView_grid, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Uri uri = Uri.parse("https://content.pk/pakistan/isi-the-inter-services-intelligence-agency-of-pakistan/");
                        Intent isiIntent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(isiIntent);
                        break;
                    case 1:
                        Uri uri1 = Uri.parse("https://pakistanarmy.gov.pk/");
                        Intent pakArmyIntent = new Intent(Intent.ACTION_VIEW, uri1);
                        startActivity(pakArmyIntent);
                        break;
                    case 2:
                        Uri uri2 = Uri.parse("http://www.paf.gov.pk/");
                        Intent pafArmyIntent = new Intent(Intent.ACTION_VIEW, uri2);
                        startActivity(pafArmyIntent);
                        break;
                    case 3:
                        Uri uri3 = Uri.parse("https://www.paknavy.gov.pk/");
                        Intent navyArmyIntent = new Intent(Intent.ACTION_VIEW, uri3);
                        startActivity(navyArmyIntent);
                        break;
                    case 4:
                        Uri uri4 = Uri.parse("https://nab.gov.pk/");
                        Intent nabArmyIntent = new Intent(Intent.ACTION_VIEW, uri4);
                        startActivity(nabArmyIntent);
                        break;
                    case 5:
                        Uri uri5 = Uri.parse("https://www.hec.gov.pk/english/pages/home.aspx");
                        Intent hecIntent = new Intent(Intent.ACTION_VIEW, uri5);
                        startActivity(hecIntent);
                        break;
                    case 6:
                        Uri uri6 = Uri.parse("https://www.nts.org.pk/");
                        Intent ntsIntent = new Intent(Intent.ACTION_VIEW, uri6);
                        startActivity(ntsIntent);
                        break;
                    case 7:
                        Uri uri7 = Uri.parse("https://www.ots.org.pk/");
                        Intent otsIntent = new Intent(Intent.ACTION_VIEW, uri7);
                        startActivity(otsIntent);
                        break;
                    case 8:
                        Uri uri8 = Uri.parse("http://pts.org.pk/");
                        Intent ptsIntent = new Intent(Intent.ACTION_VIEW, uri8);
                        startActivity(ptsIntent);
                        break;
                    case 9:
                        Uri uri9 = Uri.parse("http://www.ppsc.gop.pk/(S(bw45220hgj2ccnghyfqmjcsm))/default.aspx");
                        Intent ppscIntent = new Intent(Intent.ACTION_VIEW, uri9);
                        startActivity(ppscIntent);
                        break;
                    case 10:
                        Uri uri10 = Uri.parse("http://www.online.fpsc.gov.pk/index_gr.php");
                        Intent fpscIntent = new Intent(Intent.ACTION_VIEW, uri10);
                        startActivity(fpscIntent);
                        break;
                    case 11:
                        Uri uri11 = Uri.parse("https://pakistanjobsportal.com/");
                        Intent pjpIntent = new Intent(Intent.ACTION_VIEW, uri11);
                        startActivity(pjpIntent);
                        break;
                    case 12:
                        Uri uri12 = Uri.parse("https://jobee.pk/");
                        Intent jobeeIntent = new Intent(Intent.ACTION_VIEW, uri12);
                        startActivity(jobeeIntent);
                        break;
                    case 13:
                        Uri uri13 = Uri.parse("https://www.rozee.pk/");
                        Intent rozeeIntent = new Intent(Intent.ACTION_VIEW, uri13);
                        startActivity(rozeeIntent);
                        break;
                    case 14:
                        Uri uri14 = Uri.parse("https://jobsdunya.com/");
                        Intent dunyaJobIntent = new Intent(Intent.ACTION_VIEW, uri14);
                        startActivity(dunyaJobIntent);
                        break;
                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }
        ));

        /*mViewPager = findViewById(R.id.tabs_pager);
        mTabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabsPagerAdapter);

        mTabLayout = findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);*/
        //setupTabIcons();

        /**
         * Set Home Activity Toolbar Name
         */
        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle("uMe");

        navigationView = findViewById(R.id.nav_view);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        getUserName = header.findViewById(R.id.UserNameView);
        getUserStatus = header.findViewById(R.id.UserStatusView);
        NavProfileView = header.findViewById(R.id.nav_profile);

        userDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    if (dataSnapshot.hasChild("user_name"))
                    {
                        String userName = dataSnapshot.child("user_name").getValue().toString();
                        getUserName.setText(userName);
                    }
                    if (dataSnapshot.hasChild("user_status"))
                    {
                        String userStatus = dataSnapshot.child("user_status").getValue().toString();
                        getUserStatus.setText(userStatus);
                    }
                    if (dataSnapshot.hasChild("user_image"))
                    {
                        String userProfileImage = dataSnapshot.child("user_image").getValue().toString();
                        Picasso.get().load(userProfileImage).into(NavProfileView);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Profile is not Exists...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                UserMenuSelector(menuItem);
                return false;
            }
        });


    }
    // ending onCreate

    private void setupTabIcons() {
        //mTabLayout.getTabAt(0).setText("CHATS");
        //mTabLayout.getTabAt(1).setText("REQUESTS");
        //mTabLayout.getTabAt(2).setText("FRIENDS");
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = mAuth.getCurrentUser();
        //checking logging, if not login redirect to Login ACTIVITY
        if (currentUser == null){
            logOutUser(); // Return to Login activity
        }
        if (currentUser != null){
            userDatabaseReference.child("active_now").setValue("true");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Register Connectivity Broadcast receiver
        connectivityReceiver = new ConnectivityReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Unregister Connectivity Broadcast receiver
        unregisterReceiver(connectivityReceiver);

        // google kore aro jana lagbe, bug aache ekhane
        if (currentUser != null){
            userDatabaseReference.child("active_now").setValue(ServerValue.TIMESTAMP);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // from onStop
        if (currentUser != null){
            userDatabaseReference.child("active_now").setValue(ServerValue.TIMESTAMP);
        }
    }

    private void logOutUser() {
        Intent loginIntent =  new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

    // tool bar action menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.notifications){
            Intent intent =  new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_search){
            Intent intent =  new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.profile_settings){
            Intent intent =  new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.all_friends){
            Intent intent =  new Intent(MainActivity.this, FriendsActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.all_public_posts){
            Intent intent =  new Intent(MainActivity.this, PostShownActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.about_app){
            Intent intent =  new Intent(MainActivity.this, AppInfoActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.main_logout){
            // Custom Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.logout_dailog, null);

            ImageButton imageButton = view.findViewById(R.id.logoutImg);
            imageButton.setImageResource(R.drawable.logout);
            builder.setCancelable(true);

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.setPositiveButton("YES, Log out", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (currentUser != null){
                        userDatabaseReference.child("active_now").setValue(ServerValue.TIMESTAMP);
                    }
                    mAuth.signOut();
                    logOutUser();
                }
            });
            builder.setView(view);
            builder.show();
        }
        return true;
    }

    private void UserMenuSelector(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.home:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.user_import:
                Intent findIntent = new Intent(MainActivity.this, BlogPostActivity.class);
                startActivity(findIntent);
                break;
            case R.id.user_govt_sector:
                Intent govtJobsIntent = new Intent(MainActivity.this, GovtSectorActivity.class);
                startActivity(govtJobsIntent);
                break;
            case R.id.user_pvt_sector:
                Intent pvtJobsIntent = new Intent(MainActivity.this, PrivateSectorActivity.class);
                startActivity(pvtJobsIntent);
                break;
            case R.id.settings:
                Intent settingsIntent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(settingsIntent);
                break;
            case R.id.feedback:
                Intent feedbackIntent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(feedbackIntent);
                break;
            case R.id.security:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
                builder.setTitle("Security threat & Policies :");
                builder.setMessage("From day one, I'm built Career Adviser© to help you stay in touch with career and friends. Share vital information during new opportunities and seek a better life. Some of your most personal moments are shared with this plate-form. Chat with friends and share your thoughts with messages like photos, videos or other data as well.");

                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Intent forwardMainIntent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                        startActivity(forwardMainIntent);
                    }
                });
                builder.setNegativeButton("Learn More", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Intent backMainIntent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(backMainIntent);
                    }
                });

                /*AlertDialog dialog = builder.create();
                dialog.show();

                Button b = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                if (b != null)
                {
                    b.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_background));
                }*/

                builder.show();
                break;
            case R.id.share_with:
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.fiverr.com/techroof?up_rollout=true");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Share via : "));
                break;
            case R.id.help:
                Intent helpIntent = new Intent(MainActivity.this, HelpingActivity.class);
                startActivity(helpIntent);
                break;
        }
    }

    /*private void showYourInterest() {
        CharSequence[] options = new CharSequence[]
                {
                        "POST BLOG",
                };
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Create Public Post");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                if (i == 0)
                {
                    Intent findIntent = new Intent(MainActivity.this, BlogPostActivity.class);
                    startActivity(findIntent);
                }
                if (i == 1)
                {
                    Intent returnIntent = new Intent(MainActivity.this, AdminWatchPostActivity.class);
                    startActivity(returnIntent);
                }
                if (i == 2)
                {
                    Intent returnIntent = new Intent(MainActivity.this, AdminWatchPostActivity.class);
                    startActivity(returnIntent);
                }
            }
        });
        builder.show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {
    }

    // Broadcast receiver for network checking
    public class ConnectivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){

            } else {
                Snackbar snackbar = Snackbar
                        .make(mViewPager, "No internet connection! ", Snackbar.LENGTH_LONG)
                        .setAction("Go settings", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                startActivity(intent);
                            }
                        });
                // Changing action button text color
                snackbar.setActionTextColor(Color.BLACK);
                // Changing message text color
                View view = snackbar.getView();
                view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                TextView textView = view.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();
            }
        }
    }



    // This method is used to detect back button
    @Override
    public void onBackPressed() {
        if(TIME_LIMIT + backPressed > System.currentTimeMillis()){
            super.onBackPressed();
            //Toast.makeText(getApplicationContext(), "Exited", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    } //End Back button press for exit...
}