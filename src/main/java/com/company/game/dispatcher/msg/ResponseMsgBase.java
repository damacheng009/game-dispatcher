package com.company.game.dispatcher.msg;

/**
 * 响应消息基类
 * 
 * @author xingchencheng
 *
 */

public class ResponseMsgBase extends AbstractMsg {
	
	protected boolean isSuccess;
	
	// 返回值列表，可能返回多个值
	protected Object[] resultArray;
	
	public ResponseMsgBase() {
	}
	
	public ResponseMsgBase(short type) {
		super(type);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("result: ");
		for (Object object : resultArray) {
			sb.append(object.toString() + " ");
		}
		return sb.toString();
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object[] getResultArray() {
		return resultArray;
	}

	public void setResultArray(Object[] resultArray) {
		this.resultArray = resultArray;
	}
	
}