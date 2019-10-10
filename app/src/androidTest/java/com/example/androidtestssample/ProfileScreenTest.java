package com.example.androidtestssample;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.androidtestssample.profile.ProfileActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileScreenTest {

    @Rule
    public ActivityTestRule<ProfileActivity> activityTestRule =
            new ActivityTestRule<>(ProfileActivity.class);
    
    /**
     * Check whether all the view's are displayed in the screen to the user.
     */
    @Test
    public void checkForViews() {
        onView(withId(R.id.profile_imageView))
                .check(matches(isDisplayed()));
        onView(withId(R.id.profile_username))
                .check(matches(isDisplayed()));
        onView(withId(R.id.profile_name))
                .check(matches(isDisplayed()));
    }
}
