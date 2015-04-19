package jp.game.server.demo6;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisManager {

	private static JedisManager instance = new JedisManager();
	public static JedisManager getInstance() { return instance; }

	private JedisPool jedisPool = null;

	private JedisManager() {
		initialize();
	}

	private void initialize() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMinIdle(5);
		poolConfig.setMaxTotal(20);
		String host = "localhost";
		int port = 6379;

		JedisPool pool = new JedisPool(poolConfig, host, port);

		// 接続確認
		Jedis jedis = pool.getResource();
		String pingResult = jedis.ping();
		pool.returnResourceObject(jedis);
		this.jedisPool = pool;

		System.out.println("PingResult:" + pingResult);
	}

	private Jedis getJedis() {
		return jedisPool.getResource();
	}
	private void returnJedis(Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResourceObject(jedis);
		}
	}

	/**
	 * 指定されたキー、値を保存
	 * @param key
	 * @param value
	 */
	public void setData(String key, String value) {
		Jedis jedis = getJedis();
		try {
			jedis.set(key, value);
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 指定されたキーのデータを取得
	 * @param key
	 * @return
	 */
	public String getData(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.get(key);
		} finally {
			returnJedis(jedis);
		}
	}
}
