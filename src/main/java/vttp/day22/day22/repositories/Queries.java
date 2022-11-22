package vttp.day22.day22.repositories;

public class Queries {
    public static final String SQL_INSERT_USER= "insert into user(username, password, email, phone, dob) values(?, sha(?), ?, ?, ?)";
    public static final String SQL_VERIFY_USER= "select count(*) as valid_count from user where username= ? and password = sha(?)";
    public static final String SQL_INSERT_TASK = "insert into task(task_name, priority, assign_to, completion_date) values(?, ?, ?, ?)";
}
