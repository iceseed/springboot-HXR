package com.hxe.core.user.service;

import java.util.Map;

import com.hxe.common.service.IBaseService;
import com.hxe.core.user.domain.UserDomain;
import com.hxe.core.user.form.LoginForm;

/**
 * �û���ҵ���ӿ�
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
public interface IUserService extends IBaseService<UserDomain> {

	UserDomain queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginForm form);
}
