package cn.lastwhisper.modular.controller.workflow;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Created by 程程有小棉被啊 on 2020年03月29日.
 */
@Controller
@RequestMapping("/bpmnDeploy")
public class BPMNDeployController {

    @Autowired
    RepositoryService repositoryService;

    /**
     * 跳转部署页面
     * @param request
     * @return
     */
    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String ctx = request.getContextPath();
        modelAndView.addObject("ctx",ctx);
        modelAndView.setViewName("workflow/deployBPMN");
        return modelAndView;
    }

    @PostMapping("/deploy")
    public String deploy(@RequestParam("file") MultipartFile file) throws IOException {
        //获取上传文件名
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);//获取文件后缀名
        DeploymentBuilder deployment = repositoryService.createDeployment();
        if (suffix.equals("zip") || suffix.equals("bar")){
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            deployment.addZipInputStream(zipInputStream);
        }else{
            deployment.addInputStream(fileName,inputStream);
        }
        deployment.deploy();
        return "";
    }


    /**
     * 跳转部署页面
     * @param request
     * @return
     */
    @RequestMapping("/initDeployeeList")
    public ModelAndView init2(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String ctx = request.getContextPath();
        modelAndView.addObject("ctx",ctx);
        modelAndView.setViewName("workflow/deployee_list");
        return modelAndView;
    }


    @GetMapping("/getDeployList")
    @ResponseBody
    public List<Map<String, Object>> getDeployList(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        List<Map<String, Object>> pd = new ArrayList<Map<String,Object>>();
        for(ProcessDefinition processDefinition:list) {
            Map<String, Object> values = new HashMap<String,Object>();
            values.put("id", processDefinition.getId());
            values.put("name", processDefinition.getName());
            values.put("key", processDefinition.getKey());
            values.put("version", processDefinition.getVersion());
            values.put("deploymentId", processDefinition.getDeploymentId());
            values.put("resourceName", processDefinition.getResourceName());
            values.put("diagramResourceName", processDefinition.getDiagramResourceName());
            pd.add(values);
        }
        return pd;

    }


}
