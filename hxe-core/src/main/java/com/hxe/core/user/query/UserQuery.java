package com.hxe.core.user.query;

import tk.mybatis.mapper.entity.Example;
import lombok.Data;
import java.util.Date;
import com.hxe.core.user.domain.UserDomain;
import com.hxe.common.persistence.Query;
import com.hxe.common.persistence.criteria.QueryCriteria;


/**
 * �û���Query
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@Data
public class UserQuery extends Query {

	/**/
	private Long id;

	/*�û���*/
	private String username;

	/*�ֻ���*/
	private String mobile;

	/*����*/
	private String password;

	/*����ʱ��*/
	private Date createTime;



	@Override
	public QueryCriteria toCriteria() {
		QueryCriteria queryCriteria = new QueryCriteria(UserDomain.class);
		Example.Criteria criteria = queryCriteria.createCriteria();
		if (valid(id)) {
            criteria.andEqualTo("id", id);
        }

		if (valid(username)) {
            criteria.andEqualTo("username", username);
        }

		if (valid(mobile)) {
            criteria.andEqualTo("mobile", mobile);
        }

		if (valid(password)) {
            criteria.andEqualTo("password", password);
        }

		if (valid(createTime)) {
            criteria.andEqualTo("createTime", createTime);
        }

		//todo д��ѯ�߼�
		
		return queryCriteria;
	}

}
