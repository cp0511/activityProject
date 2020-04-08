package cn.lastwhisper.modular.pojo.activityPojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:workflow_leave表的实体类
 * @version
 * @author:  Killer
 * @创建时间: 2020-04-05
 */
public class WorkflowLeave implements Serializable {
    /**
     * 主键id
     */
    private String leaveId;

    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 请假状态0：未完成 1：已完成
     */
    private Integer leaveStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 请假类型
     */
    private String leaveType;

    /**
     * 请假原因
     */
    private String leaveReason;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 
     */
    private Date realityStartTime;

    /**
     * 
     */
    private Date realityEndTime;

    /**
     * 主键id
     * @return leave_id 主键id
     */
    public String getLeaveId() {
        return leaveId;
    }

    /**
     * 主键id
     * @param leaveId 主键id
     */
    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId == null ? null : leaveId.trim();
    }

    /**
     * 流程实例id
     * @return process_instance_id 流程实例id
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * 流程实例id
     * @param processInstanceId 流程实例id
     */
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 请假状态0：未完成 1：已完成
     * @return leave_status 请假状态0：未完成 1：已完成
     */
    public Integer getLeaveStatus() {
        return leaveStatus;
    }

    /**
     * 请假状态0：未完成 1：已完成
     * @param leaveStatus 请假状态0：未完成 1：已完成
     */
    public void setLeaveStatus(Integer leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 请假类型
     * @return leave_type 请假类型
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 请假类型
     * @param leaveType 请假类型
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    /**
     * 请假原因
     * @return leave_reason 请假原因
     */
    public String getLeaveReason() {
        return leaveReason;
    }

    /**
     * 请假原因
     * @param leaveReason 请假原因
     */
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }

    /**
     * 申请时间
     * @return apply_time 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 申请时间
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 
     * @return reality_start_time 
     */
    public Date getRealityStartTime() {
        return realityStartTime;
    }

    /**
     * 
     * @param realityStartTime 
     */
    public void setRealityStartTime(Date realityStartTime) {
        this.realityStartTime = realityStartTime;
    }

    /**
     * 
     * @return reality_end_time 
     */
    public Date getRealityEndTime() {
        return realityEndTime;
    }

    /**
     * 
     * @param realityEndTime 
     */
    public void setRealityEndTime(Date realityEndTime) {
        this.realityEndTime = realityEndTime;
    }
}