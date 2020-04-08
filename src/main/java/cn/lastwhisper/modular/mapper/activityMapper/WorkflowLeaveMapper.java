package cn.lastwhisper.modular.mapper.activityMapper;


import cn.lastwhisper.modular.pojo.activityPojo.WorkflowLeave;

public interface WorkflowLeaveMapper {
    int deleteByPrimaryKey(String leaveId);

    int insert(WorkflowLeave record);

    int insertSelective(WorkflowLeave record);

    WorkflowLeave selectByPrimaryKey(String leaveId);

    int updateByPrimaryKeySelective(WorkflowLeave record);

    int updateByPrimaryKey(WorkflowLeave record);
}