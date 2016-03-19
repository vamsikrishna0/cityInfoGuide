package com.jet.cp.user;

import java.util.List;

import com.jet.cp.user.domain.User;

public interface UserService {

    public boolean insertUser(User user);

    public User getUser(String username);

    public boolean UpdateUser(String userName, String emailPref, String location);

    public List<String> getEmailsForDailyEmails();

    public List<String> getEmailsForWeeklyEmails();
}
