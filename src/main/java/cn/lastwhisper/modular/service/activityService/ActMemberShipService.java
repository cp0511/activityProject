package cn.lastwhisper.modular.service.activityService;

import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户与角色关联关系
 * Created by 程程有小棉被啊 on 2020年04月04日.
 */
@Service
public class ActMemberShipService {

    @Autowired
    private IdentityService identityService;

    /**
     * 建立用户与角色的关系
     * @param userId
     * @param roleId
     * @return
     */
    public boolean createMemberShip(String userId,String roleId){
        identityService.createMembership(userId, roleId);
        System.out.println("act用户与角色建立关系完成");
        return true;
    }



}
