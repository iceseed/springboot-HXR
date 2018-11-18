package com.hxe.core.user.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxe.common.service.impl.BaseServiceImpl;
import com.hxe.core.user.mapper.TokenMapper;
import com.hxe.core.user.domain.TokenDomain;
import com.hxe.core.user.service.ITokenService;

/**
 * �û�Token��ҵ��ʵ����
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("tokenService")
public class TokenServiceImpl extends BaseServiceImpl<TokenDomain> implements ITokenService {
	
	@Autowired
	private TokenMapper tokenMapper;
	
	
	/**
	 * 12小时后过期
	 */
	private final static int EXPIRE = 3600 * 12;

	@Override
	public TokenDomain queryByToken(String token) {
		
		return null;
	}

	@Override
	public TokenDomain createToken(long userId) {
		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//生成token
		String token = generateToken();

		//保存或更新用户token
		TokenDomain TokenDomain = new TokenDomain();
		TokenDomain.setId(userId);
		TokenDomain.setToken(token);
		TokenDomain.setUpdateTime(now);
		TokenDomain.setExpireTime(expireTime);
		//this.insertOrUpdate(TokenDomain);

		return TokenDomain;
	}

	@Override
	public void expireToken(long userId){
		Date now = new Date();

		TokenDomain TokenDomain = new TokenDomain();
		TokenDomain.setId(userId);
		TokenDomain.setUpdateTime(now);
		TokenDomain.setExpireTime(now);
		//this.insertOrUpdate(TokenDomain);
	}

	private String generateToken(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	  
}
