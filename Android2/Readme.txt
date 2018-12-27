note:原文件MyApplication0丢弃，现使用app0

Andorid 2 技术实现文档
成员：尹业立 16301054 陈建 16301031

1,手机登录使用：
HttpURLConnection技术
手机端访问服务器，发送账号密码后，接受服务器返回的数据。
若为"true"则表示登录成功
其他（"false"）则表示登录失败

2,手机注册使用：
HttpURLConnection技术
手机端访问服务器，发送账号密码后，接受服务器返回的数据。
若为"true"则表示注册成功
其他（"false"）则表示注册失败

3,服务器：
使用tomcat作为服务器，服务器端使用servlet验证，数据库使用Mysql

4,通告界面布局：
RecyclerView+CardView.