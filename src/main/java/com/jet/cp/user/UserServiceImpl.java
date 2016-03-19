package com.jet.cp.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jet.cp.user.domain.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String INSERT_INTO_USER_SQL = "INSERT INTO users VALUES (?, ?, ?, ?)"; 
    private static final String GET_USER = "select username, email, location, email_pref from users where username = ?";
    private static final String UPDATE_USER = "update users set email_pref = ?, location = ? where username = ?";
    private static final String GET_DAILY_EMAILS = "select username, email, location, email_pref from users where email_pref = 'D'";
    private static final String GET_WEEKLY_EMAILS = "select email from users where email_pref = 'W'";

   @Override
   public boolean insertUser(User user) {
      Object[] params = new Object[] {user.getUserName(), user.getEmail(), user.getLocation(), user.getEmailPref()};
      int row_inserted = jdbcTemplate.update(INSERT_INTO_USER_SQL, params);
      if (row_inserted == 1) {
            return true;
      }
      return false;
   }

   @Override
   public User getUser(String username) {
      Object[] args = new Object[] {username};
      User user = (User)jdbcTemplate.queryForObject(GET_USER, args, new UserRowMapper());
      return user;
   }

   private class UserRowMapper implements RowMapper<User> {
   @Override
   public User mapRow(ResultSet rs, int arg1) throws SQLException { 
    User user = new User();
    user.setUserName(rs.getString("username"));
    user.setEmail(rs.getString("email"));
    user.setLocation(rs.getString("location"));
    user.setEmailPref(rs.getString("email_pref"));
    return user;
   }
   }

    @Override
     public boolean UpdateUser(String userName, String emailPref, String location) {
     Object[] args = new Object[] {emailPref, location, userName};
     int rows = jdbcTemplate.update(UPDATE_USER, args);
     if (rows == 1) {
       return true;
     }
     return false;
   }

   @Override
   public List<String> getEmailsForDailyEmails() {
      List<String> emailIds = jdbcTemplate.queryForList(GET_DAILY_EMAILS, String.class);
      return emailIds;
   }

   @Override
   public List<String> getEmailsForWeeklyEmails() {
      List<String> emailIds = jdbcTemplate.queryForList(GET_WEEKLY_EMAILS, String.class);
      return emailIds;
   }
}
