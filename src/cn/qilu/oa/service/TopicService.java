package cn.qilu.oa.service;

import java.util.List;

import cn.qilu.oa.base.BaseDao;
import cn.qilu.oa.domain.Forum;
import cn.qilu.oa.domain.PageBean;
import cn.qilu.oa.domain.Topic;

public interface TopicService extends BaseDao<Topic> {

	/**
	 * 查询指定版块中的主题列表，排序：所有置顶帖都在最上面，然后把最新状态的主题显示到前面。
	 * 
	 * @param forum
	 * @return
	 */
	@Deprecated
	List<Topic> findByForum(Forum forum);

	/**
	 * 获取分页信息
	 * 
	 * @param pageNum
	 * @param forum
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, Forum forum);

}