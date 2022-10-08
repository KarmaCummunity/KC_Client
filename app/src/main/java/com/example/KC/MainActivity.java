package com.example.KC;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.KC.ui.bottom.home.HomeFragment;
import com.example.KC.ui.bottom.news.NewsFragment;
import com.example.KC.ui.bottom.profile.ProfileFragment;
import com.example.KC.ui.bottom.search.SearchFragment;
import com.example.KC.ui.option.chat.ChatFragment;
import com.example.KC.ui.option.mode.ModeFragment;
import com.example.KC.ui.option.notifications.NotificationsFragment;
import com.example.KC.ui.option.settings.SettingsFragment;
import com.example.KC.ui.side.area.AreaFragment;
import com.example.KC.ui.side.clothes.ClothesFragment;
import com.example.KC.ui.side.family.FamilyFragment;
import com.example.KC.ui.side.food.FoodFragment;
import com.example.KC.ui.side.games.GamesFragment;
import com.example.KC.ui.side.hobbies.HobbiesFragment;
import com.example.KC.ui.side.hosting.HostingFragment;
import com.example.KC.ui.side.knowledge.KnowledgeFragment;
import com.example.KC.ui.side.medical.MedicalFragment;
import com.example.KC.ui.side.money.MoneyFragment;
import com.example.KC.ui.side.music.MusicFragment;
import com.example.KC.ui.side.stuff.StuffFragment;
import com.example.KC.ui.side.time.TimeFragment;
import com.example.KC.ui.side.transportation.TransportationFragment;
import com.example.KC.ui.side.trash.TrashFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private NewsFragment newsFragment = new NewsFragment();
    private ProfileFragment profileFragment = new ProfileFragment();
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawer;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = null;
                Class fragmentClass;
                switch (item.getItemId()) {
                    case R.id.settings:
                        fragmentClass = SettingsFragment.class;
                        getSupportActionBar().setTitle(item.getTitle());
                        break;
                    case R.id.chat:
                        fragmentClass = ChatFragment.class;
                        getSupportActionBar().setTitle(item.getTitle());
                        break;
                    case R.id.notification:
                        fragmentClass = NotificationsFragment.class;
                        getSupportActionBar().setTitle(item.getTitle());
                        break;

                    case R.id.mode:
                        fragmentClass = ModeFragment.class;
                        getSupportActionBar().setTitle(item.getTitle());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

                // Highlight the selected item has been done by NavigationView
                item.setChecked(true);
                // Set action bar title
                setTitle(item.getTitle());
                return true;
            }
        });
        drawer = findViewById(R.id.drawer_layout);

        toolbar.setOverflowIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_baseline_person_pin_24));

        NavigationView navigationView = findViewById(R.id.nav_view_side);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_money, R.id.nav_time, R.id.nav_food, R.id.nav_food, R.id.nav_clothes, R.id.nav_hosting, R.id.knowledge, R.id.nav_transportation, R.id.nav_family, R.id.nav_area, R.id.nav_medical, R.id.nav_hobbies, R.id.nav_music, R.id.nav_games, R.id.nav_trash)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home,new HomeFragment());
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navigationView,toolbar,"open","close")
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view_bottom);


        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setReorderingAllowed(true);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.nav_host_fragment, HomeFragment.class, null);
                    getSupportActionBar().setTitle(item.getTitle());
                    transaction.commit();
                    break;
                case R.id.navigation_search:
                    transaction.replace(R.id.nav_host_fragment, SearchFragment.class, null);
                    getSupportActionBar().setTitle(item.getTitle());
                    transaction.commit();
                    break;
                case R.id.navigation_news:
                    transaction.replace(R.id.nav_host_fragment, NewsFragment.class, null);
                    getSupportActionBar().setTitle(item.getTitle());
                    transaction.commit();
                    break;

                case R.id.navigation_profile:
                    transaction.replace(R.id.nav_host_fragment, ProfileFragment.class, null);
                    getSupportActionBar().setTitle(item.getTitle());
                    transaction.commit();
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.config, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.money:
                fragmentClass = MoneyFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.time:
                fragmentClass = TimeFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.food:
                fragmentClass = FoodFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.clothes:
                fragmentClass = ClothesFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.stuff:
                fragmentClass = StuffFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.hosting:
                fragmentClass = HostingFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.knowledge:
                fragmentClass = KnowledgeFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.transportation:
                fragmentClass = TransportationFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.family:
                fragmentClass = FamilyFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.area:
                fragmentClass = AreaFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.medicine:
                fragmentClass = MedicalFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.hobbies:
                fragmentClass = HobbiesFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.music:
                fragmentClass = MusicFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.games:
                fragmentClass = GamesFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            case R.id.trash:
                fragmentClass = TrashFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
                break;
            default:
                fragmentClass = HomeFragment.class;
                getSupportActionBar().setTitle(menuItem.getTitle());
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }
}