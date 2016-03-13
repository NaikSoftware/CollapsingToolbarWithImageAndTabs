package ua.naiksoftware.hidetabs.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

/**
 * Created by naik on 13.03.16.
 */
public class Converters {

    @BindingAdapter("letterDrawable")
    public static void setLetterDrawable(ImageView imageView, String letters) {
        String firstLetter = letters.substring(0, 1);
        imageView.setImageDrawable(TextDrawable.builder().buildRound(firstLetter,
                ColorGenerator.MATERIAL.getColor(firstLetter)).getCurrent());
    }
}
