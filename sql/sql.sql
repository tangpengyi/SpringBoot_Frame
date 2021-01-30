/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.23 : Database - jj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jj`;

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `permission_type` varchar(30) DEFAULT NULL COMMENT '权限类型',
  `permission_name` varchar(20) NOT NULL COMMENT '权限姓名',
  `permission_value` varchar(30) DEFAULT NULL,
  `create_user` varchar(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_user` varchar(20) NOT NULL COMMENT '修改人',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`permission_type`,`permission_name`,`permission_value`,`create_user`,`create_time`,`modify_user`,`modify_time`) values (1,'用户查询','用户管理','user:select:*','tpy','2021-01-30 14:19:26','tpy','2021-01-30 14:19:26'),(2,'用户删除','用户管理','user:delete:*','tpy','2021-01-30 14:19:26','tpy','2021-01-30 14:19:26'),(3,'用户新增','用户管理','user:create','tpy','2021-01-30 14:19:26','tpy','2021-01-30 14:19:26'),(4,'用户修改','用户管理','user:modify:*','tpy','2021-01-30 14:19:26','tpy','2021-01-30 14:19:26');

/*Table structure for table `sys_roles` */

DROP TABLE IF EXISTS `sys_roles`;

CREATE TABLE `sys_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type_id` int(11) DEFAULT NULL,
  `role_type` varchar(30) DEFAULT NULL COMMENT '角色类型',
  `role_name` varchar(20) NOT NULL COMMENT '角色姓名',
  `role_value` varchar(20) NOT NULL COMMENT '角色值',
  `create_user` varchar(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_user` varchar(20) NOT NULL COMMENT '修改人',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_roles` */

insert  into `sys_roles`(`id`,`type_id`,`role_type`,`role_name`,`role_value`,`create_user`,`create_time`,`modify_user`,`modify_time`) values (1,1,'用户','用户角色','user','tpy','2021-01-30 14:43:22','tpy','2021-01-30 14:43:22');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `pwd` varchar(200) NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`age`,`account`,`salt`,`pwd`,`create_time`,`create_user`) values (2,'张三',23,'admin',')L)Y9Rn^Ci(M&a5','fdb025ed88d62eb5db670c04fed6e19e','2021-01-23 15:30:33','张三'),(3,'张三',23,'tangpengyi','0dn)DX_q+8I','4a2bde9ce7b8f02fa536d9f1d75cddad','2021-01-25 17:08:01','张三');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `permission` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
