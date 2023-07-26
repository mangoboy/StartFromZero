create table t_user
(
	id bigint not null primary key comment '主键',
	user_id decimal not null comment '用户ID',
	name varchar (50) not null comment '用户名',
	number varchar (20) not null comment '用户编码',
	amount decimal not null comment '金额',
	qty decimal not null comment '数量',
	status int not null comment '状态: 0 在职,1离职,',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment 'User';