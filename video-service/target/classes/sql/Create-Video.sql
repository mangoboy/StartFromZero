create table t_video
(
	id bigint not null primary key comment '主键',
	busi_type int not null comment '业务类型',
	career_line_id bigint not null comment '事业线主键',
	title varchar (500) comment '视频主题',
	video_desc varchar (4000) comment '视频描述',
	cover_url varchar (255) comment '封面图片地址',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '视频';