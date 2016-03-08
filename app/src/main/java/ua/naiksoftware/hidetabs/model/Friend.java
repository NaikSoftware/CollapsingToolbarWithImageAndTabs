package ua.naiksoftware.hidetabs.model;

/**
 * Created by naik on 08.03.16.
 */
public class Friend implements Model {

    public final String name;
    public final String avatarPath;
    public final long id;

    public Friend(String name, String avatarPath, long id) {
        this.name = name;
        this.avatarPath = avatarPath;
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
