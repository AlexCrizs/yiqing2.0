package com.nunu.common.utils;

public class AjaxJson {
	private boolean success = true;// �Ƿ�ɹ�
	private String msg = "�����ɹ�";// ��ʾ��Ϣ
	private Object obj = null;// ������Ϣ

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
