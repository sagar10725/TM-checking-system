INSERT INTO `tmsystem`.`user` (`email`, `name`, `password`, `status`, `username`, `verificationCode`) VALUES ('admin@gmail.com', 'Administrator', '$2a$10$s4MhriPMX/gUa/TXOoZmC.b9CYca2oPDTarrDOX6B8Nsdb9FzbMiy', '1', 'admin', NULL);

INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('2', 'ROLE_TMCHECKER');
INSERT INTO `tmsystem`.`role` (`id`, `roleType`) VALUES ('3', 'ROLE_STUDENT');

INSERT INTO `tmsystem`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `tmsystem`.`user_role` (`user_id`, `role_id`) VALUES ('1', '2');

INSERT INTO `tmsystem`.`user` (`email`, `name`, `password`, `status`, `username`, `verificationCode`) VALUES ('tmchecker@gmail.com', 'TM Checker', '$2a$10$s4MhriPMX/gUa/TXOoZmC.b9CYca2oPDTarrDOX6B8Nsdb9FzbMiy', '1', 'tmchecker', NULL);

INSERT INTO `tmsystem`.`user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `tmsystem`.`tmchecker` (`user_id`) VALUES ('1');
INSERT INTO `tmsystem`.`tmchecker` (`user_id`) VALUES ('2');

INSERT INTO `tmsystem`.`defaultchecking_seats` (`checkingType`, `number_of_seats`) VALUES ('INDIVIDUAL', '1');
INSERT INTO `tmsystem`.`defaultchecking_seats` (`checkingType`, `number_of_seats`) VALUES ('GROUP', '4');



