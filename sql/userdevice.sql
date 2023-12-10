DROP TABLE IF EXISTS `userdevice`;
CREATE TABLE `userdevice` (
                              `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
                              `UserId` int(11) NOT NULL COMMENT '用户id',
                              `DeviceId` varchar(128) NOT NULL COMMENT '设备id',
                              `ClientType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0-安卓 1-ios ',
                              PRIMARY KEY (`Id`),
                              UNIQUE KEY `idx_userid` (`UserId`) USING BTREE
)