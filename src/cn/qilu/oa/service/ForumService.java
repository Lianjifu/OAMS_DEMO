package cn.qilu.oa.service;

import cn.qilu.oa.base.BaseDao;
import cn.qilu.oa.domain.Forum;

public interface ForumService extends BaseDao<Forum> {

	/**
	 * 上移，最上面的不能上移
	 * @param id
	 */
	void moveUp(Long id);

	/**
	 * 下移，最下面的不能下移
	 * @param id
	 */
	void moveDown(Long id);

}
