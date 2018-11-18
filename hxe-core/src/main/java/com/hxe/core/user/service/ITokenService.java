package com.hxe.core.user.service;

import com.hxe.common.service.IBaseService;
import com.hxe.core.user.domain.TokenDomain;

/**
 * �û�Token��ҵ���ӿ�
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
public interface ITokenService extends IBaseService<TokenDomain> {

	TokenDomain queryByToken(String token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token信息
	 */
	TokenDomain createToken(long userId);

	/**
	 * 设置token过期
	 * @param userId 用户ID
	 */
	void expireToken(long userId);
}
