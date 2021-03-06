package in.ac.kit.kit_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  closeFile();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"teamtechnu@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Greating For Android Application");
                i.putExtra(Intent.EXTRA_TEXT   , "Hello , Team Technu \n\n /*** Write your message here ***?  \n \n \n Thanks, \n /*** Write your Name ***/");

                java.io.File file = new java.io.File(Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        + "/location.txt");
                Uri uri = Uri.fromFile(file);
                if (uri != null) {
                    i.putExtra(Intent.EXTRA_STREAM, uri);
                }

                try {
                    startActivityForResult(Intent.createChooser(i, "Send mail..."), 200);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Develop by Rajneesh Shukla", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //this method is called when menu item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_alumini_login) {
            Intent intent = new Intent(this, Webview.class); //here WebView Is faculty login page name ( java class)
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_pcrc_login) {
            Intent intent = new Intent(this, PCRC_Login.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_faculty_login) {
            Intent intent = new Intent(this, FacultyLogin.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_student_login) {
            Intent intent = new Intent(this, StudentLogin.class);
            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_meat_developer) {
            Intent intent = new Intent(this, SplashDeveloper.class);
            startActivity(intent);
            return true;
        }

       return super.onOptionsItemSelected(item);
    }



    /**
     * Main Fragmnet menus OnClick messages
     */
    public void SdcOnClickHandler(View view){
        Toast.makeText(MainActivity.this, "Skill Develoment Cell", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,SDCActivity.class));
    }

    public void PayFeeOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Pay Fee Online", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,PayFee.class));
    }

    public void ScholarshipOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Scholarship", Toast.LENGTH_SHORT).show();
         startActivity(new Intent(this ,Scholarship.class));
    }

    public void AluminiOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Meat Alumini", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,Webview.class));
    }

    public void IEEEOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "IEEE", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,IEEE.class));
    }

    public void PatnerOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Training Partners", Toast.LENGTH_SHORT).show();
       startActivity(new Intent(this ,TrainingPatners.class));
    }

    public void TeachersOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Faculty", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,MeatFaulty.class));
    }

    public void RankOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "Rank", Toast.LENGTH_SHORT).show();
       startActivity(new Intent(this ,Rank.class));
    }

    public void NewsOnClickHandler(View view) {
        Toast.makeText(MainActivity.this, "KIT in news", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this ,News.class));
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "KIT";
                case 1:
                    return "ERP";
                case 2:
                    return "PCRC";
            }
            return null;
        }
    }
}
