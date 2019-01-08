# yzblog

该项目是一个典型的由springcloud管理的微服务项目，主要包括如下模块

|     服务名     | 父级依赖 | 模块说明 |
| :------------: | :------: | :------: |
| yzblog_parent  |    无    |  父工程  |
| yzblog_common  |  parent  |  通用包  |
|  yzblog_base   |  parent  | 基础服务 |
| yzblog_article |  parent  | 文章服务 |
|  yzblog_faqs   |  parent  | 问答服务 |
| yzblog_search  |  parent  | 搜索服务 |
|   yzblog_sms   |  parent  | 短信服务 |
|                |          |       |

1. 用户服务
   - [x] 登录注册
   - [x] 单点登 录
   - [x] 找回 / 修改 密码
   - [x] 每天推送天气信息
   - [ ] 根据注册的IP地址智能推荐附近的信息（已完成天气推送）
2. 评论服务
   - [x] 保存 / 缓存取拿
   - [x] 父评论自评论组装显示
   - [ ] 热评分析智能推荐
   - [ ] 评论点赞
3. 天气服务
   - [x] 根据城市ID / 名称 取天气信息