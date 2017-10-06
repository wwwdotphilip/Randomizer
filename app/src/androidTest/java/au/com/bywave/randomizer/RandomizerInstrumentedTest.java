package au.com.bywave.randomizer;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class RandomizerInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainTest() {
//        onView(withId(R.id.tvResult)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.tvResult)).check(matches(isDisplayed())).perform(longClick());
        onView(withText("Cancel")).check(matches(isDisplayed())).perform(pressBack());
    }
}
