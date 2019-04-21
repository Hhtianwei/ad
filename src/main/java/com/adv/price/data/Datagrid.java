package com.adv.price.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**   
 * @Title: Datagrid.java 
 * @Package com.zhuyankeji.bo 
 * @Description: 表格 
 * @author zhangxinchun -------- E-mail: 357597749@qq.com
 * @date 2016年8月17日 上午10:39:46 
 * @version V1.0   
 *  * 版本信息：@version 1.0
 * Copyright (c) 2016 上海艾窠儿电子商务有限公司-版权所有
 */
@Getter
@Setter
@ToString
public class Datagrid {
	
	private long total;
	private long totalPages;
	@SuppressWarnings("rawtypes")
	private List rows;
	@SuppressWarnings("rawtypes")
	private List footer;

	
}
