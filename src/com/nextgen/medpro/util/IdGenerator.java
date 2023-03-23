package com.nextgen.medpro.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenerator {
    public int generateId(){
        try {
            ResultSet rst = CrudUtil.execute(
                    "SELECT user_id FROM user ODER BY user_id DESC LIMIT 1"
            );
            if (rst.next()){
                return rst.getInt(1)+1;
            }


        }catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return 1;
    }
}
