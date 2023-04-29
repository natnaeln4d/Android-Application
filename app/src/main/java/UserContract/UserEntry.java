package UserContract;

import android.provider.BaseColumns;

public final class UserEntry {
    public static final String COLUMN_ID ="id" ;
    public static final String COLUMN_NAME ="full_name" ;
    public static final String COLUMN_JOB = "job";
    public static final String COLUMN_ADDRESS ="address" ;
    public static final String COLUMN_PHOTO_URL = "photo_url";
    public static final String TABLE_NAME ="users" ;


    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private UserEntry() {}

    public static class userEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_JOB = "job";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_PHOTO_URL = "photo_url";
    }
}
