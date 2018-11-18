package com.hxe.core.user.query;

import tk.mybatis.mapper.entity.Example;
import lombok.Data;
import java.util.Date;
import com.hxe.core.user.domain.TokenDomain;
import com.hxe.common.persistence.Query;
import com.hxe.common.persistence.criteria.QueryCriteria;


/**
 * �û�Token��Query
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@Data
public class TokenQuery extends Query {

	/**/
	private Long id;

	/*token*/
	private String token;

	/*����ʱ��*/
	private Date expireTime;

	/*����ʱ��*/
	private Date updateTime;



	@Override
	public QueryCriteria toCriteria() {
		QueryCriteria queryCriteria = new QueryCriteria(TokenDomain.class);
		Example.Criteria criteria = queryCriteria.createCriteria();
		if (valid(id)) {
            criteria.andEqualTo("id", id);
        }

		if (valid(token)) {
            criteria.andEqualTo("token", token);
        }

		if (valid(expireTime)) {
            criteria.andEqualTo("expireTime", expireTime);
        }

		if (valid(updateTime)) {
            criteria.andEqualTo("updateTime", updateTime);
        }

		//todo д��ѯ�߼�
		
		return queryCriteria;
	}

}
