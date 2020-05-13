package cn.chuxiao.designprinciple.isp.case3;

/**
 * 设计了两个功能非常单一的接口：Updater 和 Viewer。
 * ScheduledUpdater只依赖Updater这个跟热更新相关的接口,不需要被强迫去依赖不需要的Viewer接口，满足接口隔离原则。
 * 同理，SimpleHttpServer只依赖跟查看信息相关的Viewer接口，不依赖不需要的Updater接口，也满足接口隔离原则
 * <p>
 * 设计思路更加灵活、易扩展、易复用
 * <p>
 * 如果不遵守接口隔离原则，不设计Updater和Viewer两个小接口，而是设计一个大而全的Config接口
 * 会在代码实现上做一些无用功，修改改动多
 */
public class Application {

    private static ConfigSource configSource = new ZookeeperConfigSource();

    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final MysqlConfig mysqlConfig = new MysqlConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 300, 300);
        redisConfigUpdater.run();
        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 60, 60);
        kafkaConfigUpdater.run();
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 20000);
        simpleHttpServer.addViewers("/config", redisConfig);
        simpleHttpServer.addViewers("/config", mysqlConfig);
        simpleHttpServer.run();
    }

}
