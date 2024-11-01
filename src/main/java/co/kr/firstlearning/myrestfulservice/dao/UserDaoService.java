package co.kr.firstlearning.myrestfulservice.dao;

import co.kr.firstlearning.myrestfulservice.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1,"sula",new Date()));
        users.add(new User(2,"jahuen",new Date()));
        users.add(new User(3,"yumm",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        //id값 자동으로 설정
        if(user.getId() == null){
            user.setId(++userCount);
        }

        if(user.getJoinDate() == null){
            user.setJoinDate(new Date());
        }

        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
