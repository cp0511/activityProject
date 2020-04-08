package cn.lastwhisper.modular.service.activityService;

import cn.lastwhisper.modular.pojo.Role;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 程程有小棉被啊 on 2020年04月04日.
 */
@Service
public class ActRoleService {

    @Autowired
    private IdentityService identityService;

    /**
     * 新增角色
     * @param role
     * @return
     */
    public boolean insertRole(Role role){
        Group group = identityService.newGroup(role.getUuid());
        group.setName(role.getName());
        group.setType("assignment");
        identityService.saveGroup(group);
        return true;
    }


}
