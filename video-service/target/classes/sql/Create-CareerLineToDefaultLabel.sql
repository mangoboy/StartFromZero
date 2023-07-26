create table t_career_line_to_default_label
(
	id bigint not null primary key comment '主键',
	career_line_id bigint not null comment '事业线主键',
	label_id bigint not null comment '标签主键',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '事业线-默认标签对应';