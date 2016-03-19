package com.jet.cp.user;

import java.util.List;

import com.jet.cp.user.domain.User;

/**
 * Title: UserService.java<br>
 * Description: <br>
 * Created: 17-Mar-2016<br>
 * Copyright: Copyright (c) 2015<br>
 * @author Teja Sasank Gorthi (jet.sasank@gmail.com)
 */
public interface UserService {

    public boolean insertUser(User user);

    public User getUser(String username);

    public boolean UpdateUser(String userName, String emailPref, String location);

    public List<String> getEmailsForDailyEmails();

    public List<String> getEmailsForWeeklyEmails();
}
