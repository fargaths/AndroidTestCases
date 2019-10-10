package com.example.androidtestssample;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.androidtestssample.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeScreenTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityScenarioRule =
            new ActivityTestRule<HomeActivity>(HomeActivity.class);

    @Test
    public void contentCheck() {
        onView(withRecyclerView(R.id.home_list).atPosition(3))
                .check(matches(hasDescendant(withText("Nepal"))));
    }

    @Test
    public void itemClickTest() {
        onView(withId(R.id.home_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }

    public static RecyclerViewMatcher withRecyclerView(int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}
