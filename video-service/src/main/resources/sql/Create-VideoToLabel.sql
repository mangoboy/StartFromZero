create table t_video_to_label
(
	id  varchar (64) not null primary key comment '主键',
	video_id varchar (64) not null comment '视频主键',
	label_id varchar (64) not null comment '标签主键',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '视频-标签对应';