package cn.qilu.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.qilu.oa.domain.Department;


public class DepartmentUtils {

	/**
	 * 遍历部门树，得到所有的部门列表，并修改了名称以表示层次。
	 * 
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartments(List<Department> topList) {
		List<Department> list = new ArrayList<Department>();
		walkDepartmentTrees(topList, "┣", list);
		return list;
	}

	/*
	 * 遍历部门树，把遍历出来的部门都放到指定的集合中
	 */
	private static void walkDepartmentTrees(Collection<Department> topList, String prefix, List<Department> list) {
		for (Department top : topList) {
			// 顶点
			Department copy = new Department(); // 原对象是在Session中的对象，是持久化状态，所以要使用副本。
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);
			// 子树
			walkDepartmentTrees(top.getChildren(), "　" + prefix, list); // 使用的是全角的空格
		}
	}

}