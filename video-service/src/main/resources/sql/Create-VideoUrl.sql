create table t_video_url_info
(
	id  varchar (64) not null primary key comment '主键',
	video_id varchar (64) not null comment '视频主键',
	url varchar (500) not null comment '视频地址',
	stream_type varchar (10) comment '流类型',
	resolution varchar (10) comment '分辨率',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '视频url信息';