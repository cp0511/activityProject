package cn.lastwhisper.modular.service.activityService;

import cn.lastwhisper.core.util.UserUtils;
import cn.lastwhisper.modular.mapper.activityMapper.WorkflowLeaveMapper;
import cn.lastwhisper.modular.pojo.User;
import cn.lastwhisper.modular.pojo.activityPojo.WorkflowLeave;
import cn.lastwhisper.modular.util.IDUtil;
import cn.lastwhisper.modular.vo.GlobalResult;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 请假service
 * Created by 程程有小棉被啊 on 2020年04月05日.
 */
@Service
public class LeaveService {

    private final String processDefinitionKey = "leave";
    @Autowired
    private WorkflowLeaveMapper workflowLeaveMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IdentityService identityService;

    @Transactional
    public GlobalResult startLeave(WorkflowLeave leave){
        User subjectUser = UserUtils.getSubjectUser();
        leave.setLeaveId(IDUtil.getUUID());
        String user_id = subjectUser.getUser_id();
        leave.setUserId(user_id);
        int i = workflowLeaveMapper.insertSelective(leave);
        if (i == 0) {
            System.out.println("请假数据添加失败");
            return new GlobalResult(400, "流程启动失败", null);
        }

        //设置启动人id
        identityService.setAuthenticatedUserId(user_id);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, leave.getLeaveId());
        String id = processInstance.getId();
        leave.setProcessInstanceId(id);
        i = workflowLeaveMapper.updateByPrimaryKeySelective(leave);
        if (i == 0) {
            System.out.println("请假数据更新失败");
            return new GlobalResult(400, "流程启动失败", null);
        }
        return new GlobalResult(200, "流程启动成功", null);

    }











}
