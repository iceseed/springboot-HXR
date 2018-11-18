package com.hxe.core.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxe.common.exception.RRException;
import com.hxe.common.service.impl.BaseServiceImpl;
import com.hxe.core.user.mapper.UserMapper;
import com.hxe.core.user.domain.TokenDomain;
import com.hxe.core.user.domain.UserDomain;
import com.hxe.core.user.form.LoginForm;
import com.hxe.core.user.service.ITokenService;
import com.hxe.core.user.service.IUserService;

import tk.mybatis.mapper.util.Assert;

/**
 * �û���ҵ��ʵ����
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserDomain> implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ITokenService tokenService;

	@Override
	public UserDomain queryByMobile(String mobile) {
		UserDomain UserDomain = new UserDomain();
		UserDomain.setMobile(mobile);
		return null;
	}

	@Override
	public Map<String, Object> login(LoginForm form) {
		UserDomain user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		//获取登录token
		TokenDomain TokenDomain = tokenService.createToken(user.getId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", TokenDomain.getToken());
		map.put("expire", TokenDomain.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}
	  
}
