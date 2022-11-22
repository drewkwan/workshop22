package vttp.day22.day22.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.day22.day22.models.Task;
import vttp.day22.day22.models.User;

import static vttp.day22.day22.repositories.Queries.*;

@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createUser(User user) throws Exception {

        return jdbcTemplate.update(SQL_INSERT_USER, 
                            user.getUsername(),
                            user.getPassword(),
                            user.getEmail(),
                            user.getPhone(),
                            user.getDob());

    }

    public Integer verifyUser(String username, String password) throws Exception {

        //Perform Query
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_VERIFY_USER, username, password);

        int verifyCount = 0;

        while (rs.next()) {
            verifyCount = rs.getInt("valid_count");
        }

       return verifyCount;
    }

    public Integer createTask(User user, Task task) {

        return jdbcTemplate.update(SQL_INSERT_TASK,
                                    task.getTaskName(),
                                    task.getPriority(),
                                    user.getUsername(),
                                    task.getCompletionDate());

    }
        
    
}
