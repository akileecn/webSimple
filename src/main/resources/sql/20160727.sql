alter table zp_notice add is_new bit default 1; -- 是否为新通知
update zp_notice set is_new=1 where is_new is null;