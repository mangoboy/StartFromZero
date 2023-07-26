create table t_career_line
(
	id bigint not null primary key comment '主键',
	name varchar (400) not null comment '事业线名称，确保唯一性',
	name_en varchar (400) not null comment '事业线名称(英文)',
	sort int not null comment '排序',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '事业线分类';