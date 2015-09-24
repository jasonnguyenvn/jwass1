/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.assignment1.common;

import com.assignment1.account.AccountDAO;
import com.assignment1.account.AccountDTO;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hau
 */
public class CheckLoginObj {
    public boolean checkLogin(HttpServletRequest request)
            throws ClassNotFoundException, SQLException {
        HttpSession session = request.getSession(false);
            
            String url = "Controller?btAction=LoginPage";
            if(session == null) {
                return false;
            }
            

            AccountDTO loginUser = (AccountDTO) session.getAttribute("LOGGINUSR");

            if(loginUser==null) {
                return false;
            }

            AccountDAO dao = new AccountDAO();
            

            return dao.checkLogin(loginUser.getAccountID(),
                                             loginUser.getPassword()) != null;
    }
}
