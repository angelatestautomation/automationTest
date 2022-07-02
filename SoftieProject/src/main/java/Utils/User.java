package Utils;

public class User {
    public String userName;
    public String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public static User SoftieUser = new User("softieuser", "softiepassword");
    public static User WrongUser = new User("wronguser", "wrongpassword");
    public static User EmptyLoginUser = new User(null, "softiepassword");
    public static User EmptyPasswordUser = new User("softieuser", null);

}
