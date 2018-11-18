package com.hxe.core.user.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


/**
 * �û�Token��domain
 * @author : luxor
 * @since : 2018��11��19��
 * @version : v0.0.1
 */
@Data
@NoArgsConstructor
@Table(name = "tb_token")
public class TokenDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**/
	@Id
	private Long id;
	
	/*token*/
	private String token;
	
	/*����ʱ��*/
	private Date expireTime;
	
	/*����ʱ��*/
	private Date updateTime;
	

}
