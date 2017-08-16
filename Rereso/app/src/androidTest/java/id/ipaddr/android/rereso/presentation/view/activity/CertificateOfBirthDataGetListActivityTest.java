package id.ipaddr.android.rereso.presentation.view.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import id.ipaddr.android.rereso.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CertificateOfBirthDataGetListActivityTest {

    @Rule
    public ActivityTestRule<CertificateOfBirthDataGetListActivity> mActivityTestRule = new ActivityTestRule<>(CertificateOfBirthDataGetListActivity.class);

    @Test
    public void certificateOfBirthDataGetListActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                withId(R.id.acet_kk_name));
        appCompatEditText.perform(scrollTo(), replaceText("Iip Permana "), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.acet_kk_num));
        appCompatEditText2.perform(scrollTo(), replaceText("123456789"), closeSoftKeyboard());

        ViewInteraction rightNavigationButton = onView(
                allOf(withId(R.id.ms_stepNextButton), withText("NEXT"),
                        withParent(allOf(withId(R.id.ms_bottomNavigation),
                                withParent(withId(R.id.stepperLayout)))),
                        isDisplayed()));
        rightNavigationButton.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.acet_name));
        appCompatEditText3.perform(scrollTo(), click());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.acet_name));
        appCompatEditText4.perform(scrollTo(), replaceText("Meca Alesha Ipfia"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rg_sex_rb_female), withText("Female"),
                        withParent(allOf(withId(R.id.rg_sex),
                                withParent(withId(R.id.ll_sex))))));
        appCompatRadioButton.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.rg_born_place_rs), withText("Hospital"),
                        withParent(allOf(withId(R.id.rg_born_place),
                                withParent(withId(R.id.ll_born_place))))));
        appCompatRadioButton2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText5 = onView(
                withId(R.id.acet_born_location));
        appCompatEditText5.perform(scrollTo(), replaceText("Jakarta "), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                withId(R.id.acet_born_day));
        appCompatEditText6.perform(scrollTo(), replaceText("Senin"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                withId(R.id.acet_born_date));
        appCompatEditText7.perform(scrollTo(), replaceText("12/06/2016"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                withId(R.id.acet_born_time));
        appCompatEditText8.perform(scrollTo(), replaceText("13:36"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.rg_born_type_single), withText("Single"),
                        withParent(allOf(withId(R.id.rg_born_type),
                                withParent(withId(R.id.ll_born_type))))));
        appCompatRadioButton3.perform(scrollTo(), click());

        ViewInteraction appCompatEditText9 = onView(
                withId(R.id.acet_born_seq));
        appCompatEditText9.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton4 = onView(
                allOf(withId(R.id.rg_born_helper_docter), withText("Doctor"),
                        withParent(allOf(withId(R.id.rg_born_helper),
                                withParent(withId(R.id.ll_born_helper))))));
        appCompatRadioButton4.perform(scrollTo(), click());

        ViewInteraction appCompatEditText10 = onView(
                withId(R.id.acet_baby_weight));
        appCompatEditText10.perform(scrollTo(), replaceText("4"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                withId(R.id.acet_baby_height));
        appCompatEditText11.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        ViewInteraction rightNavigationButton2 = onView(
                allOf(withId(R.id.ms_stepNextButton), withText("NEXT"),
                        withParent(allOf(withId(R.id.ms_bottomNavigation),
                                withParent(withId(R.id.stepperLayout)))),
                        isDisplayed()));
        rightNavigationButton2.perform(click());

        ViewInteraction appCompatEditText12 = onView(
                withId(R.id.acet_nik));
        appCompatEditText12.perform(scrollTo(), replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                withId(R.id.acet_name));
        appCompatEditText13.perform(scrollTo(), replaceText("Iip Permana "), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                withId(R.id.acet_born_date));
        appCompatEditText14.perform(scrollTo(), replaceText("28/02/1985"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                withId(R.id.acet_age));
        appCompatEditText15.perform(scrollTo(), replaceText("32"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                withId(R.id.acet_job));
        appCompatEditText16.perform(scrollTo(), replaceText("swasta"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                withId(R.id.acet_address));
        appCompatEditText17.perform(scrollTo(), replaceText("latumenten no 33"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                withId(R.id.acet_village));
        appCompatEditText18.perform(scrollTo(), replaceText("jembatan besi"), closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                withId(R.id.acet_subdistrict));
        appCompatEditText19.perform(scrollTo(), replaceText("tambora"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                withId(R.id.acet_district));
        appCompatEditText20.perform(scrollTo(), replaceText("jakarta barat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                withId(R.id.acet_state));
        appCompatEditText21.perform(scrollTo(), replaceText("dki jakarta"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton22 = onView(
                allOf(withId(R.id.rg_nationality), withText("WNI"),
                        withParent(allOf(withId(R.id.rg_nationality),
                                withParent(withId(R.id.ll_nationality))))));
        appCompatRadioButton22.perform(scrollTo(), click());

        ViewInteraction appCompatEditText23 = onView(
                withId(R.id.acet_ethnic));
        appCompatEditText23.perform(scrollTo(), replaceText("minang kabau"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                withId(R.id.acet_married_date));
        appCompatEditText24.perform(scrollTo(), replaceText("02/05/2014"), closeSoftKeyboard());

        ViewInteraction rightNavigationButton3 = onView(
                allOf(withId(R.id.ms_stepNextButton), withText("NEXT"),
                        withParent(allOf(withId(R.id.ms_bottomNavigation),
                                withParent(withId(R.id.stepperLayout)))),
                        isDisplayed()));
        rightNavigationButton3.perform(click());


        try {
            Thread.sleep(3586850);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
