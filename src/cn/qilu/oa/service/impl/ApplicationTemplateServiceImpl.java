package cn.qilu.oa.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import cn.qilu.oa.base.BaseDaoImpl;
import cn.qilu.oa.domain.ApplicationTemplate;
import cn.qilu.oa.service.ApplicationTemplateService;

@Service
public class ApplicationTemplateServiceImpl extends BaseDaoImpl<ApplicationTemplate> implements ApplicationTemplateService {

	@Override
	public void delete(Long id) {
		// 删除数据库记录
		ApplicationTemplate applicationTemplate = getById(id);
		getSession().delete(applicationTemplate);

		// 删除文件
		File file = new File(applicationTemplate.getPath());
		if (file.exists()) {
			file.delete();
		}
	}

}
