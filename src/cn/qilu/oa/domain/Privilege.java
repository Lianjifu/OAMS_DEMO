package cn.qilu.oa.domain;


import java.util.HashSet;
import java.util.Set;

/**
 * 权限
 * 
 * @author Jifu_lian
 * 
 */
public class Privilege implements java.io.Serializable {
	private Long id;
	private String url;
	private String name;
	private String icon; // 图标，顶级菜单用的
	private Set<Role> roles = new HashSet<Role>();

	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();

	public Privilege() {
	}

	public Privilege(String name, String url, String icon, Privilege parent) {
		this.url = url;
		this.name = name;
		this.icon = icon;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
