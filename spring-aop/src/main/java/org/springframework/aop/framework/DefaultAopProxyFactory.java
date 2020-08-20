/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework;

import org.springframework.aop.SpringProxy;

import java.io.Serializable;
import java.lang.reflect.Proxy;

/**
 * Default {@link AopProxyFactory} implementation, creating either a CGLIB proxy
 * or a JDK dynamic proxy.
 *
 * <p>Creates a CGLIB proxy if one the following is true for a given
 * {@link AdvisedSupport} instance:
 * <ul>
 * <li>the {@code optimize} flag is set
 * <li>the {@code proxyTargetClass} flag is set
 * <li>no proxy interfaces have been specified
 * </ul>
 *
 * <p>In general, specify {@code proxyTargetClass} to enforce a CGLIB proxy,
 * or specify one or more interfaces to use a JDK dynamic proxy.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 12.03.2004
 * @see AdvisedSupport#setOptimize
 * @see AdvisedSupport#setProxyTargetClass
 * @see AdvisedSupport#setInterfaces
 */
@SuppressWarnings("serial")
public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {

	@Override
	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
		/**
		 * 1. optimize: 用来控制通过 CGLIB 创建的代理是否使用激进的策略。除非完全了解 AOP 代理如何优化，否则不推荐用户设置。仅對 CGLIB 生效，對 JDK 无效
		 * 2. proxyTargetClass: 这个属性为 true 时，使用 CGLIB 對目标类本身进行代理
		 * 3. hasNoUserSuppliedProxyInterfaces： 是否存在代理接口
		 *
		 * ========================================================================================================================
		 * 1. 如果目标对象实现了接口，默认情况下會采用 JDK 的动态代理实现 AOP
		 * 2. 如果目标对象实现了接口，可以强制使用 CGLIB 实现 AOP
		 * 3. 如果目标对象没有实现接口，必须采用 CGLIB库， Spring 会自动在 JDK 动态代理和 CGLIB 之间转换
		 *
		 * ========================================================================================================================
		 * 如何强制使用 CGLIB 实现 AOP
		 * 1. 添加 CGLIB 依赖
		 * 2. proxyTargetClass = true
		 *
		 * ========================================================================================================================
		 * JDK 动态代理和 CGLIB 字节码生成的区别
		 * 1. JDK 动态代理总股本不过对实现零接口的类生成代理，不能针对类。底层继承 proxy，java是单继承
		 * 2. CGLIB 是针类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，因为是继承，所以改类或者方法最好不好声明成 final
		 *
		 */

		if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
			Class<?> targetClass = config.getTargetClass();
			if (targetClass == null) {
				throw new AopConfigException("TargetSource cannot determine target class: " +
						"Either an interface or a target is required for proxy creation.");
			}
			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
				return new JdkDynamicAopProxy(config);
			}
			return new ObjenesisCglibAopProxy(config);
		}
		else {
			return new JdkDynamicAopProxy(config);
		}
	}

	/**
	 * Determine whether the supplied {@link AdvisedSupport} has only the
	 * {@link org.springframework.aop.SpringProxy} interface specified
	 * (or no proxy interfaces specified at all).
	 */
	private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
		Class<?>[] ifcs = config.getProxiedInterfaces();
		return (ifcs.length == 0 || (ifcs.length == 1 && SpringProxy.class.isAssignableFrom(ifcs[0])));
	}

}
