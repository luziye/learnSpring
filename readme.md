#用python代码写个数据库备份的脚本，暂定mysql。可以用dump也可以用其他方式：
#!/usr/bin/env bash

# 全备份数据

./mysqldump -h localhost -uroot -ppassword -P 3306 demo > /Users/kaiyang/demo.sql

# 压缩备份

./mysqldump -h localhost -uroot -ppassword -P 3306 demo | gzip > /Users/kaiyang/demo.sql.gz

# 存入score, user表

./mysqldump -h localhost -uroot -ppassword -P 3306 demo  score user> /Users/kaiyang/demo.sql

# 备份数据库结构,不备份数据

./mysqldump -h localhost -uroot -ppassword -P 3306 --no-data  demo> /Users/kaiyang/demo.sql

# 同时备份多个库

./mysqldump -h localhost -uroot -ppassword -P 3306 --databases demo user> /Users/kaiyang/demo.sql

