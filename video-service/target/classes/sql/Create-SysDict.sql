create table t_sys_dict
(
	id  varchar (64) not null primary key comment '主键',
	label varchar (255) not null comment '标签',
	value varchar (255) not null comment '标签值',
	type varchar (255) not null default 'default' comment '类型',
	status tinyint not null default 1 comment '是否启用',
	sort int not null comment '排序',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '系统字典';