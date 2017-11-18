package cn.qilu.oa.service;

import cn.qilu.oa.base.BaseDao;
import cn.qilu.oa.domain.User;

public interface UserService extends BaseDao<User> {

	/**
	 * 查询用户
	 * 
	 * @param loginName
	 * @param password
	 *            明文密码
	 * @return
	 */
	User getByLoginNameAndPassword(String loginName, String password);

}
