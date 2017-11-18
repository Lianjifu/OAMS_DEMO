package cn.qilu.oa.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.qilu.oa.base.ModelDrivenBaseAction;
import cn.qilu.oa.domain.ApplicationTemplate;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ApplicationTemplateAction extends ModelDrivenBaseAction<ApplicationTemplate> {

	private File upload; // 上传的文件
	private InputStream inputStream; // 下载用的

	/** 列表 */
	public String list() throws Exception {
		List<ApplicationTemplate> applicationTemplateList = applicationTemplateService.findAll();
		ActionContext.getContext().put("applicationTemplateList", applicationTemplateList);
		return "list";
	}

	/** 删除，应也同时删除文件 */
	public String delete() throws Exception {
		applicationTemplateService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据
		List<ProcessDefinition> processDefinitionList = processDefinitionService.findAllLatestVersions();
		ActionContext.getContext().put("processDefinitionList", processDefinitionList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装
		String path = saveUploadFile(upload);
		model.setPath(path);

		// 保存
		applicationTemplateService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备数据
		List<ProcessDefinition> processDefinitionList = processDefinitionService.findAllLatestVersions();
		ActionContext.getContext().put("processDefinitionList", processDefinitionList);

		// 准备回显的数据
		ApplicationTemplate applicationTemplate = applicationTemplateService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(applicationTemplate);

		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从DB中取出原对象
		ApplicationTemplate applicationTemplate = applicationTemplateService.getById(model.getId());

		// 2，设置要修改的属性
		applicationTemplate.setName(model.getName());
		applicationTemplate.setProcessDefinitionKey(model.getProcessDefinitionKey());
		if (upload != null) { // 如果上传了文件
			// 删除老文件
			File file = new File(applicationTemplate.getPath());
			if (file.exists()) {
				file.delete();
			}

			// 使用新文件
			String path = saveUploadFile(upload);
			applicationTemplate.setPath(path);
		}

		// 3，更新到DB
		applicationTemplateService.update(applicationTemplate);

		return "toList";
	}

	/** 下载 */
	public String download() throws Exception {
		// 准备下载的资源
		ApplicationTemplate applicationTemplate = applicationTemplateService.getById(model.getId());
		inputStream = new FileInputStream(applicationTemplate.getPath());

		// 准备文件名（解决乱码问题）
		String fileName = URLEncoder.encode(applicationTemplate.getName(), "utf-8"); // 方法一
		// String fileName = new String(applicationTemplate.getName().getBytes("gbk"), "iso8859-1"); // 方法二
		ActionContext.getContext().put("fileName", fileName);

		return "download";
	}

	// ---

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

}
