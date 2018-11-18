package com.hxe.core.user.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


/**
 * �û���domain
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@Data
@NoArgsConstructor
@Table(name = "tb_user")
public class UserDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**/
	@Id
	private Long id;
	
	/*�û���*/
	private String username;
	
	/*�ֻ���*/
	private String mobile;
	
	/*����*/
	private String password;
	
	/*����ʱ��*/
	private Date createTime;
	

}
