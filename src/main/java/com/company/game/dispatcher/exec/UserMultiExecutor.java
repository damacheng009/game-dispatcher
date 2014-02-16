package com.company.game.dispatcher.exec;

import com.company.game.dispatcher.annotation.UserMsgAndExecAnnotation;
import com.company.game.dispatcher.msg.MsgType;
import com.company.game.dispatcher.msg.UserMultiRequest;
import com.company.game.dispatcher.msg.UserMultiResponse;

/**
 * 具体的业务逻辑
 * 实现乘法
 * 
 * @author xingchencheng
 *
 */

@UserMsgAndExecAnnotation(msgType = MsgType.MULTI)
public class UserMultiExecutor extends BusinessLogicExecutorBase {
	public void run() {
		UserMultiResponse response = new UserMultiResponse();
		
		if (this.msgObject instanceof UserMultiRequest) {
			UserMultiRequest request = (UserMultiRequest) this.msgObject;
			double result = request.getLeftNumber() * request.getRightNumber();
			response.setResult(result);
			response.setSuccess(true);
		} else {
			response.setSuccess(false);
		}
		
		System.out.println("服务端处理结果：" + response.getResult());
		channel.writeAndFlush(response);
	}
}
