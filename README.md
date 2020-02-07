#logistics-manager
聚合类子工程，打包方式pom
继承logistics-parent工程
依赖logistics-common工程

子工程
logistics-manager-pojo 打包方式jar
logistics-manager-dao  打包方式jar  直接依赖pojo
logistics-manager-service  打包方式jar  直接依赖dao
logistics-manager-web  打包方式war  直接依赖service