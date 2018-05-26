package com.apm.quizback.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = 3353243336232282647L;

	private Integer code;

	private String msg;

	public ErrorDTO(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ErrorDTO() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
