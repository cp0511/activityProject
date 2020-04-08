package cn.lastwhisper.modular.controller.workflow;

import cn.lastwhisper.modular.pojo.activityPojo.WorkflowLeave;
import cn.lastwhisper.modular.service.activityService.LeaveService;
import cn.lastwhisper.modular.vo.GlobalResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 程程有小棉被啊 on 2020年04月05日.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * 跳转请假初始化
     * @param request
     * @return
     */
    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String ctx = request.getContextPath();
        modelAndView.addObject("ctx",ctx);
        modelAndView.setViewName("workflow/leave");
        return modelAndView;
    }

    /**
     * 提交请假流程
     * @param formData
     * @return
     */
    @PostMapping("/submitApplication")
    @ResponseBody
    public GlobalResult submitApplication(@RequestParam("formData") String formData){
        JSONObject dataJsonObj = JSONObject.parseObject(formData);
        WorkflowLeave workflowLeave = JSONObject.toJavaObject(dataJsonObj, WorkflowLeave.class);
        GlobalResult globalResult = leaveService.startLeave(workflowLeave);
        return globalResult;
    }











}
