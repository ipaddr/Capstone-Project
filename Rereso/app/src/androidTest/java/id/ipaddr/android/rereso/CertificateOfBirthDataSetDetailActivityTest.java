package id.ipaddr.android.rereso;

import android.support.design.widget.TextInputLayout;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.presentation.view.activity.CertificateOfBirthDataSetDetailActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by iip on 6/27/17.
 */

@RunWith(AndroidJUnit4.class)
public class CertificateOfBirthDataSetDetailActivityTest {

    @Rule
    public ActivityTestRule<CertificateOfBirthDataSetDetailActivity> mActivityTestRule
            = new ActivityTestRule<>(CertificateOfBirthDataSetDetailActivity.class);

    public static Matcher<View> hasTextInputLayoutHintText(final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, TextInputLayout>(TextInputLayout.class) {

            @Override
            public void describeTo(org.hamcrest.Description description) {

            }

            @Override
            public boolean matchesSafely(TextInputLayout view) {
                if (!(view instanceof TextInputLayout)) {
                    return false;
                }

                CharSequence error = view.getHint();

                if (error == null) {
                    return false;
                }

                String hint = error.toString();

                return stringMatcher.matches(hint);
            }

        };
    }

    public static Matcher<View> hasAppCompatEditText(final Matcher<String> stringMatcher) {
        return new BoundedMatcher<View, AppCompatEditText>(AppCompatEditText.class) {

            @Override
            public void describeTo(org.hamcrest.Description description) {

            }

            @Override
            public boolean matchesSafely(AppCompatEditText view) {
                if (!(view instanceof AppCompatEditText)) {
                    return false;
                }

                CharSequence error = view.getHint();

                if (error == null) {
                    return false;
                }

                String hint = error.toString();

                return stringMatcher.matches(hint);
            }

        };
    }

    @Before
    public void init(){

    }

    @Test
    public void test(){
        addPatriarchData();
        clickNext();
        addBabyData();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addBabyData() {
        Espresso.onView(ViewMatchers.withText("Baby data")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withParent( ViewMatchers.withParent(Matchers.allOf(ViewMatchers.withId(R.id.til_name)
                , hasTextInputLayoutHintText(Matchers.containsString("Baby Full Name"))))
                ))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(scrollTo(), ViewActions.click())
                .perform(scrollTo(), ViewActions.typeText("Meca Alesha Ipfia"))
        ;

        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_sex), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_sex_rb_female), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), ViewActions.click());

        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_place), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_place_rs), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), ViewActions.click());

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_born_location), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("jakarta"));

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_born_day), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("senin"));

        Espresso.onView(ViewMatchers.withParent( ViewMatchers.withParent(Matchers.allOf(ViewMatchers.withId(R.id.til_born_date)
                , hasTextInputLayoutHintText(Matchers.containsString("Baby Born Date"))))
        ))
//                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(scrollTo(), ViewActions.click())
                .perform(scrollTo(), ViewActions.typeText("28/12/1985"))
        ;

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_born_time), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("13:36"));

//        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_type), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
//                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_type_single), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), ViewActions.click());

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_born_seq), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("1"));

        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_helper), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(allOf(ViewMatchers.withId(R.id.rg_born_helper_docter), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), ViewActions.click());

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_baby_weight), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("3"));

        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_baby_height), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(scrollTo(), typeText("4"));
    }

    private void clickNext(){
        Espresso.onView(ViewMatchers.withText("NEXT")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withText("NEXT")).perform(ViewActions.click());
    }

    private void clickComplete(){
        Espresso.onView(ViewMatchers.withText("COMPLETE")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withText("COMPLETE")).perform(ViewActions.click());
    }

    private void addPatriarchData(){
        Espresso.onView(ViewMatchers.withText("Patriarch data")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_kk_name), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(ViewActions.typeText("Iip Permana"));
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.acet_kk_num), ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(ViewActions.typeText("123456789"));
    }

    @After
    public void clean(){

    }

}
