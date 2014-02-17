package com.company.game.dispatcher.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修饰业务逻辑执行方法
 * msgType指定对应的类型，从1开始计数
 * @author xingchencheng
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserHandlerAnnotation {
	short msgType();
}