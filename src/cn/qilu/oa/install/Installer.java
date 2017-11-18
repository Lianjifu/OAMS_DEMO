package cn.qilu.oa.install;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.qilu.oa.domain.Privilege;
import cn.qilu.oa.domain.User;

@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// ===================================================
		// 一、超级管理员
		User user = new User();
		user.setName("超级管理员");
		user.setLoginName("admin");
		user.setPassword(DigestUtils.md5Hex("admin")); // 要使用MD5摘要
		session.save(user); // 保存

		// ===================================================
		// 二、权限数据
		Privilege menu, menu1, menu2, menu3, menu4, menu5;

		menu = new Privilege("系统管理", null, "FUNC20082.png", null);
		menu1 = new Privilege("岗位管理", "roleAction_list", null, menu);
		menu2 = new Privilege("部门管理", "departmentAction_list", null, menu);
		menu3 = new Privilege("用户管理", "userAction_list", null, menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);

		session.save(new Privilege("岗位列表", "roleAction_list", null, menu1));
		session.save(new Privilege("岗位删除", "roleAction_delete", null, menu1));
		session.save(new Privilege("岗位添加", "roleAction_add", null, menu1));
		session.save(new Privilege("岗位修改", "roleAction_edit", null, menu1));

		session.save(new Privilege("部门列表", "departmentAction_list", null, menu2));
		session.save(new Privilege("部门删除", "departmentAction_delete", null, menu2));
		session.save(new Privilege("部门添加", "departmentAction_add", null, menu2));
		session.save(new Privilege("部门修改", "departmentAction_edit", null, menu2));

		session.save(new Privilege("用户列表", "userAction_list", null, menu3));
		session.save(new Privilege("用户删除", "userAction_delete", null, menu3));
		session.save(new Privilege("用户添加", "userAction_add", null, menu3));
		session.save(new Privilege("用户修改", "userAction_edit", null, menu3));
		session.save(new Privilege("用户初始化密码", "userAction_initPassword", null, menu3));

		// -------------------------

		menu = new Privilege("网上交流", null, "FUNC20064.png", null);
		menu1 = new Privilege("论坛管理", "forumManageAction_list", null, menu);
		menu2 = new Privilege("论坛", "forumAction_list", null, menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);

		// -------------------------

		menu = new Privilege("审批流转", null, "FUNC20057.png", null);
		menu1 = new Privilege("审批流程管理", "processDefinitionAction_list", null, menu);
		menu2 = new Privilege("申请模板管理", "applicationTemplateAction_list", null, menu);
		menu3 = new Privilege("起草申请", "flowAction_applicationTemplateList", null, menu);
		menu4 = new Privilege("待我审批", "flowAction_myTaskList", null, menu);
		menu5 = new Privilege("我的申请查询", "flowAction_myApplicationList", null, menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
	}

	public static void main(String[] args) {
		System.out.println("正在执行安装...");

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();

		System.out.println("== 安装完毕 ==");
	}
}