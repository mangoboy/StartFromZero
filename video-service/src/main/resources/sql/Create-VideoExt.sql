create table t_video_ext
(
	id bigint not null primary key comment '主键',
	video_id bigint not null comment '视频主键',
	click_num bigint not null comment '视频点击量',
	like_num bigint not null comment '视频点赞量',
	collect_num bigint not null comment '视频收藏量',
	share_num bigint not null comment '视频转发数',
	create_by varchar(255) not null comment '创建人',
	create_time timestamp not null default now() comment '创建时间',
	update_by varchar(255) not null comment '更新人',
	update_time timestamp not null default now() comment '更新时间',
	remark varchar(1000) null comment '备注'

) engine=InnoDB default charset=utf8 comment '视频扩展';