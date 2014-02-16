package com.company.game.dispatcher.exec;

import com.company.game.dispatcher.annotation.UserMsgAndExecAnnotation;
import com.company.game.dispatcher.msg.MsgType;
import com.company.game.dispatcher.msg.UserAddRequest;
import com.company.game.dispatcher.msg.UserAddResponse;

/**
 * 具体的业务逻辑
 * 实现加法
 * 
 * @author xingchencheng
 *
 */

@UserMsgAndExecAnnotation(msgType = MsgType.ADD)
public class UserAddExecutor extends BusinessLogicExecutorBase {

	public void run() {
		UserAddResponse response = new UserAddResponse();
		
		if (this.msgObject instanceof UserAddRequest) {
			UserAddRequest request = (UserAddRequest) this.msgObject;
			double result = request.getLeftNumber() + request.getRightNumber();
			response.setResult(result);
			response.setSuccess(true);
		} else {
			response.setSuccess(false);
		}
		
		System.out.println("服务端处理结果：" + response.getResult());
		channel.writeAndFlush(response);
	}

}
