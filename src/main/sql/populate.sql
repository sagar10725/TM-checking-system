INSERT INTO `tmsystem`.`user` (`email`, `name`, `password`, `status`, `username`, `verificationCode`) VALUES ('chandra.panday.5@gmail.com', 'Chandra Prakash Panday', '$2a$10$s4MhriPMX/gUa/TXOoZmC.b9CYca2oPDTarrDOX6B8Nsdb9FzbMiy', '1', 'admin', NULL);

INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('2', 'ROLE_TMCHECKER');
INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('3', 'ROLE_STUDENT');

INSERT INTO `tmsystem`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `tmsystem`.`user_role` (`user_id`, `role_id`) VALUES ('1', '2');
