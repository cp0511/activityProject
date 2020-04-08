package cn.lastwhisper.modular.service.activityService;

import cn.lastwhisper.modular.pojo.User;
import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 程程有小棉被啊 on 2020年04月04日.
 */
@Service
public class ActUserService {
    @Autowired
    private IdentityService identityService;

    /**
     * 保存用户到activity表中
     * @param user
     * @return
     */
    public boolean insertUser(User user){
        String user_id = user.getUser_id();
        org.activiti.engine.identity.User actUser = identityService.newUser(String.valueOf(user_id));
        String firstName = user.getUser_name().substring(0, 1);
        String lastName = user.getUser_name().substring(1,user.getUser_name().length());
        actUser.setFirstName(firstName);
        actUser.setLastName(lastName);
        identityService.saveUser(actUser);
        System.out.println("工作流用户添加完成");
        return true;
    }





}
