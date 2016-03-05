package ua.naiksoftware.hidetabs;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by naik on 05.03.16.
 */
public class FabSlidingBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    public FabSlidingBehavior(Context context, AttributeSet attributeSet) {}

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        int distanceToScroll = fab.getHeight() + fabBottomMargin;
        float ratio = dependency.getY()/fab.getHeight();
        fab.setTranslationY(-distanceToScroll * ratio);
        return true;
    }
}
