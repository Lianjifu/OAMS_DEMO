package cn.qilu.oa.view.action;


import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.qilu.oa.base.ModelDrivenBaseAction;
import cn.qilu.oa.domain.Privilege;
import cn.qilu.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends ModelDrivenBaseAction<Role>{

	private Long[] privilegeIds;

	/** 列表 */
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 得到参数，封装成对象，当使用实体做为Model时，也可以直接使用model
		// Role role = new Role();
		// role.setName(name);
		// role.setDescription(description);
		// roleService.save(role);

		// 保存到数据库中
		roleService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		// this.name = role.getName();
		// this.description = role.getDescription();

		ActionContext.getContext().getValueStack().push(role); // 放到栈顶
		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 从数据库中取出原对象
		Role role = roleService.getById(model.getId());

		// 设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 更新到数据库中
		roleService.update(role);

		return "toList";
	}

	/** 设置权限页面 */
	public String setPrivilegeUI() throws Exception {
		// 准备数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().put("role", role);

		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);

		// 准备回显的数据
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege privilege : role.getPrivileges()) {
			privilegeIds[index++] = privilege.getId();
		}

		return "setPrivilegeUI";
	}

	/** 设置权限 */
	public String setPrivilege() throws Exception {
		// 从数据库中取出原对象
		Role role = roleService.getById(model.getId());

		// 设置要修改的属性
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));

		// 更新到数据库中
		roleService.update(role);

		return "toList";
	}

	// -------------------------------------

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
