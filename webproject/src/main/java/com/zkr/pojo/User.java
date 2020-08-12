package com.zkr.pojo;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable{
	/**
	 * 项目名称：webproject
	 * 创建人：dcf
	 * 创建时间：2020年5月20日 下午1:55:11
	 * @version
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
	private Integer status;

}