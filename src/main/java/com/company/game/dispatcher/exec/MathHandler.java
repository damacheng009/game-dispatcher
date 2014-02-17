package com.company.game.dispatcher.exec;

import com.company.game.dispatcher.annotation.UserHandlerAnnotation;
import com.company.game.dispatcher.msg.MsgType;

/**
 * 包含具体的业务逻辑方法
 * 用annotation修饰
 * 
 * @author xingchencheng
 *
 */

public class MathHandler {

	@UserHandlerAnnotation(msgType = MsgType.ADD)
	public double add(double left, double right){
		return left + right;
	}

	@UserHandlerAnnotation(msgType = MsgType.MULTI)
	public double multi(double left, double right){
		return left * right;
	}	
	
}
