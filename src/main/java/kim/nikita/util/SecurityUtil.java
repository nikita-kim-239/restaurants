package kim.nikita.util;

public class SecurityUtil {

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        SecurityUtil.userId = userId;
    }

    private static int userId=1;



}
