package ua.naiksoftware.hidetabs.model.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.naiksoftware.hidetabs.model.Friend;
import ua.naiksoftware.hidetabs.model.Model;

/**
 * Created by naik on 08.03.16.
 */
public class Utils {

    private static final SecureRandom RND = new SecureRandom();

    public static List<Friend> generateFriends(int count) {
        List<Friend> models = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            switch (RND.nextInt(10)) {
                default: models.add(generateFriend());
            }
        }
        return sort(models);
    }

    private static Friend generateFriend() {
        return new Friend(capitalize(randomString(6, 12), CapitalizeMode.FIRST_UPPER), "", System.nanoTime());
    }

    private static List<Friend> sort(List<Friend> friends) {
        Collections.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend lhs, Friend rhs) {
                return lhs.name.compareToIgnoreCase(rhs.name);
            }
        });
        return friends;
    }

    public static String randomString(int min, int max) {
        StringBuilder builder = new StringBuilder(max - min);
        for (int i = min; i <= max; i++) {
            builder.append((char) ('a' + RND.nextInt('z' - 'a' + 1)));
        }
        return builder.toString();
    }

    private static int randomInt(int min, int max) {
        return min + RND.nextInt(max);
    }

    public static String capitalize(String string, CapitalizeMode mode) {
        switch (mode) {
            case FIRST_UPPER: return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
        }
        return string;
    }

    public enum CapitalizeMode {
        FIRST_UPPER
    }

}
