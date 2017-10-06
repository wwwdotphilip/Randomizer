package au.com.bywave.randomizer;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ImageActivityTest {
    @Rule
    public ActivityTestRule<ImageActivity> imageActivityActivityTestRule = new ActivityTestRule<>(ImageActivity.class);

    @Test
    public void testImage(){
        onView(withId(R.id.ivPhoto)).check(matches(isDisplayed()));
    }
}
